package junit.esper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.espertech.esper.client.ConfigurationOperations;

import esper.AccesoMotorEsper;
import esper.CEPListener;
import esper.GeneradorDeDatosEventos;
import lector.json.Director;

public class AccesoMotorEsperTest {
	
	AccesoMotorEsper ame;
	Director director;
	String patron = "insert into potenciaMediaDiaAnteriorCt select avg(a1.potencia) as mediaPotencia, a1.identificadorCt as identificadorCt, a1.planta as planta from potenciaCt.win:time_batch(10 seconds) a1 group by a1.identificadorCt, a1.planta";
	
	@Before
	public void setUp() throws Exception {
		
		director = new Director();
		ame = AccesoMotorEsper.obtenerAccesoMotorEsper();
	}

	@Test
	public void testSendEvento() {

		director.procesar("src/test/resources/esquemaEventoTest.json");
		ame.agregarEsquema(director.devolverEsquema());
		ConfigurationOperations cepConfig = ame.getCepConfig();
		assertTrue(cepConfig.getEventType("potenciaCt").getName().equals("potenciaCt"));
		
		
	}
	
	@Test
	public void testSendPatron() {

		director.procesar("src/test/resources/esquemaPatronTest.json");
		ame.agregarEsquema(director.devolverEsquema());
		assertTrue(ame.getEPStatement().getText().equals(patron));
	}
	
	@Test
	public void testGeneradorDeDatos() {

		director.procesar("src/test/resources/esquemaEventoTest.json");
		ame.agregarEsquema(director.devolverEsquema());
		GeneradorDeDatosEventos.generarDatosEventoPotenciaCt(ame);
		Long s = ame.getCepRT().getNumEventsEvaluated();
		assertTrue(s == 10);
	}
	
	@Test
	public void testListener() {

		director.procesar("src/test/resources/esquemaEventoTest.json");
		ame.agregarEsquema(director.devolverEsquema());
		director.procesar("src/test/resources/esquemaPatronListenerTest.json");
		ame.agregarEsquema(director.devolverEsquema());
		GeneradorDeDatosEventos.generarDatosEventoPotenciaCt(ame);
		assertTrue(ame.getEPStatement().getUpdateListeners().next() instanceof CEPListener);
	}
}
