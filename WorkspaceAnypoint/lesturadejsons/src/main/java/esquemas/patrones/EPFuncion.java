package esquemas.patrones;

import java.util.ArrayList;

public class EPFuncion extends EPExpresion{

	private String nombreFuncion;
	protected ArrayList<EPExpresion> expresiones;

	public String getNombreFuncion() {
		return nombreFuncion;
	}

	public void setNombreFuncion(String funcion) {
		this.nombreFuncion = funcion;
	}

	public ArrayList<EPExpresion> getExpresiones() {
		return expresiones;
	}

	public void setExpresiones(ArrayList<EPExpresion> expresiones) {
		this.expresiones = expresiones;
	}

	@Override
	public String toString() {
		
		StringBuilder bld = new StringBuilder();
		bld.append(this.getNombreFuncion() + "(");
		for (int i = 0; i < expresiones.size() - 1; ++i) {
			bld.append(expresiones.get(i).toString() + ", ");
		}
		if(!expresiones.isEmpty()) bld.append(expresiones.get(expresiones.size() - 1).toString());
		bld.append(")");
		if(!this.getPseudonombre().equals("")) bld.append(" as " + this.getPseudonombre());
		return bld.toString();
	}
}
