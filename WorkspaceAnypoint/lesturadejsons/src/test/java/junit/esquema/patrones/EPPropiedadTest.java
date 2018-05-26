package junit.esquema.patrones;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemas.patrones.*;
import helpers.HelperJsons;
import lector.json.FactoriaEsquemas;

public class EPPropiedadTest {

	EPPropiedad pro;
	FactoriaEsquemas fe;
	JSONObject json;
	String propiedad;
	
	@Before
	public void setUp() throws Exception {
		
		String ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
		json = HelperJsons.leerFichero(ruta).getJSONObject("propiedad");
		pro = fe.fabricarEPPropiedad(json);
		propiedad = "a1.p1 as ps1";
	}

	@Test
	public void test() {
		
		assertTrue(pro.toString().equals(propiedad));
	}

}
