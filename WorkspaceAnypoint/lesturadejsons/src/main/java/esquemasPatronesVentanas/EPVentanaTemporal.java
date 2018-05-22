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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EPExpresion> getExpresiones() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUnidadTemporal() {
		return unidadTemporal;
	}

	public void setUnidadTemporal(String unidadTemporal) {
		this.unidadTemporal = unidadTemporal;
	}

}
