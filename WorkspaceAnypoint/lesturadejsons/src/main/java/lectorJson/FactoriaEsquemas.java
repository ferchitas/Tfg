package lectorJson;

import org.json.JSONObject;

import esquemasPatrones.*;
import esquemasPatronesVentanas.*;

public class FactoriaEsquemas {

	public EPPropiedad fabricarEPPropiedad(JSONObject jExpresion){
		
		EPPropiedad propiedad = new EPPropiedad();
		propiedad.setPseudonombre(jExpresion.getString("pseudonombre"));
		propiedad.setNombre(this.setNombrePropiedad(jExpresion));
		return propiedad;
	}
	
	private String setNombrePropiedad(JSONObject jExpresion){
		
		String nombre = jExpresion.getString("nombre");
		if (!jExpresion.getString("procedencia").equals("")){
			nombre = jExpresion.getString("procedencia") + "." + nombre;
		}
		
		return nombre;
	}
	
	public EPFuncion fabricarEPFuncion (JSONObject jExpresion){
		
		EPFuncion funcion = new EPFuncion();
		funcion.setNombreFuncion(jExpresion.getString("nombre"));
		funcion.setPseudonombre(jExpresion.getString("pseudonombre"));
		return funcion;
	}
	
	public EPFuncionEvery fabricarEPFuncionEvery(JSONObject jExpresion){
		
		EPFuncionEvery funcion = new EPFuncionEvery();
		funcion.setNombreFuncion(jExpresion.getString("nombre"));
		funcion.setPseudonombre(jExpresion.getString("pseudonombre"));
		return funcion;
	}
	
	public EPOperacion fabricarEPOperacion(JSONObject jExpresion){
		
		EPOperacion operacion = new EPOperacion();
		operacion.setPseudonombre(jExpresion.getString("pseudonombre"));
		operacion.setOperador(jExpresion.getString("operador"));
		
		return operacion;
	}
	
	public EPPropiedadEvery fabricarEPPropiedadEvery(JSONObject jExpresion){
		
		EPPropiedadEvery  propiedad = new EPPropiedadEvery();
		propiedad.setPseudonombre(jExpresion.getString("pseudonombre"));
		propiedad.setNombre(this.setNombrePropiedad(jExpresion));
		propiedad.setSiguienteExpresion(jExpresion.getString("siguienteExpresion"));
		return propiedad;
	}
	
	public EPVentanaTemporal fabricarVentanaTemporal(JSONObject jExpresion){
		
		EPVentanaTemporal ventana = new EPVentanaTemporal();
		
		ventana.setNombre(jExpresion.getString("nombre"));
		ventana.setValor(jExpresion.getString("valor"));
		ventana.setUnidadTemporal(jExpresion.getString("unidad"));
		ventana.setPseudonombre(jExpresion.getString("pseudonombre"));
		return ventana;
	}
	public EPVentana fabricarVentana(JSONObject jExpresion){
		
		EPVentana ventana = new EPVentana();
		
		ventana.setNombre(jExpresion.getString("nombre"));
		ventana.setValor(jExpresion.getString("valor"));
		ventana.setPseudonombre(jExpresion.getString("pseudonombre"));
		return ventana;
	}
}
