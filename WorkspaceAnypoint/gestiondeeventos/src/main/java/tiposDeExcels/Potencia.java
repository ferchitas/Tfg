package tiposDeExcels;

public class Potencia extends Excel {

	@Override
	public void getTipo(String ruta) {
		
		this.ponerNombreYruta(ruta);
		this.setWorkbook(this.crearExcel(this.getRuta()));
	}

}
