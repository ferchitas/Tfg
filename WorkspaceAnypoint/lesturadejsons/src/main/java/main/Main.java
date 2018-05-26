package main;
import java.util.logging.Level;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import esper.AccesoMotorEsper;
import esper.GeneradorDeDatosEventos;
import esquemas.patrones.EsquemaPatron;
import lector.json.Director;
import logger.MiLogger;

public class Main implements Callable{

	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
 
		try{
			
			Director director = new Director();
			director.procesar(this.obtenerRuta(eventContext));
			MiLogger.info("Fichero de configuracion leido");
			MiLogger.info("Esquema generado: " + director.devolverEsquema().toString());
			
			AccesoMotorEsper ame = AccesoMotorEsper.obtenerAccesoMotorEsper();
			ame.agregarEsquema(director.devolverEsquema());
			MiLogger.info("Esquema enviado al motor");
			if(director.devolverEsquema() instanceof EsquemaPatron){

				MiLogger.info("Datos enviados al motor");
				GeneradorDeDatosEventos.generarDatosEventoPotenciaCt(ame);
			}
		}
		catch(Exception e){
			
			MiLogger.log(Level.SEVERE, "Ha ocurrido una excepción", e);
		}
		return null;
	}
	
	private String obtenerRuta(MuleEventContext eventContext){
		
		return eventContext.getMessage().getInboundProperty("directory").toString() + "\\" +
				eventContext.getMessage().getInboundProperty("originalFilename").toString();
	}

}
