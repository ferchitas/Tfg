package junit.constructor;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import lectorJson.ConstructorEvento;
import lectorJson.Director;

public class DirectorTest {

	private Director director = new Director();
	
	@Before
	public void setUp() throws Exception {
		
		director.leerFichero("src/test/resources/eventoParaTest.json");
	}

	//el resultado esperado debe de ser un objeto tipo json dentro del objeto director
	@Test
	public void testLeerFichero() {
		
		assertTrue(director.getJson() instanceof JSONObject);
	}
	@Test
	public void testInicializarConstructor() {
		director.inicializarConstructor();
		assertTrue(director.getConstructor() instanceof ConstructorEvento);
	}
	
	@Test
	public void testFicheroAString() {
		
		String fichero = director.ficheroAString("src/test/resources/eventoParaTest.json");
		assertTrue(fichero != null);
		assertTrue(!fichero.equals(""));
	}
}
