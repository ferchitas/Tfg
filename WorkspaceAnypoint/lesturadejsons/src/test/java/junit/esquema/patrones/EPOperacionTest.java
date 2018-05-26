package junit.esquema.patrones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemas.patrones.*;
import helpers.HelperJsons;
import lector.json.FactoriaEsquemas;

public class EPOperacionTest {
	EPOperacion op;
	String operacion;
	FactoriaEsquemas fe;
	JSONObject json;
	@Before
	public void setUp() throws Exception {
		
		String ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
		json = HelperJsons.leerFichero(ruta).getJSONObject("operacion");
		op = new EPOperacion();
		operacion = "";
		op = fe.fabricarEPOperacion(json);
		ArrayList<EPExpresion> pro = new ArrayList<>();
		pro.add(fe.fabricarEPPropiedad((JSONObject)json.getJSONArray("expresiones").get(0)));
		pro.add(fe.fabricarEPPropiedad((JSONObject)json.getJSONArray("expresiones").get(1)));
		op.setExpresiones(pro);
		operacion = "a1.p1 and a1.p1";
	}

	@Test
	public void test() {

		assertTrue(op.toString().equals(operacion));
	}

}
