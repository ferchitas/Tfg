package lectorJson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import esquemasPatrones.EPExpresion;
import esquemasPatrones.EPFuncion;
import esquemasPatrones.EPFuncionEvery;
import esquemasPatrones.EPOperacion;
import esquemasPatrones.EPPropiedad;
import esquemasPatrones.EsquemaPatron;
import esquemasPatronesVentanas.EPVentana;

public class ConstructorPatron extends Constructor {

	@Override
	public void crearEsquema(JSONObject json) {
		
		EsquemaPatron patron = new EsquemaPatron();
		
		patron.setNombrePatron(json.getString("nombrePatron"));
		patron.setExpresionesSelect(this.leerExpresiones(json.getJSONArray("select")));
		patron.setExpresionesFrom(this.leerExpresiones(json.getJSONArray("from")));
		patron.setExpresionesGroupBy(this.leerExpresiones(json.getJSONArray("groupBy")));
		
		this.setEsquema(patron);
	}
	
	private ArrayList<EPExpresion> leerExpresiones(JSONArray jExpresiones){
		
		ArrayList<EPExpresion> expresiones = new ArrayList<EPExpresion>();
		for (int i = 0; i < jExpresiones.length(); i++) {
			expresiones.add(this.leerExpresion(jExpresiones.getJSONObject(i)));
		}
		return expresiones;
	}
	
	private EPExpresion leerExpresion(JSONObject jExpresion){
		
		EPExpresion expresionResultante;
		FactoriaEsquemas factoria = new FactoriaEsquemas();
		if(jExpresion.getString("tipo").equals("propiedad")){
			
			EPPropiedad propiedad = factoria.fabricarEPPropiedad(jExpresion);
			propiedad.setVentana((EPVentana)this.leerExpresion(jExpresion.getJSONObject("ventana")));
			expresionResultante = propiedad;
		}
		else if(jExpresion.getString("tipo").equals("funcion")){
			
			EPFuncion funcion = factoria.fabricarEPFuncion(jExpresion);
			funcion.setExpresiones(this.leerExpresiones(jExpresion.getJSONArray("expresiones")));
			expresionResultante = funcion;
		}
		else if(jExpresion.getString("tipo").equals("everyFuncion")){
			
			EPFuncionEvery funcion = factoria.fabricarEPFuncionEvery(jExpresion);
			funcion.setExpresiones(this.leerExpresiones(jExpresion.getJSONArray("expresiones")));
			expresionResultante = funcion;
		}
		else if(jExpresion.getString("tipo").equals("operacion")){
			
			EPOperacion operacion = factoria.fabricarEPOperacion(jExpresion);
			operacion.setExpresiones(this.leerExpresiones(jExpresion.getJSONArray("expresiones")));
			expresionResultante = operacion;
		}
		else if(jExpresion.getString("tipo").equals("everyPropiedad")){
			
			
			expresionResultante = factoria.fabricarEPPropiedadEvery(jExpresion);
		}
		else if(jExpresion.getString("tipo").equals("ventanaTemporal")){
			
			expresionResultante = factoria.fabricarVentanaTemporal(jExpresion);
		}
		else if(jExpresion.getString("tipo").equals("ventana")){
			
			expresionResultante = factoria.fabricarVentana(jExpresion);
		}
		else {
			
			expresionResultante = null;
		}
		return expresionResultante;
	}
}
