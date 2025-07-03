package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws Throwable, IOException {
		FileInputStream fileInputStream = new FileInputStream("./testData/DataDrivenTesting.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		String dataString = workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue()
				.toString();
		workbook.close();
		return dataString;
	}

	public int getrowcount(String sheetName) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./testData/DataDrivenTesting.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		int rowCount = workbook.getSheet(sheetName).getLastRowNum();
		workbook.close();
		return rowCount;
	}
	public void setDataIntoExcel(String sheetname, int rownum, int cellnum, String data) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./testData/DataDrivenTesting.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		workbook.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
		FileOutputStream fileOutputStream= new FileOutputStream("./testData/DataDrivenTesting.xlsx");
		workbook.write(fileOutputStream);
		workbook.close();
		
	}

}
