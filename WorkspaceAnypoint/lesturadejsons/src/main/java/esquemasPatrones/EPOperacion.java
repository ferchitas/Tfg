package esquemasPatrones;

import java.util.ArrayList;

public class EPOperacion extends EPExpresion{

	private String operador;
	private ArrayList<EPExpresion> expresiones;

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
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
		for (int i = 0; i < expresiones.size() - 1; ++i) {
			resultado = resultado + expresiones.get(i).toString() + " " + this.getOperador() + " ";
		}
		if(expresiones.size() != 0) resultado = resultado + expresiones.get(expresiones.size() - 1);
		return resultado;
	}
	
	public String toStringExpresiones(ArrayList<EPExpresion> expresiones){
		
		String resultado = "";
		for (int i = 0; i < expresiones.size(); ++i) {
			resultado = resultado + this.toStringExpresion(expresiones.get(i));
		}
		return resultado;
	}
	
	public String toStringExpresion(EPExpresion operacion){
		
		String resultado = "";
		
		resultado = resultado +
				this.toStringExpresiones(operacion.getExpresiones()) + 
				this.getOperador();
		return resultado;
	}
}
