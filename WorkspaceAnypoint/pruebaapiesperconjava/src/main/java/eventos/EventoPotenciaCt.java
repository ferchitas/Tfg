package eventos;

public class EventoPotenciaCt {
	
	private String timestamp;
	private int identificadorCt;
	private double potencia;
	private int planta;
	
	public EventoPotenciaCt(String timestamp, int identificadorCt, double potencia, int planta){
		
		this.setTimestamp(timestamp);
		this.setIdentificadorCt(identificadorCt);
		this.setPotencia(potencia);
		this.setPlanta(planta);
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getIdentificadorCt() {
		return identificadorCt;
	}

	public void setIdentificadorCt(int identificadorCt) {
		this.identificadorCt = identificadorCt;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

}
