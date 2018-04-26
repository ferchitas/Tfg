package esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class CEPListener implements UpdateListener {
	
	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		for(int i = 0; i < arg0.length; i++){
			
			EventBean evento = arg0[i];
			System.out.println("Nombre del evento recibido: " + evento.getEventType().getName() +"\n");
			System.out.println("Informacion: " + evento.getUnderlying() +"\n");
		}
		System.out.println("\n");
	}
}