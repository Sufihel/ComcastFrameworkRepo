package com.crm.comcast.contacttest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.Baseclass1;
import com.comcast.crm.objectrepositoryutility.ContactDetailsPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class CreateContactTest extends Baseclass1 {
	

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

		String LastName = Elib.getDataFromExcel("Sheet2", 4, 2) + javaUtility.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactslnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewConBtn().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(LastName);

// verify Header msg Expected Result
		ContactDetailsPage cdp = new ContactDetailsPage(driver);
		
		//String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		String headerInfo =  cdp.getHeaderMsg().getText();
		
		if (headerInfo.contains(LastName)) {
			Reporter.log(LastName + " is created ===>pass");
		} else
			Reporter.log(LastName + " is not created ===>fail");
//		boolean status = headerInfo.contains(LastName);
//		Assert.assertEquals(status, true);

		//String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String actLastName =cdp.getActLastName().getText();
		
		if(actLastName.equals(LastName)) {
			Reporter.log(LastName+ " information is verified==PASS");
		}
		else
			Reporter.log(LastName+ " information is verified==FAIL");
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(actLastName, LastName);
//		sa.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		String LastName = Elib.getDataFromExcel("Sheet2", 7, 2) + javaUtility.getRandomNumber();

		String StartDate = javaUtility.getSystemDateInDDMMYYYY();
		String EndDate = javaUtility.getRequiredDateDDMMYYYY(30);

		HomePage hp = new HomePage(driver);
		hp.getContactslnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewConBtn().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithSupportDate(LastName, StartDate, EndDate);

		// verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(LastName)) {
			Reporter.log(LastName + " is created ===>pass");
		} else
			Reporter.log(LastName + " is not created ===>fail");

		// verify Header msg Expected Result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(StartDate)) {
			Reporter.log(StartDate + " information is verified ===>pass");
		} else
			Reporter.log(StartDate + " information is not verified ===>fail");

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(EndDate)) {
			Reporter.log(EndDate + " information is verified ===>pass");
		} else
			Reporter.log(EndDate + " information is not verified ===>fail");
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		String OrgName = Elib.getDataFromExcel("Sheet2", 7, 2) + javaUtility.getRandomNumber();
		String LastName = Elib.getDataFromExcel("Sheet2", 7, 3) + javaUtility.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgslnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewORgBtn();
		CreatingNewOrganizationPage ocp = new CreatingNewOrganizationPage(driver);
		ocp.createNewOrg(OrgName);

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(OrgName)) {
			Reporter.log(OrgName + " is created ===>pass");
		} else
			Reporter.log(OrgName + " is not created ===>fail");

		hp.getContactslnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewConBtn().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithOrg(LastName, OrgName);

		// verify Header msg Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(OrgName)) {
			Reporter.log(OrgName + " information is verified ===>pass");
		} else
			Reporter.log(OrgName + " information is not verified ===>fail");
	}
	
}
