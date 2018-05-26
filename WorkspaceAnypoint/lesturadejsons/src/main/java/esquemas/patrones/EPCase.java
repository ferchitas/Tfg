package esquemas.patrones;

import java.util.ArrayList;

public class EPCase extends EPExpresion{
	
	private String valor;
	private ArrayList<EPExpresion> condiciones;
	private String resultadoPorDefecto;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public ArrayList<EPExpresion> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(ArrayList<EPExpresion> condiciones) {
		this.condiciones = condiciones;
	}
	public String getResultadoPorDefecto() {
		return resultadoPorDefecto;
	}
	public void setResultadoPorDefecto(String resultadoPorDefecto) {
		this.resultadoPorDefecto = resultadoPorDefecto;
	}
	@Override
	public String toString() {
		
		StringBuilder bld = new StringBuilder();
		bld.append("case ");
		if(this.getValor() != null) bld.append(this.getValor());
		for(int i = 0; i < this.getCondiciones().size(); i++){
			
			bld.append("\n" + this.getCondiciones().get(i).toString());
		}
		if(this.getResultadoPorDefecto() != null) bld.append("\nelse " + this.getResultadoPorDefecto());
		bld.append("\nend");
		return bld.toString();
	}
}
