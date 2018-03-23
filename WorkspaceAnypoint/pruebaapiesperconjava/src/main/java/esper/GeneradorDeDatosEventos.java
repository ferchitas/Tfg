package esper;

import java.util.Random;

import com.espertech.esper.client.EPRuntime;

import eventos.EventoPotenciaCt;

public class GeneradorDeDatosEventos {
	
	private static Random aleatorio = new Random();

	public static void generarDatosEventoPotenciaCt(EPRuntime cepRT){
		
	   Long timestamp = System.currentTimeMillis();
	   for(int i=1; i<11; i++){
		   
		   EventoPotenciaCt evento = new EventoPotenciaCt(
				   timestamp.toString(),
				   i, 
				   i*aleatorio.nextDouble(),
				   1);
		   cepRT.sendEvent(evento);
	   }	   
   }
}
