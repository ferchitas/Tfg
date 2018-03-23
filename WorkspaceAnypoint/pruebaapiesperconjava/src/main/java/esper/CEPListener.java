package esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class CEPListener implements UpdateListener {
	
@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		System.out.println("Evento recibido: " + arg0[0].getUnderlying());
	}
}