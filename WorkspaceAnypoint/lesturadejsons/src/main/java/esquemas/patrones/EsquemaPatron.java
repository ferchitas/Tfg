package esquemas.patrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import esper.AccesoMotorEsper;
import esquemas.Esquema;

public class EsquemaPatron extends Esquema{

	private String nombrePatron;
	private ArrayList<EPExpresion> expresionesSelect;
	private ArrayList<EPExpresion> expresionesFrom;
	private ArrayList<EPExpresion> expresionesWhere;
	private ArrayList<EPExpresion> expresionesGroupBy;
	private ArrayList<EPExpresion> expresionesHaving;
	private ArrayList<EPExpresion> expresionesOutput;
	private ArrayList<EPExpresion> expresionesOrderBy;
	private ArrayList<EPExpresion> expresionesLimit;
	
	@Override
	public Map<String, Object> toMap() {
		
		return new HashMap<String, Object>();
	}
	
	@Override
	public String toString(){
		
		return "insert into " + this.getNombrePatron() + " " + 
				"select " + this.toStringExpresiones(this.getExpresionesSelect()) + 
				" from " + this.toStringExpresiones(this.getExpresionesFrom()) +
				" group by " + this.toStringExpresiones(this.getExpresionesGroupBy());
	}
	
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones){
		
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < expresiones.size(); ++i) {
			if(!bld.toString().equals("")){
				
				bld.append(", " + expresiones.get(i).toString());
			}
			else{
				
				bld.append(expresiones.get(i).toString());	
			}
		}
		return bld.toString();
	}

	public String getNombrePatron() {
		return nombrePatron;
	}


	public void setNombrePatron(String nombrePatron) {
		this.nombrePatron = nombrePatron;
	}


	public ArrayList<EPExpresion> getExpresionesSelect() {
		return expresionesSelect;
	}


	public void setExpresionesSelect(ArrayList<EPExpresion> expresionesSelect) {
		this.expresionesSelect = expresionesSelect;
	}


	public ArrayList<EPExpresion> getExpresionesFrom() {
		return expresionesFrom;
	}


	public void setExpresionesFrom(ArrayList<EPExpresion> expresionesFrom) {
		this.expresionesFrom = expresionesFrom;
	}


	public ArrayList<EPExpresion> getExpresionesWhere() {
		return expresionesWhere;
	}


	public void setExpresionesWhere(ArrayList<EPExpresion> expresionesWhere) {
		this.expresionesWhere = expresionesWhere;
	}


	public ArrayList<EPExpresion> getExpresionesGroupBy() {
		return expresionesGroupBy;
	}


	public void setExpresionesGroupBy(ArrayList<EPExpresion> expresionesGroupBy) {
		this.expresionesGroupBy = expresionesGroupBy;
	}


	public ArrayList<EPExpresion> getExpresionesHaving() {
		return expresionesHaving;
	}


	public void setExpresionesHaving(ArrayList<EPExpresion> expresionesHaving) {
		this.expresionesHaving = expresionesHaving;
	}


	public ArrayList<EPExpresion> getExpresionesOutput() {
		return expresionesOutput;
	}


	public void setExpresionesOutput(ArrayList<EPExpresion> expresionesOutput) {
		this.expresionesOutput = expresionesOutput;
	}


	public ArrayList<EPExpresion> getExpresionesOrderBy() {
		return expresionesOrderBy;
	}


	public void setExpresionesOrderBy(ArrayList<EPExpresion> expresionesOrderBy) {
		this.expresionesOrderBy = expresionesOrderBy;
	}


	public ArrayList<EPExpresion> getExpresionesLimit() {
		return expresionesLimit;
	}


	public void setExpresionesLimit(ArrayList<EPExpresion> expresionesLimit) {
		this.expresionesLimit = expresionesLimit;
	}

	@Override
	public void agregarEsquema(AccesoMotorEsper ame, Esquema esquema) {

		ame.setUpAcceso();
		ame.agregarPatron((EsquemaPatron) esquema); 
	}

}
