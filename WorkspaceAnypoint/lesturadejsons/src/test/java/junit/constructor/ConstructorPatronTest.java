package junit.constructor;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import esquemas.patrones.*;
import esquemas.patrones.ventanas.EPVentanaTemporal;
import helpers.HelperJsons;
import lector.json.ConstructorPatron;

public class ConstructorPatronTest {

	private EsquemaPatron esquemaEsperado;
	private EsquemaPatron esquemaReal;
	
	private ArrayList<EPExpresion> expresionesSelect = new ArrayList<>();
	private ArrayList<EPExpresion> expresionesFrom = new ArrayList<>();
	private ArrayList<EPExpresion> expresionesGroupBy = new ArrayList<>();

	private ConstructorPatron ce = new ConstructorPatron();
	private JSONObject json;
	
	@Before
	public void setUp() throws Exception {
		
		esquemaEsperado = new EsquemaPatron();
		esquemaEsperado.setNombrePatron("nombre");
		
		setUpSelect();
		setUpFrom();
		setUpGroupBy();
		esquemaEsperado.setExpresionesSelect(expresionesSelect);
		esquemaEsperado.setExpresionesFrom(expresionesFrom);
		esquemaEsperado.setExpresionesGroupBy(expresionesGroupBy);
		
		//preparamos el json que vamos a leer
		String ruta = "src/test/resources/patronParaTest.json";
		json = HelperJsons.leerFichero(ruta);
		ce.crearEsquema(json);
		esquemaReal = (EsquemaPatron)ce.getEsquema();
	}
	
	private void setUpGroupBy(){
		
		//seteamos el resto de propiedades.
		EPPropiedad pro = new EPPropiedad();
		pro.setNombre("a1.p2");
		pro.setPseudonombre("");
		expresionesGroupBy.add(pro);
		pro = new EPPropiedad();
		pro.setNombre("a1.p3");
		pro.setPseudonombre("");
		expresionesGroupBy.add(pro);
	}
	
	private void setUpFrom(){
		
		//creamos e inicializmos las variables necesarias.
		EPVentanaTemporal ven = new EPVentanaTemporal();
		EPPropiedad pro = new EPPropiedad();
		//setemamos la ventana.
		ven.setNombre("time_batch");
		ven.setValor("10");
		ven.setUnidadTemporal("seconds");
		ven.setPseudonombre("a1");
		pro.setNombre("p4");
		pro.setPseudonombre("");
		pro.setVentana(ven);
		expresionesFrom.add(pro);
	}
	
	private void setUpSelect(){
		
		//creamos e inicializmos las variables necesarias.
		EPFuncion fun = new EPFuncion();
		EPPropiedad pro = new EPPropiedad();
		ArrayList<EPExpresion> exps = new ArrayList<>();
		//seteamos la propiedad de la funcion.
		pro.setNombre("a1.p1");
		pro.setPseudonombre("");
		//metemos la propiedad en la funcion.
		exps.add(pro);
		fun.setExpresiones(exps);
		//seteamos la funcion con el resto de valores.
		fun.setNombreFuncion("f1");
		fun.setPseudonombre("fun1");
		//metemos la funcion en la lista del select.
		expresionesSelect.add(fun);
		//seteamos el resto de propiedades.
		pro = new EPPropiedad();
		pro.setNombre("a1.p2");
		pro.setPseudonombre("pro2");
		expresionesSelect.add(pro);
		pro = new EPPropiedad();
		pro.setNombre("a1.p3");
		pro.setPseudonombre("pro3");
		expresionesSelect.add(pro);
	}
	
	@Test
	public void testTipoDeFicheroPatron(){
		
		//probar que el fichero es de tipo evento.
		assertTrue(json.get("tipo").equals("patron"));
	}

	@Test
	public void testLecturaNombre() {
	
		//probar que el nombre no esta vacio
		assertTrue(!esquemaReal.getNombrePatron().equals(""));
	}
	
	@Test
	public void testLecturaSelect(){
		
		//probar que ambos select son similares.
		assertEquals(esquemaEsperado.getExpresionesSelect().toString(), esquemaReal.getExpresionesSelect().toString());
	}
	
	@Test
	public void testLecturaFrom(){
		
		//probar que ambos from son similares.
		assertEquals(esquemaEsperado.getExpresionesFrom().toString(), esquemaReal.getExpresionesFrom().toString());
	}
	
	@Test
	public void testLecturaGroupBy(){
		
		//probar que ambos groupBy son similares.
		assertEquals(esquemaEsperado.getExpresionesGroupBy().toString(), esquemaReal.getExpresionesGroupBy().toString());
	}
	
	@Test
	public void testLeerExpresiones(){
		
		String ruta = "src/test/resources/constructorPatronCrearEsquemaTest.json";
		json = HelperJsons.leerFichero(ruta);
		ce.crearEsquema(json);
		esquemaReal = (EsquemaPatron)ce.getEsquema();
		ce.crearEsquema(json);
	}
}
