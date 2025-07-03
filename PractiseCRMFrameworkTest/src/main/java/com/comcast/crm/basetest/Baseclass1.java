package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class Baseclass1 {
	public DatabaseUtility dbLib = new DatabaseUtility();
	public FileUtility fileUtility = new FileUtility();
	public WebdriverUtility webdriverUtility = new WebdriverUtility();
	public JavaUtility javaUtility = new JavaUtility();
	public ExcelUtility Elib = new ExcelUtility();
	public WebDriver driver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBeforeSuite() throws Throwable {
		Reporter.log("=====Connect to DB , Report config=====");
		dbLib.getDbConnection("jdbc:mysql://localhost:3307/projects", "root", "root");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAfterSuite() throws Throwable {
		Reporter.log("====== Close DB , Report backup======");
		dbLib.closeDbConnection();
		
	}

	@Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBeforeClass(String Browser) throws Throwable {
		Reporter.log("====Launch the Browser====");
		String BROWSER = Browser;
		// String BROWSER = fileUtility.getdatafrompropertiesfile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
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

	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAfterClass() {
		Reporter.log("====Close the Browser====");
		driver.quit();
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBeforeMethod() throws Throwable {
		Reporter.log("=login to App=");
		String URL = fileUtility.getdatafrompropertiesfile("url");
		webdriverUtility.waitForPageToLoad(driver);
		driver.get(URL);
		String USERNAME = fileUtility.getdatafrompropertiesfile("username");
		String USERPASSWORD = fileUtility.getdatafrompropertiesfile("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, USERPASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAfterMethod() throws Throwable {
		Reporter.log("=logout to App=");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

}
