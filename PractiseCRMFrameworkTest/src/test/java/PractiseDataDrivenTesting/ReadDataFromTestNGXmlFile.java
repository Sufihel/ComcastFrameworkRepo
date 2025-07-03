package PractiseDataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXmlFile {

	@Test
	public void samplTest(XmlTest test) throws Throwable {

		WebDriver driver = null;
		// READ COMMON DATA FROM xml FILE
		String URL = test.getParameter("url");
		String BROWSER = test.getParameter("browser");
		String USERNAME = test.getParameter("username");
		String USERPASSWORD = test.getParameter("password");
		// READ TEST SCRIPT DATA FROM EXCEL FIEL

		FileInputStream fileInputStream = new FileInputStream("./src/test/resources/DataDrivenTesting.xlsx");
		Random random = new Random();
		int randomdata = random.nextInt(10000);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet2");
		String orgnameString = sheet.getRow(1).getCell(2).getStringCellValue() + randomdata;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Step1 login is done
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(USERPASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		// Step2 Navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		// step3 click on create organization button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("accountname")).sendKeys(orgnameString);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		workbook.close();
		Thread.sleep(2000);
		driver.quit();

	}
}
