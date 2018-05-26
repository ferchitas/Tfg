package esquemas.patrones.ventanas;

import esquemas.patrones.EPExpresion;

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
}
