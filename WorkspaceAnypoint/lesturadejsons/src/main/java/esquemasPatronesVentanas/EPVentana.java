package esquemasPatronesVentanas;

import java.util.ArrayList;

import esquemasPatrones.EPExpresion;

public class EPVentana extends EPExpresion {

	private String nombre;
	private String valor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		
		return "win:" + this.getNombre() + "(" + this.getValor() + ") " + this.getPseudonombre();
	}

	@Override
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones) {
		// TODO Auto-generated method stub
		return this.toString();
	}

	@Override
	public ArrayList<EPExpresion> getExpresiones() {

		ArrayList<EPExpresion> a = new ArrayList<EPExpresion>();
		return a;
	}
}
