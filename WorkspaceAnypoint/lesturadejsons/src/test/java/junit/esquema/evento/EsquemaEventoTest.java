package junit.esquema.evento;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import esquemas.eventos.EsquemaEvento;
import lector.json.Director;

public class EsquemaEventoTest {

	String ruta;
	String evento;
	EsquemaEvento ee;
	
	@Before
	public void setUp() throws Exception {
		
		ruta = "src/test/resources/esquemaEventoTest.json";
		Director director = new Director();
		director.procesar(ruta);
		ee = (EsquemaEvento)director.devolverEsquema();
		evento = "create schema potenciaCt timestamp class java.sql.Date, identificadorCt int, potencia double, planta int inherits  starttimestamp timestamp endtimestamp timestamp copyfrom  ";
	}

	@Test
	public void test() {

		assertTrue(ee.toString().equals(evento));
	}

}
