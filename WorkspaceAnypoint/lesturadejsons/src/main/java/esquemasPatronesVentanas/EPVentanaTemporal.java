package esquemasPatronesVentanas;

import java.util.ArrayList;

import esquemasPatrones.EPExpresion;

public class EPVentanaTemporal extends EPVentana {

	private String unidadTemporal;
	
	@Override
	public String toString() {
		
		return "win:" + this.getNombre() + "(" + this.getValor() + " " + this.getUnidadTemporal() + ") " + this.getPseudonombre();
	}

	@Override
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones) {

		return this.toString();
	}

	@Override
	public ArrayList<EPExpresion> getExpresiones() {
		
		ArrayList<EPExpresion> a = new ArrayList<>();
		return a;
	}

	public String getUnidadTemporal() {
		return unidadTemporal;
	}

	public void setUnidadTemporal(String unidadTemporal) {
		this.unidadTemporal = unidadTemporal;
	}

}
