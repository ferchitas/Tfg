package lector.json;

import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONObject;

import esquemas.eventos.EEPropiedad;
import esquemas.eventos.EsquemaEvento;

public class ConstructorEvento extends Constructor {

	@Override
	public void crearEsquema(JSONObject json) {

		EsquemaEvento evento = new EsquemaEvento();
		evento.setNombreEvento(json.getString("nombreEvento"));
		evento.setInicioTimeStamp(json.getString("inicioTimeStamp"));
		evento.setFinalTimeStamp(json.getString("finalTimeStamp"));
		evento.setPropiedades(this.crearPropiedades(json));
		evento.setEventosHeredados(this.crearEventosHeredados(json));
		evento.setEventosCopiados(this.crearEventosCopiados(json));
		this.setEsquema(evento);
	}
	
	public ArrayList<EEPropiedad> crearPropiedades(JSONObject json){
		
		ArrayList<EEPropiedad> propiedades = new ArrayList<>();
		
		for (int i = 0; i < json.getJSONArray("propiedades").length(); ++i) {
		    EEPropiedad propiedad = new EEPropiedad();
			JSONObject jPropiedad = json.getJSONArray("propiedades").getJSONObject(i);
		    propiedad.setNombre(jPropiedad.getString("nombre"));
		    propiedad.setValor(this.stringAObjeto(jPropiedad.getString("valor")));
		    propiedades.add(propiedad);
		}
		return propiedades;
	}
	
	public Object stringAObjeto(String str){
    	switch(str){
    	
    	case "int":
    		return int.class;
    	case "String":
    		return String.class;
    	case "double":
    		return double.class;
    	case "date":
    		return Date.class;
    	default: 
    		return null;
    	}
    }
	
	public ArrayList<String> crearEventosHeredados(JSONObject json){
		
		ArrayList<String> eh = new ArrayList<>();
		for (int i = 0; i < json.getJSONArray("eventosHeredados").length(); ++i) {
			String stringEH = json.getJSONArray("eventosHeredados").getString(i);
		    eh.add(stringEH);
		}
		return eh;
	}
	
	public ArrayList<String> crearEventosCopiados(JSONObject json){
		
		ArrayList<String> ec = new ArrayList<>();
		for (int i = 0; i < json.getJSONArray("eventosCopiados").length(); ++i) {
			String stringEC = json.getJSONArray("eventosCopiados").getString(i);
		    ec.add(stringEC);
		}
		return ec;
	}
}
