package helpers;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;

public class HelperJsons {

	public static String ficheroAString(String filename) {
	    String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	        br.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public static JSONObject leerFichero(String ruta) {
		
		String jsonData = HelperJsons.ficheroAString(ruta);
		return new JSONObject(jsonData);
	}
}
