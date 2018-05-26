package esquemas.patrones;

public class EPFuncionEvery extends EPFuncion {

	@Override
	public String toString() {
		
		StringBuilder bld = new StringBuilder();
		bld.append(this.getNombreFuncion() + " ");
		for (int i = 0; i < expresiones.size() - 1; ++i) {
			bld.append(expresiones.get(i).toString() + " ");
		}
		if(!expresiones.isEmpty()) bld.append(expresiones.get(expresiones.size() - 1).toString());
		return bld.toString();
	}
}
