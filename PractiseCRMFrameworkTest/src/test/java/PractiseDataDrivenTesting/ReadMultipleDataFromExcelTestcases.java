package PractiseDataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTestcases {

	public static void main(String[] args) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\DataDrivenTesting.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(1);
			String Data = cell.toString();
			System.out.println(Data);
			workbook.close();
		}
	}

}
