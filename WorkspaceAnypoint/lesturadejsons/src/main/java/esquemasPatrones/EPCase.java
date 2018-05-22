package esquemasPatrones;

import java.util.ArrayList;

public class EPCase extends EPExpresion{
	
	private String valor;
	private ArrayList<When> condiciones;
	private String resultadoPorDefecto;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public ArrayList<When> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(ArrayList<When> condiciones) {
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<EPExpresion> getExpresiones() {
		// TODO Auto-generated method stub
		ArrayList<EPExpresion> a = new ArrayList<EPExpresion>();
		return a;
	}
}
