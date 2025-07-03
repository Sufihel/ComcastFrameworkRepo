package practise.testNG;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {

	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// sTEP-1: Create an object to TakeScreenShot
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dstFile= new File("./Screenshots/test.png");
		FileUtils.copyFile(srcFile, dstFile);
		driver.close();
	}

}
