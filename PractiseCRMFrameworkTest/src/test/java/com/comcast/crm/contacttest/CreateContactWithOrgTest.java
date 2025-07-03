package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility wlib = new WebdriverUtility();

		flib.getdatafrompropertiesfile("Browser");
		String Browser = flib.getdatafrompropertiesfile("Browser");
		String URL = flib.getdatafrompropertiesfile("Url");
		String UserName = flib.getdatafrompropertiesfile("UserName");
		String Password = flib.getdatafrompropertiesfile("Password");

		String OrgName = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String LastName = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();

		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
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
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
//verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(OrgName)) {
			System.out.println(OrgName + " is created ===>pass");
		} else
			System.out.println(OrgName + " is not created ===>fail");

//navigate to contact module

		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

// switch to child window
//Set<String> elements = driver.getWindowHandles();
//Iterator<String> it = elements.iterator();
//while(it.hasNext()) {
//	String winId = it.next();
//	driver.switchTo().window(winId);
//	String actUrl = driver.getCurrentUrl();
//	if(actUrl.contains("module=Accounts")) {
//		break;
//	}	
//}
		wlib.switchToTabOnUrl(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();
		wlib.switchToTabOnTitle(driver, "module=Contacts");
////switch to Parent window
//Set<String> elements2 = driver.getWindowHandles();
//Iterator<String> it2 = elements2.iterator();
//while(it2.hasNext()) {
//	String winId = it2.next();
//	driver.switchTo().window(winId);
//	String actUrl = driver.getCurrentUrl();
//	if(actUrl.contains("module=Contacts")) {
//		break;
//	}	
//}

		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

//verify Header msg Expected Result
		String headerInfo2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo2.contains(LastName)) {
			System.out.println(LastName + " is created ===>pass");
		} else
			System.out.println(LastName + " is not created ===>fail");

//verify Header msg Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(OrgName)) {
			System.out.println(OrgName + " information is verified ===>pass");
		} else
			System.out.println(OrgName + " information is not verified ===>fail");

//logout

		driver.quit();
	}

}
