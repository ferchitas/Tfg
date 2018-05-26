package esquemas.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.espertech.esper.client.ConfigurationEventTypeMap;

import esper.AccesoMotorEsper;
import esquemas.Esquema;

public class EsquemaEvento extends Esquema {
	
    private String nombreEvento;

    private ArrayList<String> eventosHeredados;

    private ArrayList<EEPropiedad> propiedades;

    private String finalTimeStamp;

    private String inicioTimeStamp;

    private ArrayList<String> eventosCopiados;

    public String getNombreEvento ()
    {
        return nombreEvento;
    }

    public void setNombreEvento (String nombreEvento)
    {
        this.nombreEvento = nombreEvento;
    }

    public ArrayList<String> getEventosHeredados ()
    {
        return eventosHeredados;
    }

    public void setEventosHeredados (ArrayList<String> eventosHeredados)
    {
        this.eventosHeredados = eventosHeredados;
    }

    public ArrayList<EEPropiedad> getPropiedades ()
    {
        return propiedades;
    }

    public void setPropiedades (ArrayList<EEPropiedad> propiedades)
    {
        this.propiedades = propiedades;
    }

    public String getFinalTimeStamp ()
    {
        return finalTimeStamp;
    }

    public void setFinalTimeStamp (String finalTimeStamp)
    {
        this.finalTimeStamp = finalTimeStamp;
    }

    public String getInicioTimeStamp ()
    {
        return inicioTimeStamp;
    }

    public void setInicioTimeStamp (String inicioTimeStamp)
    {
        this.inicioTimeStamp = inicioTimeStamp;
    }

    public ArrayList<String> getEventosCopiados ()
    {
        return eventosCopiados;
    }

    public void setEventosCopiados (ArrayList<String> eventosCopiados)
    {
        this.eventosCopiados = eventosCopiados;
    }

    @Override
    public String toString()
    {
        return "create schema " +this.nombreEvento + " " + 
        this.toStringPropiedades() + " " + 
        "inherits " + this.toStringEventos(this.eventosHeredados) + " " +
        "starttimestamp " + this.inicioTimeStamp + " " +
        "endtimestamp " + this.finalTimeStamp + " " +
        "copyfrom " + this.toStringEventos(this.eventosCopiados) + " ";
    }
    
    private String toStringEventos(ArrayList<String> eventos){
    	
    	String sEventos;
    	StringBuilder bld = new StringBuilder();
    	if(!eventos.isEmpty()){
    		bld.append(eventos.get(0));
    	}
    	for(int i = 1; i < eventos.size(); i++){
    		bld.append(", " + eventos.get(i));
    	}
    	sEventos = bld.toString();
    	return sEventos;
    }
    
    private String toStringPropiedades(){
    	
    	String sPropiedades;
    	StringBuilder bld = new StringBuilder();
    	if(!this.propiedades.isEmpty()){
    		bld.append(this.propiedades.get(0).getNombre() + " " + this.propiedades.get(0).getValor());
    	}
    	for(int i = 1; i < this.propiedades.size(); i++){
    		bld.append((", " + this.propiedades.get(i).getNombre() + " " + this.propiedades.get(i).getValor()));
        }
    	sPropiedades = bld.toString();
    	return sPropiedades;
    }

    @Override
    public Map<String,Object> toMap(){
    	
    	Map<String,Object> eventoMapeado = new HashMap<>();
    	for(EEPropiedad propiedad: this.propiedades){
    		eventoMapeado.put(propiedad.getNombre(), propiedad.getValor());
    	}
    	return eventoMapeado;
	}
    
    public ConfigurationEventTypeMap eventoConfiguracion(){
    	
    	Set<String> superTipos = new HashSet<>(this.eventosHeredados);
    	ConfigurationEventTypeMap config = new ConfigurationEventTypeMap();
    	config.setStartTimestampPropertyName(this.inicioTimeStamp);
    	config.setEndTimestampPropertyName(this.finalTimeStamp);
    	config.setSuperTypes(superTipos);
    	
    	return config;
    }

	@Override
	public void agregarEsquema(AccesoMotorEsper ame, Esquema esquema) {

		ame.agregarEvento((EsquemaEvento) esquema);	
		ame.setUpAcceso();
	}
}
