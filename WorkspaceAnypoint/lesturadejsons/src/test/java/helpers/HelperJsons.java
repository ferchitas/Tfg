package helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;

import org.json.JSONObject;

import logger.MiLogger;

public class HelperJsons {

	private HelperJsons(){}
	
	public static String ficheroAString(String filename) {
		String result = "";
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	    	MiLogger.log(Level.SEVERE, "Ha ocurrido una excepción", e);
	    }
	    return result;
	}
	
	public static JSONObject leerFichero(String ruta) {
		
		String jsonData = HelperJsons.ficheroAString(ruta);
		return new JSONObject(jsonData);
	}
}
