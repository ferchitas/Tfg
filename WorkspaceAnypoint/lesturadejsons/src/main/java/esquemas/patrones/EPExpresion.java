package esquemas.patrones;

public abstract class EPExpresion {

	private String pseudonombre; //nombre que se le puede dar a una expresion, a�adiendole el "as".

	public String getPseudonombre() {
		return pseudonombre;
	}

	public void setPseudonombre(String pseudonombre) {
		this.pseudonombre = pseudonombre;
	}
	
	@Override
	public abstract String toString();
}
