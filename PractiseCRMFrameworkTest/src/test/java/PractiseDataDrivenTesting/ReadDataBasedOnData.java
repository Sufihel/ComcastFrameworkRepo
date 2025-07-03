package PractiseDataDrivenTesting;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnData {

	public static void main(String[] args) throws Throwable {
		String expectedtestcaseid = "tc_102";
		boolean flag = false;
		String data1 = "";
		String data2 = "";
		String data3 = "";
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\DataDrivenTesting.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet2");

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String data = "";

			try {
				data = sheet.getRow(i).getCell(0).toString();
				if (data.equalsIgnoreCase(expectedtestcaseid)) {
					flag = true;
					data1 = sheet.getRow(i).getCell(0).toString();
					data2 = sheet.getRow(i).getCell(1).toString();
					data3 = sheet.getRow(i).getCell(2).toString();
				}
			} catch (Exception e) {
			}
		}
		if (flag == true) {
			System.out.print(data1);
			System.out.print("/t");
			System.out.print(data2);
			System.out.print("/t");
			System.out.print(data3);
			System.out.print("/t");
		} else {
			System.out.println(expectedtestcaseid + " is not available");
		}
		workbook.close();

	}
}