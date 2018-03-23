package tiposDeExcels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class Excel {
	
	protected static final String ENERGIA = "Energia";
	protected static final String TIEMPO = "weather";
	protected static final String POTENCIA = "Potencia";
	
	private String nombre, ruta;
	private Workbook workbook;

	public Excel(){}
	
	public Excel(String ruta){
		
		this.nombre = this.obtenerNombreDeRuta(ruta);
		this.ruta = ruta;
	}
	
	public void ponerNombreYruta(String ruta){
		
		this.nombre = this.obtenerNombreDeRuta(ruta);
		this.ruta = ruta;
	}
	
	private String obtenerNombreDeRuta(String ruta) {
		
		Path p = Paths.get(ruta);
		return p.getFileName().toString();
	}
	
	public abstract void getTipo(String ruta);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected Workbook crearExcel(String ruta){
		
		File file = new File(ruta);
		FileInputStream POIF = null;
		Workbook workbook = null;
		try {
			POIF = new FileInputStream(file);
			workbook = new XSSFWorkbook(POIF);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
}
