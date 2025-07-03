package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws Throwable {

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility wlib = new WebdriverUtility();

		
		String Browser = flib.getdatafrompropertiesfile("browser");
		String URL = flib.getdatafrompropertiesfile("url");
		String UserName = flib.getdatafrompropertiesfile("username");
		String Password = flib.getdatafrompropertiesfile("password");

		int ranNum = jlib.getRandomNumber();

		String OrgName = elib.getDataFromExcel("org", 4, 2) + ranNum;
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		WebDriver driver = null;
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		Select sel = new Select(driver.findElement(By.name("industry")));
		sel.selectByVisibleText(industry);
		Select sel2 = new Select(driver.findElement(By.name("accounttype")));
		sel2.selectByVisibleText(type);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

// verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(OrgName)) {
			System.out.println(OrgName + " is created ===>pass");
		} else
			System.out.println(OrgName + " is not created ===>fail");

// verify Header orgName info Expected result
		String actIndustry = driver.findElement(By.id("mouseArea_Industry")).getText();
		if (actIndustry.equals(industry)) {
			System.out.println(industry + " information is Verified ===>pass");
		} else
			System.out.println(industry + " information is not Verified ===>fail");

		String actType = driver.findElement(By.id("mouseArea_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " information is Verified ===>pass");
		} else
			System.out.println(type + " information is not Verified ===>fail");

//verify the industries and type info

		driver.quit();
	}

}
