package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateOrganizationWithPhoneNoTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility wlib = new WebdriverUtility();
		
		String Browser  =flib.getdatafrompropertiesfile("browser");
		String URL = flib.getdatafrompropertiesfile("url");
		String UserName = flib.getdatafrompropertiesfile("username");
		String Password = flib.getdatafrompropertiesfile("password");
				
		
		int ranNum=jlib.getRandomNumber();

		String OrgName = elib.getDataFromExcel("org", 7, 2)+ranNum;
		String PhNo = elib.getDataFromExcel("org", 7, 3);
		
WebDriver driver =null;
if(Browser.equals("chrome")) {
	driver= new ChromeDriver();
}
else if(Browser.equals("firefox")) {
	driver= new FirefoxDriver();
}
else {
	driver= new ChromeDriver();
}

wlib.waitForPageToLoad(driver);
driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(UserName);
driver.findElement(By.name("user_password")).sendKeys(Password);
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

driver.findElement(By.name("accountname")).sendKeys(OrgName);
driver.findElement(By.id("phone")).sendKeys(PhNo);
driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

// verify Header msg Expected Result
String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(headerInfo.contains(OrgName)) {
	System.out.println(OrgName+" is created ===>pass");
}
else
	System.out.println(OrgName+" is not created ===>fail");

// verify Header orgName info Expected result
String actPhNo = driver.findElement(By.id("mouseArea_Phone")).getText();
if(actPhNo.contains(PhNo)) {
	System.out.println(PhNo+" information is verified ===>pass");
}
else
	System.out.println(PhNo+" information is not verified ===>fail");

//logout

driver.quit();
	}

}
