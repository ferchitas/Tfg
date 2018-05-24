package junit.esquema.patrones;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemasPatrones.*;
import helpers.HelperJsons;
import lectorJson.FactoriaEsquemas;

public class EPPropiedadEveryTest {

	EPPropiedadEvery pro;
	FactoriaEsquemas fe;
	JSONObject json;
	String propiedad, ruta;
	
	@Before
	public void setUp() throws Exception {
		
		ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
	}
	
	
	@Test
	public void testToString1() {

		propiedad = "(b";
		json = HelperJsons.leerFichero(ruta).getJSONObject("everyPropiedadT1");
		pro = fe.fabricarEPPropiedadEvery(json);
		assertTrue(pro.toString().equals(propiedad));
	}
	
	@Test
	public void testToString2() {

		propiedad = "c)";
		json = HelperJsons.leerFichero(ruta).getJSONObject("everyPropiedadT2");
		pro = fe.fabricarEPPropiedadEvery(json);
		assertTrue(pro.toString().equals(propiedad));
	}

}
