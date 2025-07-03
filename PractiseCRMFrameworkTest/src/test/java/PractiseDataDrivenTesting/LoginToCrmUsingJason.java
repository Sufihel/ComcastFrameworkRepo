package PractiseDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class LoginToCrmUsingJason {

	public static void main(String[] args) throws Throwable, IOException, ParseException {
		WebDriver driver = null;
		JSONParser parser = new JSONParser();
		/*
		 * Proper way to parse the file and load to jsonobject refrance variable to be
		 * in key value format
		 * 
		 * Object object= parser.
		 * parse("C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\appCommonData.json"
		 * ); JSONObject som= (JSONObject) object;
		 */
		JSONObject object = (JSONObject) (parser.parse(new FileReader(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\appCommonData.json")));
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\DataDrivenTesting.xlsx");
		String URL = object.get("url").toString();
		String BROWSER = object.get("browser").toString();
		String USERNAME = object.get("username").toString();
		String USERPASSWORD = object.get("password").toString();
		Random random = new Random();
		int randomdata = random.nextInt(10000);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet2");
		String orgnameString = sheet.getRow(1).getCell(2).getStringCellValue() + randomdata;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new SafariDriver();
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
		Thread.sleep(2000);
		workbook.close();
		driver.quit();
	}

}
