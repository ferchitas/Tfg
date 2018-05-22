package esquemasPatrones;

import java.util.ArrayList;

public abstract class EPExpresion {

	private String pseudonombre; //nombre que se le puede dar a una expresion, añadiendole el "as".

	public String getPseudonombre() {
		return pseudonombre;
	}

	public void setPseudonombre(String pseudonombre) {
		this.pseudonombre = pseudonombre;
	}
	
	@Override
	public abstract String toString();
	public abstract String toStringExpresiones(ArrayList<EPExpresion> expresiones);
	public abstract ArrayList<EPExpresion> getExpresiones();
}
