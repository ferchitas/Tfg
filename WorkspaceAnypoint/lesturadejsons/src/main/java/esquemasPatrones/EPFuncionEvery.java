package esquemasPatrones;

public class EPFuncionEvery extends EPFuncion {

	@Override
	public String toString() {
		
		String resultado = "";
		resultado = resultado + this.getNombreFuncion() + " ";
		for (int i = 0; i < expresiones.size() - 1; ++i) {
			resultado = resultado + expresiones.get(i).toString() + " ";
		}
		if(expresiones.size() != 0) resultado = resultado + expresiones.get(expresiones.size() - 1).toString();
		return resultado + "";
	}
}
