package esper;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import eventos.EventoPotenciaCt;

public class AccesoMotorEsper implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		Configuration cepConfig = new Configuration();
		cepConfig.addEventType("potenciaCt", EventoPotenciaCt.class.getName());
		
		EPServiceProvider epService = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
		
		EPRuntime cepRT = epService.getEPRuntime();
		
		EPAdministrator cepAdm = epService.getEPAdministrator();
		EPStatement patronEpl = cepAdm.createEPL("insert into potenciaMediaDiaAnteriorCt "
				+ "select avg(a1.potencia) as medaPotencia, a1.identificadorCt as identificadorCt, a1.planta as planta from " +
		                                "potenciaCt.win:time_batch(10 seconds) a1 " +
		                                "group by a1.identificadorCt, a1.planta");
		patronEpl.addListener(new CEPListener());
		GeneradorDeDatosEventos.generarDatosEventoPotenciaCt(cepRT);
		return null;
	}
}
