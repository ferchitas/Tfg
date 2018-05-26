package esper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GeneradorDeDatosEventos {

	private GeneradorDeDatosEventos(){
		 throw new IllegalStateException("Utility class");
	}
	
	public static void generarDatosEventoPotenciaCt(AccesoMotorEsper am){
	
		for(int i=1; i<11; i++){
		   
		   Map <String, Object> ev = new HashMap <>();
		   ev.put("timestamp", new Date());
		   ev.put("identificadorCt", i);
		   ev.put("potencia", i + 0.1);
		   ev.put("planta", i);
		   
		   am.enviarEvento(ev, "potenciaCt");
	   }	   
   }
}
