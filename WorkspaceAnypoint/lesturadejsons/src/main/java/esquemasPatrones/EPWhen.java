package esquemasPatrones;

import java.util.ArrayList;

public class EPWhen extends EPExpresion{

	private String condicion;
	private String resultado;
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	@Override
	public String toString(){
		
		return "when " + this.getCondicion() + " then " + this.getResultado();
	}
	@Override
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones) {
		// TODO Auto-generated method stub
		return this.toString();
	}
	@Override
	public ArrayList<EPExpresion> getExpresiones() {
		// TODO Auto-generated method stub
		return null;
	}
}
