package esquemas.patrones;

public class EPPropiedadEvery extends EPPropiedad {

	private String siguienteExpresion;

	public String getSiguienteExpresion() {
		return siguienteExpresion;
	}

	public void setSiguienteExpresion(String siguienteExpresion) {
		this.siguienteExpresion = siguienteExpresion;
	}
	
	@Override
	public String toString() {
		
		String resultado = "";
		if(!this.getSiguienteExpresion().equals(this.getNombre()) && !this.getSiguienteExpresion().equals("")){
			resultado = "(";
		}
		if(!this.getPseudonombre().equals("")){
			
			resultado = resultado + this.getNombre() + " as " + this.getPseudonombre();
		}
		else{
			resultado = resultado + this.getNombre();
		}
		
		if(this.getSiguienteExpresion().equals(this.getNombre())){
			resultado = resultado + ")";
		}
		return resultado;
	}
}
