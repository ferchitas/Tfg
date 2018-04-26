package lectorJson;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;

import esquemas.Esquema;

public class Director {

	private Constructor constructor;
	private JSONObject json;

	public Constructor getConstructor() {
		return constructor;
	}

	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}
	
	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	public void procesar(String archivo){
		
		this.leerFichero(archivo);
		this.inicializarConstructor();
		this.construirEsquema();
	}
	
	private void leerFichero(String archivo){
		
		String jsonData = this.ficheroAString(archivo);
		JSONObject jobj = new JSONObject(jsonData);
		this.setJson((JSONObject) jobj);
	}
	
	private void inicializarConstructor(){
		
		if(this.getJson().getString("tipo").equals("evento")){
			
			this.setConstructor(new ConstructorEvento());
		}
	}
	
	private void construirEsquema(){
		
		JSONObject json = this.getJson();
		this.getConstructor().crearEsquema(json);
	}
	
	public Esquema devolverEsquema(){
		
		return this.getConstructor().getEsquema();
	}
	
	public String ficheroAString(String filename) {
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
}
