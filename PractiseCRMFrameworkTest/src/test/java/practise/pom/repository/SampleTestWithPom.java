package practise.pom.repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {
	@FindBy(name = "user_name")
	WebElement element1;
	@FindBy(name = "user_password")
	WebElement element2;
	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']") })
	WebElement element3;

	@Test
	public void sampleTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");

		SampleTestWithPom sampleTestWithPom = PageFactory.initElements(driver, SampleTestWithPom.class);

		sampleTestWithPom.element1.sendKeys("admin");
		sampleTestWithPom.element2.sendKeys("admin");

		sampleTestWithPom.element3.click();
		Thread.sleep(2000);
		driver.close();
	}
}
