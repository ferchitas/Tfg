package esper;

import java.util.Map;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.ConfigurationOperations;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import esquemas.*;
import esquemas.eventos.EsquemaEvento;
import esquemas.patrones.EsquemaPatron;


public class AccesoMotorEsper {

	private static AccesoMotorEsper acceso;
	private static Configuration cepConfig;
	private EPRuntime cepRT;
	private EPAdministrator cepAdm;
	private EPStatement patronEpl;
	
	private AccesoMotorEsper(){
		
		obtenerConfiguracion();
	}
	
	public static AccesoMotorEsper obtenerAccesoMotorEsper(){
		
		if(acceso == null) acceso = new AccesoMotorEsper();
		return acceso;
		}
	
	private static Configuration obtenerConfiguracion(){
		
	if(cepConfig == null) cepConfig = new Configuration();
	return cepConfig;
	}
	
	public void setUpAcceso(){
		
		EPServiceProvider epService;
		epService = EPServiceProviderManager.getProvider("Motor1", cepConfig);
		setCepRT(epService.getEPRuntime());
		this.cepAdm = epService.getEPAdministrator();
	}
	
	public void agregarEsquema(Esquema ev){
		
		ev.agregarEsquema(this, ev);
	}
	
	public void agregarEvento(EsquemaEvento esquema){
		
		cepConfig.addEventType(esquema.getNombreEvento(), esquema.toMap(), esquema.eventoConfiguracion());

	}
	
	public void agregarPatron(EsquemaPatron esquema){
		
		patronEpl = cepAdm.createEPL(esquema.toString());
		patronEpl.addListener(new CEPListener());
	}
	
	public void enviarEvento(Map <String, Object> ev, String nombreEv){
		
		cepRT.sendEvent(ev, nombreEv);
	}
	
	public void agregarPatronEPL(String patron){
		
		patronEpl = cepAdm.createEPL(patron);
		patronEpl.addListener(new CEPListener());
	}

	public EPRuntime getCepRT() {
		return cepRT;
	}

	public void setCepRT(EPRuntime cepRT) {
		this.cepRT = cepRT;
	}
	
	public EPStatement getEPStatement() {
		return this.patronEpl;
	}
	
	public ConfigurationOperations getCepConfig() {
		return EPServiceProviderManager.getDefaultProvider(cepConfig).getEPAdministrator().getConfiguration();
	}
}
