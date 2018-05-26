package esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import logger.MiLogger;

public class CEPListener implements UpdateListener {
	
	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		for(int i = 0; i < arg0.length; i++){
			
			EventBean evento = arg0[i];
			MiLogger.info("Nombre del evento recibido: " + evento.getEventType().getName() +"\n");
			MiLogger.info("Informacion: " + evento.getUnderlying() +"\n");
		}
	}
}