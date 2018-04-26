import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import esper.AccesoMotorEsper;
import esper.GeneradorDeDatosEventos;
import esquemasEventos.EsquemaEvento;
import lectorJson.Director;

public class Main implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
 
		Director director = new Director();
		director.procesar(this.obtenerRuta(eventContext));
		
		System.out.println("Json leido\n");
		AccesoMotorEsper ame = new AccesoMotorEsper();
		System.out.println("acceso al motor creado\n");
		ame.agregarEsquema((EsquemaEvento)director.devolverEsquema());
		ame.SetUpAcceso();
		
		System.out.println("evento potenciaCt enviado\n");
		ame.agregarPatronEPL("insert into potenciaMediaDiaAnteriorCt "
				+ "select avg(a1.potencia) as medaPotencia, a1.identificadorCt as identificadorCt, a1.planta as planta from " +
		                                "potenciaCt.win:time_batch(10 seconds) a1 " +
		                                "group by a1.identificadorCt, a1.planta");
		ame.SetUpAcceso();
		//ame.mostrarEventosAgregados();
		GeneradorDeDatosEventos.generarDatosEventoPotenciaCt(ame);
		System.out.println("datos enviados al motor\n");
		return null;
	}
	
	private String obtenerRuta(MuleEventContext eventContext){
		
		return eventContext.getMessage().getInboundProperty("directory").toString() + "\\" +
				eventContext.getMessage().getInboundProperty("originalFilename").toString();
	}

}
