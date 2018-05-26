package junit.esquema.patrones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemas.patrones.*;
import helpers.HelperJsons;
import lector.json.FactoriaEsquemas;

public class EPCaseWhenTest {

	EPCase cas;
	EPWhen when1;
	EPWhen when2;
	FactoriaEsquemas fe;
	JSONObject json;
	String sCase;
	String sWhen;
	ArrayList<EPExpresion> whens;
	
	@Before
	public void setUp() throws Exception {
		
		String ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
		json = HelperJsons.leerFichero(ruta).getJSONObject("case");
		cas = fe.fabricarCase(json);
		when1 = fe.fabricarWhen(json.getJSONArray("expresiones").getJSONObject(0));
		when2 = fe.fabricarWhen(json.getJSONArray("expresiones").getJSONObject(1));
		whens = new ArrayList<>();
		whens.add(when1);
		whens.add(when2);
		cas.setCondiciones(whens);
		sCase = "case r\nwhen a > b then 1\nwhen a < b then 2\nelse 0\nend";
		sWhen = "when a > b then 1";
	}

	@Test
	public void testToStringCase() {
		
		assertTrue(cas.toString().equals(sCase));
	}

	@Test
	public void testToStringWhen() {
		
		assertTrue(when1.toString().equals(sWhen));
	}
}
