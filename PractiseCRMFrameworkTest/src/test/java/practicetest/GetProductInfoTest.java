package practicetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductInfo(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/ref=nav_logo");

		// search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

		// capture product info
		String xString = "(//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]/span/span[2])[1]";

		String price = driver.findElement(By.xpath(xString)).getText();
		System.out.println("    ");
		System.out.println(price);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		int rowcount = elib.getrowcount("Product");

		Object[][] objects = new Object[rowcount][2];

		for (int i = 0; i < rowcount; i++) {
			objects[i][0] = elib.getDataFromExcel("Product", i + 1, 0);
			objects[i][1] = elib.getDataFromExcel("Product", i + 1, 1);
		}

		return objects;
	}
}
