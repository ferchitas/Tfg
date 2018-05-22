package esquemas;

import java.util.Map;

import esper.AccesoMotorEsper;


public abstract class Esquema {

	public abstract Map<String, Object> toMap();
	public abstract String toString();
	public abstract void agregarEsquema(AccesoMotorEsper ame, Esquema esquema);
}
