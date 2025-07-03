package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	@Test
	public void checkDeleteOrg() throws Throwable {
		WebDriver driver = null;
		FileUtility fileUtility = new FileUtility();
		JavaUtility javaUtility = new JavaUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();

		String URL = fileUtility.getdatafrompropertiesfile("url");
		String BROWSER = fileUtility.getdatafrompropertiesfile("browser");
		String USERNAME = fileUtility.getdatafrompropertiesfile("username");
		String USERPASSWORD = fileUtility.getdatafrompropertiesfile("password");

		int randomdata = javaUtility.getRandomNumber();
		String orgnameString = excelUtility.getDataFromExcel("Sheet2", 1, 2) + randomdata;
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
		webdriverUtility.waitForPageToLoad(driver);
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, USERPASSWORD);
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrgaizations();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.clickOnCreateNewORgBtn();
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		creatingNewOrganizationPage.createNewOrg(orgnameString);
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		organizationInfoPage.verifyHeaderOrgName(orgnameString);
		homePage.clickOnOrgaizations();
		organizationsPage.SearchOrganization(orgnameString);
		driver.findElement(By.xpath("//a[text()='" + orgnameString + "']/../../td[8]/a[text()='del']")).click();
		Thread.sleep(2000);
		webdriverUtility.switchToAcceptAlert(driver);
		Thread.sleep(2000);
		homePage.logout();
		driver.quit();

	}

}
