package PractiseDataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		FileInputStream fiS = new FileInputStream(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\DataDrivenTesting.xlsx");

		Workbook workbook = WorkbookFactory.create(fiS);
		Sheet sheet = workbook.getSheet("ORG");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String data= cell.getStringCellValue();
		System.out.println(data);

		/*
		 * // As we can write in optimized way by using method chaining way String data
		 * = WorkbookFactory.create(fiS).getSheet("ORG").getRow(2).getCell(0).
		 * getStringCellValue(); System.out.println(data);
		 * 
		 */
		workbook.close();
	}

}
