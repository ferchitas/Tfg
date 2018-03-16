package esper;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class Logger implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		System.out.println("holaa");
		return eventContext.getMessage();
	}
}
