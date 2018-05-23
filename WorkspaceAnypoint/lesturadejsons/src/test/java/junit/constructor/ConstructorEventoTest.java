package junit.constructor;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemasEventos.EEPropiedad;
import esquemasEventos.EsquemaEvento;
import lectorJson.ConstructorEvento;

public class ConstructorEventoTest {

	private EsquemaEvento esquemaEsperado;
	private EsquemaEvento esquemaReal;
	
	private ArrayList<EEPropiedad> propiedadesEventos;
	private ConstructorEvento ce;
	private JSONObject json;
	
	@Before
	public void setUp() throws Exception {
		
		//creamos el esquema esperado
		esquemaEsperado = new EsquemaEvento();
		esquemaEsperado.setNombreEvento("evento");
		esquemaEsperado.setFinalTimeStamp("");
		esquemaEsperado.setInicioTimeStamp("");
		
		propiedadesEventos = new ArrayList<EEPropiedad>();
		for(int i = 0; i < 4; i++){
			EEPropiedad pro = new EEPropiedad();
			pro.setNombre("n" + i);
			propiedadesEventos.add(pro);
		}
		propiedadesEventos.get(0).setValor(double.class);
		propiedadesEventos.get(1).setValor(int.class);
		propiedadesEventos.get(2).setValor(Date.class);
		propiedadesEventos.get(3).setValor(String.class);
		
		esquemaEsperado.setPropiedades(propiedadesEventos);
		esquemaEsperado.setEventosCopiados(new ArrayList<String>());
		esquemaEsperado.setEventosHeredados(new ArrayList<String>());
		
		//inicializamos el constructor que vamos a probar
		ce = new ConstructorEvento();
		
		//preparamos el json que vamos a leer
		json = new JSONObject();
		String jsonData = HelperTestConstructores.ficheroAString("src/test/resources/eventoParaTest.json");
		json = new JSONObject(jsonData);
	}

	@Test
	public void testCrearEsquema() {
		
		String m3 = "En definitiva ambos son iguales.";
		String m4 = "El campo tipo no es vacio";
		String m5 = "El campo nombre no es vacio.";
		ce.crearEsquema(json);
		esquemaReal = (EsquemaEvento)ce.getEsquema();
		
		//probar que el fichero es de tipo evento.
		assertTrue(m4 , json.get("tipo").equals("evento"));
		//probar que el nombre no esta vacio
		assertTrue(m5, !esquemaReal.getNombreEvento().equals(""));
		//probar que en general son iguales los toString.
		assertEquals(m3, esquemaReal.toString(), esquemaEsperado.toString());
	}
	
	@Test
	public void testPropiedadesEvento(){
		
		String m1 = "Todas las propiedades tienen tipo de dato.";
		String m2 = "Todas las propiedades tienen nombre.";
		ce.crearEsquema(json);
		esquemaReal = (EsquemaEvento)ce.getEsquema();
		
		for(int i = 0; i < propiedadesEventos.size(); i++){
			
			String nombreEsperado = propiedadesEventos.get(i).getNombre();
			String nombreReal = esquemaReal.getPropiedades().get(i).getNombre();
			Object valorEsperado = propiedadesEventos.get(i).getValor();
			Object valorReal = esquemaReal.getPropiedades().get(i).getValor();
			
			//probar que las propiedades (nombre y valor) se han leido y son con la informacion que se esperaba.
			assertEquals(m1,nombreReal, nombreEsperado);
			assertEquals(m2, valorReal, valorEsperado);
		}
	}
	
	
}
