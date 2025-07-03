package PractiseDataDrivenTesting;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRuntime {
@Test
public void seleniumTest() throws Throwable {
	WebDriver driver = null;
	// READ TEST common DATA FROM CMD MAVEN
	String URL = System.getProperty("url");
	String BROWSER = System.getProperty("browser");
	String USERNAME = System.getProperty("username");
	String USERPASSWORD = System.getProperty("password");
	// READ TEST SCRIPT DATA FROM EXCEL FIEL

	/*
	 * FileInputStream fileInputStream = new
	 * FileInputStream("./src/test/resources/DataDrivenTesting.xlsx"); Random random
	 * = new Random(); int randomdata = random.nextInt(10000); Workbook workbook =
	 * WorkbookFactory.create(fileInputStream); Sheet sheet =
	 * workbook.getSheet("Sheet2"); String orgnameString =
	 * sheet.getRow(1).getCell(2).getStringCellValue() + randomdata;
	 */
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
	driver.quit();
}
}
