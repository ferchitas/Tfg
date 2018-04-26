package lectorJson;

import org.json.JSONObject;

import esquemas.Esquema;

public abstract class Constructor {

	private Esquema esquema;

	public Esquema getEsquema() {
		return esquema;
	}

	public void setEsquema(Esquema esquema) {
		this.esquema = esquema;
	}
	
	public abstract void crearEsquema(JSONObject json);
}
