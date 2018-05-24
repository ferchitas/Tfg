package junit.esquema.evento;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemasEventos.EEPropiedad;
import helpers.HelperJsons;

public class EEPropiedadTest {

	EEPropiedad pro;
	String ruta, propiedad;
	JSONObject json;
	
	@Before
	public void setUp() throws Exception {
		
		pro = new EEPropiedad();
		ruta = "src/test/resources/esquemasEventos.json";
		json = HelperJsons.leerFichero(ruta).getJSONObject("propiedad");
		pro.setNombre(json.getString("nombre"));
		pro.setValor(json.getString("valor"));
		propiedad = "Propiedad [nombre = n, valor = int]";
		
	}

	@Test
	public void test() {

		assertTrue(pro.toString().equals(propiedad));
	}

}
