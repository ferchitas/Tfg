package junit.esquema.patrones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemasPatrones.*;
import helpers.HelperJsons;
import lectorJson.FactoriaEsquemas;

public class EPFuncionEveryTest {

	EPFuncionEvery fun;
	EPOperacion op;
	EPPropiedadEvery pro1, pro2;
	String funcion;
	FactoriaEsquemas fe;
	JSONObject json;
	@Before
	public void setUp() throws Exception {
		
		String ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
		json = HelperJsons.leerFichero(ruta).getJSONObject("everyFuncion");
		fun = new EPFuncionEvery();
		fun = fe.fabricarEPFuncionEvery(json);
		ArrayList<EPExpresion> pro = new ArrayList<>();
		op = fe.fabricarEPOperacion((JSONObject)json.getJSONArray("expresiones").get(0));
		pro1 = fe.fabricarEPPropiedadEvery((JSONObject)((JSONObject)json.getJSONArray("expresiones").get(0)).getJSONArray("expresiones").get(0));
		pro2 = fe.fabricarEPPropiedadEvery((JSONObject)((JSONObject)json.getJSONArray("expresiones").get(0)).getJSONArray("expresiones").get(1));
		pro.add(pro1);
		pro.add(pro2);
		op.setExpresiones(pro);
		pro = new ArrayList<EPExpresion>();
		pro.add(op);
		fun.setExpresiones(pro);
		funcion = "every (b -> c)";
	}

	@Test
	public void test() {

		assertTrue(fun.toString().equals(funcion));
	}

}
