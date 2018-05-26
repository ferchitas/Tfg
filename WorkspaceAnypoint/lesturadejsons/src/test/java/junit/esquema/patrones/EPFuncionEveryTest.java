package junit.esquema.patrones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemas.patrones.*;
import helpers.HelperJsons;
import lector.json.FactoriaEsquemas;

public class EPFuncionEveryTest {

	EPFuncionEvery fun;
	EPOperacion op;
	EPPropiedadEvery pro1, pro2;
	String funcion;
	FactoriaEsquemas fe;
	JSONObject json;
	private static final String EXPRESONES = "expresiones";
	
	@Before
	public void setUp() throws Exception {
		
		String ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
		json = HelperJsons.leerFichero(ruta).getJSONObject("everyFuncion");
		fun = new EPFuncionEvery();
		fun = fe.fabricarEPFuncionEvery(json);
		ArrayList<EPExpresion> pro = new ArrayList<>();
		op = fe.fabricarEPOperacion((JSONObject)json.getJSONArray(EXPRESONES).get(0));
		pro1 = fe.fabricarEPPropiedadEvery((JSONObject)((JSONObject)json.getJSONArray(EXPRESONES).get(0)).getJSONArray(EXPRESONES).get(0));
		pro2 = fe.fabricarEPPropiedadEvery((JSONObject)((JSONObject)json.getJSONArray(EXPRESONES).get(0)).getJSONArray(EXPRESONES).get(1));
		pro.add(pro1);
		pro.add(pro2);
		op.setExpresiones(pro);
		pro = new ArrayList<>();
		pro.add(op);
		fun.setExpresiones(pro);
		funcion = "every (b -> c)";
	}

	@Test
	public void test() {

		assertTrue(fun.toString().equals(funcion));
	}

}
