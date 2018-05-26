package esquemas.patrones;

import esquemas.patrones.ventanas.EPVentana;

public class EPPropiedad extends EPExpresion{

	private String nombre;
	private EPVentana ventana;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		
		String resultado = this.getNombre();
		if(this.getVentana() != null){
			
			resultado = resultado + "." + this.getVentana().toString();
		}
		if(!this.getPseudonombre().equals("")){
			
			resultado = resultado + " as " + this.getPseudonombre();
		}
		return resultado;
	}

	public EPVentana getVentana() {
		return ventana;
	}

	public void setVentana(EPVentana ventana) {
		this.ventana = ventana;
	}

}
