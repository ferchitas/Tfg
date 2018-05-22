package esper;

import java.util.Map;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import esquemas.*;
import esquemasEventos.EsquemaEvento;
import esquemasPatrones.EsquemaPatron;


public class AccesoMotorEsper {

	private static AccesoMotorEsper acceso;
	private static Configuration cepConfig;
	private EPServiceProvider epService;
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
	
	public void SetUpAcceso(){
		
		this.epService = EPServiceProviderManager.getProvider("Motor1", cepConfig);
		setCepRT(this.epService.getEPRuntime());
		this.cepAdm = this.epService.getEPAdministrator();
	}
	
	public void mostrarEventosAgregados(){
		
		System.out.println(cepConfig.getEventTypes().toString());
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
}
