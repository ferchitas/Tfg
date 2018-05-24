package junit.esquema.patrones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemasPatrones.*;
import helpers.HelperJsons;
import lectorJson.FactoriaEsquemas;

public class EPFuncionTest {

	EPFuncion fun;
	String funcion;
	FactoriaEsquemas fe;
	JSONObject json;
	@Before
	public void setUp() throws Exception {
		
		String ruta = "src/test/resources/esquemasPatronTest.json";
		fe = new FactoriaEsquemas();
		json = HelperJsons.leerFichero(ruta).getJSONObject("funcion");
		fun = new EPFuncion();
		fun = fe.fabricarEPFuncion(json);
		ArrayList<EPExpresion> pro = new ArrayList<>();
		pro.add(fe.fabricarEPPropiedad((JSONObject)json.getJSONArray("expresiones").get(0)));
		fun.setExpresiones(pro);
		funcion = "f1(a1.p1 as ps1) as fun1";
	}

	@Test
	public void test() {
		
		assertTrue(fun.toString().equals(funcion));
	}

}
