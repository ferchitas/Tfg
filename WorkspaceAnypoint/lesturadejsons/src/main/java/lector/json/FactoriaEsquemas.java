package lector.json;

import org.json.JSONObject;

import esquemas.patrones.*;
import esquemas.patrones.ventanas.*;

public class FactoriaEsquemas {
	
	private static final String PSEUDONOMBRE = "pseudonombre";
	private static final String NOMBRE = "nombre";
	private static final String VALOR = "valor";

	public EPPropiedad fabricarEPPropiedad(JSONObject jExpresion){
		
		EPPropiedad propiedad = new EPPropiedad();
		propiedad.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		propiedad.setNombre(this.setNombrePropiedad(jExpresion));
		return propiedad;
	}
	
	private String setNombrePropiedad(JSONObject jExpresion){
		
		String nombre = jExpresion.getString(NOMBRE);
		if (!jExpresion.getString("procedencia").equals("")){
			nombre = jExpresion.getString("procedencia") + "." + nombre;
		}
		
		return nombre;
	}
	
	public EPFuncion fabricarEPFuncion (JSONObject jExpresion){
		
		EPFuncion funcion = new EPFuncion();
		funcion.setNombreFuncion(jExpresion.getString(NOMBRE));
		funcion.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		return funcion;
	}
	
	public EPFuncionEvery fabricarEPFuncionEvery(JSONObject jExpresion){
		
		EPFuncionEvery funcion = new EPFuncionEvery();
		funcion.setNombreFuncion(jExpresion.getString(NOMBRE));
		funcion.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		return funcion;
	}
	
	public EPOperacion fabricarEPOperacion(JSONObject jExpresion){
		
		EPOperacion operacion = new EPOperacion();
		operacion.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		operacion.setOperador(jExpresion.getString("operador"));
		
		return operacion;
	}
	
	public EPPropiedadEvery fabricarEPPropiedadEvery(JSONObject jExpresion){
		
		EPPropiedadEvery  propiedad = new EPPropiedadEvery();
		propiedad.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		propiedad.setNombre(this.setNombrePropiedad(jExpresion));
		propiedad.setSiguienteExpresion(jExpresion.getString("siguienteExpresion"));
		return propiedad;
	}
	
	public EPVentanaTemporal fabricarVentanaTemporal(JSONObject jExpresion){
		
		EPVentanaTemporal ventana = new EPVentanaTemporal();
		
		ventana.setNombre(jExpresion.getString(NOMBRE));
		ventana.setValor(jExpresion.getString(VALOR));
		ventana.setUnidadTemporal(jExpresion.getString("unidad"));
		ventana.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		return ventana;
	}
	public EPVentana fabricarVentana(JSONObject jExpresion){
		
		EPVentana ventana = new EPVentana();
		
		ventana.setNombre(jExpresion.getString(NOMBRE));
		ventana.setValor(jExpresion.getString(VALOR));
		ventana.setPseudonombre(jExpresion.getString(PSEUDONOMBRE));
		return ventana;
	}
	
	public EPCase fabricarCase(JSONObject jExpresion){
		
		EPCase expresion = new EPCase();
		
		expresion.setValor(jExpresion.getString(VALOR));
		expresion.setResultadoPorDefecto(jExpresion.getString("else"));
		return expresion;
	}
	
	public EPWhen fabricarWhen(JSONObject jExpresion){
		
		EPWhen when = new EPWhen();
		
		when.setCondicion(jExpresion.getString("condicion"));
		when.setResultado(jExpresion.getString("resultado"));
		return when;
	}
}
