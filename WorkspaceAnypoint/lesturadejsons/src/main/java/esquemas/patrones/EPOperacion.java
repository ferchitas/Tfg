package esquemas.patrones;

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
		
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < expresiones.size() - 1; ++i) {
			bld.append(expresiones.get(i).toString() + " " + this.getOperador() + " ");
		}
		if(!expresiones.isEmpty()) bld.append(expresiones.get(expresiones.size() - 1));
		return bld.toString();
	}
}
