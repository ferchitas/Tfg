package usoExcels;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tiposDeExcels.Energia;
import tiposDeExcels.Excel;
import tiposDeExcels.Potencia;
import tiposDeExcels.Tiempo;

public class ExtractorExcel implements Callable{

	protected static final String ENERGIA = "Energia";
	protected static final String TIEMPO = "weather";
	protected static final String POTENCIA = "Potencia";
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
	
		String json = this.pintarDatoPantalla(eventContext);
		final Object payload = eventContext.getMessage().getPayload();
		System.out.println(json);
		eventContext.getMessage().setInvocationProperty("datos", json);
		return payload.toString();
	}


	private String pintarDatoPantalla(MuleEventContext eventContext){
		
		System.out.println("Empezamos\n");
		
		String ruta = eventContext.getMessage().getInboundProperty("directory").toString() + "\\" +
				eventContext.getMessage().getInboundProperty("originalFilename").toString();
		String nombreRuta = "Energia";
		String json = "";
		Excel excel = null;
		
		ArrayList<TuplaEnergia> tuplas = new ArrayList<TuplaEnergia>();
		
		switch (nombreRuta){
		
		case ExtractorExcel.POTENCIA:
			excel = new Potencia();
			excel.getTipo(ruta);
			break;
		case ExtractorExcel.ENERGIA:
			excel = new Energia();
			excel.getTipo(ruta);
			break;
		case ExtractorExcel.TIEMPO:
			excel = new Tiempo();
			excel.getTipo(ruta);
			break;
		}
		try {
			DataFormatter df = new DataFormatter();
			String valorCelda;
			Sheet hoja = excel.getWorkbook().getSheetAt(0);
			
			
			for (Row fila : hoja){
				
				TuplaEnergia tupla = new TuplaEnergia();
				if(fila.getCell(0) != null && fila.getCell(1) != null & fila.getCell(2) != null){
					
					tupla.setTimestamp(fila.getCell(0).toString());
					tupla.setIdentificadorCt(fila.getCell(1).getNumericCellValue());
					//tupla.setEnergia(fila.getCell(2).getNumericCellValue());
					tuplas.add(tupla);
				}
			}
			
			com.fasterxml.jackson.databind.ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(tuplas);
			System.out.println("lectura termianda\n");
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
