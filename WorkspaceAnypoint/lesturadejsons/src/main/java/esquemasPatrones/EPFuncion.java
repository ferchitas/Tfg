package esquemasPatrones;

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
		
		String resultado = "";
		resultado = resultado + this.getNombreFuncion() + "(";
		for (int i = 0; i < expresiones.size() - 1; ++i) {
			resultado = resultado + expresiones.get(i).toString() + ", ";
		}
		if(expresiones.size() != 0) resultado = resultado + expresiones.get(expresiones.size() - 1).toString();
		resultado = resultado + ")";
		if(!this.getPseudonombre().equals("")) resultado = resultado + " as " + this.getPseudonombre();
		return resultado;
	}

	@Override
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones) {
		// TODO Auto-generated method stub
		return null;
	}
}
