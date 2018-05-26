package lector.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import esquemas.patrones.EPCase;
import esquemas.patrones.EPExpresion;
import esquemas.patrones.EPFuncion;
import esquemas.patrones.EPFuncionEvery;
import esquemas.patrones.EPOperacion;
import esquemas.patrones.EPPropiedad;
import esquemas.patrones.EsquemaPatron;
import esquemas.patrones.ventanas.EPVentana;

public class ConstructorPatron extends Constructor {

	private static final String EXPRESONES = "expresiones";
	private static final String TIPO = "tipo";
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
		
		ArrayList<EPExpresion> expresiones = new ArrayList<>();
		for (int i = 0; i < jExpresiones.length(); i++) {
			expresiones.add(this.leerExpresion(jExpresiones.getJSONObject(i)));
		}
		return expresiones;
	}
	
	private EPExpresion leerExpresion(JSONObject jExpresion){
		
		EPExpresion expresionResultante;
		FactoriaEsquemas factoria = new FactoriaEsquemas();
		if(jExpresion.getString(TIPO).equals("propiedad")){
			
			EPPropiedad propiedad = factoria.fabricarEPPropiedad(jExpresion);
			propiedad.setVentana((EPVentana)this.leerExpresion(jExpresion.getJSONObject("ventana")));
			expresionResultante = propiedad;
		}
		else if(jExpresion.getString(TIPO).equals("funcion")){
			
			EPFuncion funcion = factoria.fabricarEPFuncion(jExpresion);
			funcion.setExpresiones(this.leerExpresiones(jExpresion.getJSONArray(EXPRESONES)));
			expresionResultante = funcion;
		}
		else if(jExpresion.getString(TIPO).equals("everyFuncion")){
			
			EPFuncionEvery funcion = factoria.fabricarEPFuncionEvery(jExpresion);
			funcion.setExpresiones(this.leerExpresiones(jExpresion.getJSONArray(EXPRESONES)));
			expresionResultante = funcion;
		}
		else if(jExpresion.getString(TIPO).equals("operacion")){
			
			EPOperacion operacion = factoria.fabricarEPOperacion(jExpresion);
			operacion.setExpresiones(this.leerExpresiones(jExpresion.getJSONArray(EXPRESONES)));
			expresionResultante = operacion;
		}
		else if(jExpresion.getString(TIPO).equals("everyPropiedad")){
			
			expresionResultante = factoria.fabricarEPPropiedadEvery(jExpresion);
		}
		else if(jExpresion.getString(TIPO).equals("ventanaTemporal")){
			
			expresionResultante = factoria.fabricarVentanaTemporal(jExpresion);
		}
		else if(jExpresion.getString(TIPO).equals("ventana")){
			
			expresionResultante = factoria.fabricarVentana(jExpresion);
		}
		else if(jExpresion.getString(TIPO).equals("case")){
			
			EPCase expresion = factoria.fabricarCase(jExpresion);
			expresion.setCondiciones(this.leerExpresiones(jExpresion.getJSONArray(EXPRESONES)));
			expresionResultante = expresion;
		}
		else if(jExpresion.getString(TIPO).equals("when")){
			expresionResultante = factoria.fabricarWhen(jExpresion);
		}
		else {
			
			expresionResultante = null;
		}
		return expresionResultante;
	}
}
