package junit.constructor;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemasPatrones.*;
import esquemasPatronesVentanas.*;
import helpers.HelperJsons;
import lectorJson.FactoriaEsquemas;

public class FactoriaEsquemasTest {

	FactoriaEsquemas fe;
	JSONObject json;
	
	@Before
	public void setUp() throws Exception {
		String ruta = "src/test/resources/ficheroFactoriaTest.json";
		json = HelperJsons.leerFichero(ruta);
		fe = new FactoriaEsquemas();
	}

	@Test
	public void testFabricarEPPropiedad() {
		
		EPPropiedad exp = fe.fabricarEPPropiedad(json.getJSONObject("propiedad"));
		assertTrue(!json.getJSONObject("propiedad").getString("procedencia").equals(""));
		assertTrue(exp != null);
		assertTrue(exp.getNombre() != null);
		assertTrue(!exp.getNombre().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(!exp.getPseudonombre().equals(""));
	}
	
	@Test
	public void testFabricarEPFuncion() {

		EPFuncion exp = fe.fabricarEPFuncion(json.getJSONObject("funcion"));
		assertTrue(exp != null);
		assertTrue(exp.getNombreFuncion() != null);
		assertTrue(!exp.getNombreFuncion().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(!exp.getPseudonombre().equals(""));
	}
	
	@Test
	public void testFabricarEPFuncionEvery() {

		EPFuncionEvery exp = fe.fabricarEPFuncionEvery(json.getJSONObject("everyFuncion"));
		assertTrue(exp != null);
		assertTrue(exp.getNombreFuncion() != null);
		assertTrue(!exp.getNombreFuncion().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(!exp.getPseudonombre().equals(""));
	}
	
	@Test
	public void testFabricarEPOperacion() {
		
		EPOperacion exp = fe.fabricarEPOperacion(json.getJSONObject("operacion"));
		assertTrue(exp != null);
		assertTrue(exp.getOperador() != null);
		assertTrue(!exp.getOperador().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(!exp.getPseudonombre().equals(""));
	}
	
	@Test
	public void testFabricarEPPropiedadEvery() {

		EPPropiedadEvery exp = fe.fabricarEPPropiedadEvery(json.getJSONObject("everyPropiedad"));
		assertTrue(json.getJSONObject("everyPropiedad").getString("procedencia").equals(""));
		assertTrue(exp != null);
		assertTrue(exp.getNombre() != null);
		assertTrue(!exp.getNombre().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(exp.getPseudonombre().equals(""));
		assertTrue(exp.getSiguienteExpresion() != null);
		assertTrue(!exp.getSiguienteExpresion().equals(""));
	}
	
	@Test
	public void testFabricarVentanaTemporal() {
		
		EPVentanaTemporal exp = fe.fabricarVentanaTemporal(json.getJSONObject("ventanaTemporal"));
		assertTrue(exp != null);
		assertTrue(exp.getNombre() != null);
		assertTrue(!exp.getNombre().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(exp.getPseudonombre().equals(""));
		assertTrue(exp.getValor() != null);
		assertTrue(!exp.getValor().equals(""));
		assertTrue(exp.getUnidadTemporal() != null);
		assertTrue(!exp.getUnidadTemporal().equals(""));
	}
	
	@Test
	public void testFabricarVentana() {

		EPVentana exp = fe.fabricarVentana(json.getJSONObject("ventana"));
		assertTrue(exp != null);
		assertTrue(exp.getNombre() != null);
		assertTrue(!exp.getNombre().equals(""));
		assertTrue(exp.getPseudonombre() != null);
		assertTrue(exp.getPseudonombre().equals(""));
		assertTrue(exp.getValor() != null);
		assertTrue(!exp.getValor().equals(""));
	}
}
