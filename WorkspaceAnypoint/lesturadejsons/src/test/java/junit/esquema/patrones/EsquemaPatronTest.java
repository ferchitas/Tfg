package junit.esquema.patrones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import esquemasPatrones.EsquemaPatron;
import lectorJson.Director;

public class EsquemaPatronTest {

	String ruta, patron;
	EsquemaPatron ep;
	
	@Before
	public void setUp() throws Exception {
		
		ruta = "src/test/resources/esquemaPatronTest.json";
		Director director = new Director();
		director.procesar(ruta);
		ep = (EsquemaPatron)director.devolverEsquema();
		patron = "insert into potenciaMediaDiaAnteriorCt select avg(a1.potencia) as mediaPotencia, a1.identificadorCt as identificadorCt, a1.planta as planta from potenciaCt.win:time_batch(10 seconds) a1 group by a1.identificadorCt, a1.planta";
	}

	@Test
	public void test() {
		
		assertTrue(ep.toString().equals(patron));
	}

}
