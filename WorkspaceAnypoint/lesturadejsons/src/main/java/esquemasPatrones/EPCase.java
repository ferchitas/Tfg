package esquemasPatrones;

import java.util.ArrayList;

public class EPCase extends EPExpresion{
	
	private String valor;
	private ArrayList<EPExpresion> condiciones;
	private String resultadoPorDefecto;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public ArrayList<EPExpresion> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(ArrayList<EPExpresion> condiciones) {
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
		
		String resultado = "case ";
		if(this.getValor() != null) resultado = resultado + this.getValor();
		resultado = resultado + this.toStringExpresiones(this.getCondiciones());
		if(this.getResultadoPorDefecto() != null) resultado = "" + resultado + "\nelse " + this.getResultadoPorDefecto();
		resultado = resultado + "\nend";
		return resultado;
	}
	
	@Override
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones) {
		
		String resultado = "";
		for(int i = 0; i < expresiones.size(); i++){
			
			resultado = resultado + "\n" + this.getCondiciones().get(i).toString();
		}
		return resultado;
	}
	@Override
	public ArrayList<EPExpresion> getExpresiones() {
		// TODO Auto-generated method stub
		ArrayList<EPExpresion> a = new ArrayList<EPExpresion>();
		return a;
	}
}
