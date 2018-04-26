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


public class AccesoMotorEsper {

	private Configuration cepConfig;
	private EPServiceProvider epService;
	private EPRuntime cepRT;
	private EPAdministrator cepAdm;
	private EPStatement patronEpl;
	
	public AccesoMotorEsper(){
		
		this.cepConfig = new Configuration();
	}
	
	public void SetUpAcceso(){
		
		this.epService = EPServiceProviderManager.getDefaultProvider(this.cepConfig);
		setCepRT(this.epService.getEPRuntime());
		this.cepAdm = this.epService.getEPAdministrator();
	}
	
	public void mostrarEventosAgregados(){
		
		System.out.println(this.cepConfig.getEventTypes().toString());
	}
	
	public void agregarEsquema(EsquemaEvento ev){
		
		cepConfig.addEventType(ev.getNombreEvento(), ev.toMap(), ev.eventoConfiguracion());
		
	}
	
	public void agregarEvento(Map <String, Object> ev, String nombreEv){
		
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
