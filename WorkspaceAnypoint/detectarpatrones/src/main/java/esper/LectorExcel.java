package esper;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;

public class LectorExcel implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		this.pintarDatoPantalla();
		return null;
	}


	private void pintarDatoPantalla(){
		
		File file = new File("C:\\CT_Meter_20171211-033407_Energía_Octubre_2015.xlsx");
		FileInputStream POIF = null;
		try {
			POIF = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(POIF);
			Sheet spreadsheet = workbook.getSheet("Dataset 1");
			Row row = spreadsheet.getRow(0);
			Cell cell = row.getCell(0);
			System.out.println(cell.getStringCellValue());
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