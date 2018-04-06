package usoExcels;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

public class TuplaEnergia {

	private String timestamp;
	private double identificadorCt;
	//private double energia;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public double getIdentificadorCt() {
		return identificadorCt;
	}
	public void setIdentificadorCt(double identificadorCt) {
		this.identificadorCt = identificadorCt;
	}/*
	public double getEnergia() {
		return energia;
	}

	public void setEnergia(double energia) {
		this.energia = energia;
	}*/
	
	public void agregarFila(Cell cell){
		
		 switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            System.out.println(cell.getRichStringCellValue().getString());
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                System.out.println(cell.getDateCellValue());
            } else {
                System.out.println(cell.getNumericCellValue());
            }
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            System.out.println(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            System.out.println(cell.getCellFormula());
            break;
        default:
            System.out.println();
    }
	}
}
