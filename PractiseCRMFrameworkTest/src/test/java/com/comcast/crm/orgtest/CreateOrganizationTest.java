package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrgTest() throws Throwable {
		// Type of Smoke testing
//		FileUtility flib = new FileUtility();
//		ExcelUtility elib = new ExcelUtility();
//		JavaUtility jlib = new JavaUtility();
//		WebDriverUtility wlib = new WebDriverUtility();

//		flib.getDataFromPropertyFile("Browser");
//		String Browser  =flib.getDataFromPropertyFile("Browser");
//		String URL = flib.getDataFromPropertyFile("Url");
//		String UserName = flib.getDataFromPropertyFile("UserName");
//		String Password = flib.getDataFromPropertyFile("Password");

//		FileInputStream fis = new FileInputStream("C:\\Users\\Ayush Com\\Desktop\\MY Stuff\\VtigercommonData.propreties");
//		Properties pos = new Properties();
//		pos.load(fis);
//		String Browser  = pos.getProperty("Browser");
//		String URL = pos.getProperty("Url");
//		String UserName = pos.getProperty("UserName");
//		String Password = pos.getProperty("Password");
//		
//		Random ran = new Random();
//		int ranNum=ran.nextInt(1000);
		int ranNum = javaUtility.getRandomNumber();

//		FileInputStream fis2 = new FileInputStream("./testData/VtigerTestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis2);
//		Sheet sheet = wb.getSheet("org");
//		Row row=sheet.getRow(1);
		String OrgName = Elib.getDataFromExcel("org", 1, 2) + ranNum;

//WebDriver driver =null;
//if(Browser.equals("chrome")) {
//	driver= new ChromeDriver();
//}
//else if(Browser.equals("firefox")) {
//	driver= new FirefoxDriver();
//}
//else {
//	driver= new ChromeDriver();
//}
//driver.get(URL);
//wlib.waitForPageToLoad(driver);
//LoginPage lp =new LoginPage(driver);
//lp.loginToApp(URL,"admin", "admin");

//driver.findElement(By.name("user_name")).sendKeys(UserName);
//driver.findElement(By.name("user_password")).sendKeys(Password);
//driver.findElement(By.id("submitButton")).click();

//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		HomePage hp = new HomePage(driver);
		hp.getOrgslnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewORgBtn();
//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		CreatingNewOrganizationPage ocp = new CreatingNewOrganizationPage(driver);
		ocp.createNewOrg(OrgName);
//driver.findElement(By.name("accountname")).sendKeys(OrgName);
//driver.findElement(By.xpath("//input[@title='Sae [Alt+S]']")).click();

		/*
		 * // verify Header msg Expected Result
		 * 
		 * //String headerInfo =
		 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 * if(headerInfo.contains(OrgName)) {
		 * System.out.println(OrgName+" is created ===>pass"); } else
		 * System.out.println(OrgName+" is not created ===>fail");
		 */
// verify Header orgName info Expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.verifyHeaderOrgName(OrgName);
//String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
//logout
//hp.logout();
//
//driver.quit();
	}

}
