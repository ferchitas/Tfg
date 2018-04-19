import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import lectorJson.Director;

public class Main implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		
		String ruta = eventContext.getMessage().getInboundProperty("directory").toString() + "\\" +
				eventContext.getMessage().getInboundProperty("originalFilename").toString();
		Director director = new Director();
		director.procesar(ruta);
		
		return null;
	}

}
