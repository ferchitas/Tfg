package logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiLogger {
	
	private static Logger logger;
    private Handler fileHandler;
    private Handler consolaHandler;

    private MiLogger(){

        consolaHandler = new ConsoleHandler();
    	logger.addHandler(consolaHandler);
        try {
			fileHandler = new FileHandler("./logs/excepciones.log");
			logger.addHandler(fileHandler);
		} catch (SecurityException | IOException e) {
			
			MiLogger.log(Level.SEVERE, "El logger no puede crear el fichero de log", e);
		}
    }
    
    private static Logger getLogger(){
        if(logger == null){
        	logger = Logger.getLogger(MiLogger.class.getName());
        	new MiLogger();
        }
        return logger;
    }
    
    public static void log(Level level, String msg, Object o){
        getLogger().log(level, msg, o);
    }
    
    public static void info(String msg){
    	
    	getLogger().info(msg);
    }
}
