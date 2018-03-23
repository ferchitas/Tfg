import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class ExtractorExcel implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		this.pintarDatoPantalla();
		return null;
	}


	private void pintarDatoPantalla(){
		
		System.out.println("Empezamos\n");
		File file = new File("C:\\CT_Meter_20171211-033407_Energía_Octubre_2015.xlsx");
		FileInputStream POIF = null;
		try {
			POIF = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(POIF);
			Sheet hoja = workbook.getSheet("Dataset 1");
			for (Row fila : hoja){
				
				for(Cell cell : fila){
					
					System.out.println(cell.getStringCellValue());
				}
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
