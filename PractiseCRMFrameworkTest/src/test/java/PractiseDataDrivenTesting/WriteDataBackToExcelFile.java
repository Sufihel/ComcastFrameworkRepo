package PractiseDataDrivenTesting;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\DataDrivenTesting.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet2");
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellValue("pass");
		FileOutputStream fileOutputStream = new FileOutputStream(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\DataDrivenTesting.xlsx");
		workbook.write(fileOutputStream);
		workbook.close();
	}

}
