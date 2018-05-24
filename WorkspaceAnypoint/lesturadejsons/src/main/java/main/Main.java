package main;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import esper.AccesoMotorEsper;
import esper.GeneradorDeDatosEventos;
import esquemasPatrones.EsquemaPatron;
import lectorJson.Director;

public class Main implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
 
		Director director = new Director();
		director.procesar(this.obtenerRuta(eventContext));
		AccesoMotorEsper ame = AccesoMotorEsper.obtenerAccesoMotorEsper();
		System.out.println("Fichero de configuracion leido\n");
		System.out.println(director.devolverEsquema().toString());
		System.out.println("Esquema enviado al motor\n");
		ame.agregarEsquema(director.devolverEsquema());
		if(director.devolverEsquema() instanceof EsquemaPatron){

			System.out.println("Datos enviados al motor\n");
			GeneradorDeDatosEventos.generarDatosEventoPotenciaCt(ame);
		}
		return null;
	}
	
	private String obtenerRuta(MuleEventContext eventContext){
		
		return eventContext.getMessage().getInboundProperty("directory").toString() + "\\" +
				eventContext.getMessage().getInboundProperty("originalFilename").toString();
	}

}
