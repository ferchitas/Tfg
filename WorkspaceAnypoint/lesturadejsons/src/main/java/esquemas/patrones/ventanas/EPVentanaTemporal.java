package esquemas.patrones.ventanas;

public class EPVentanaTemporal extends EPVentana {

	private String unidadTemporal;
	
	@Override
	public String toString() {
		
		return "win:" + this.getNombre() + "(" + this.getValor() + " " + this.getUnidadTemporal() + ") " + this.getPseudonombre();
	}

	public String getUnidadTemporal() {
		return unidadTemporal;
	}

	public void setUnidadTemporal(String unidadTemporal) {
		this.unidadTemporal = unidadTemporal;
	}

}
