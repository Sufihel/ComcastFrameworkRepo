package com.crm.comcast.orgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.Baseclass1;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends Baseclass1 {
	@Test(groups = { "smokeTest", "regressionTest" })
	public void CreateOrgTest() throws Throwable {
		String OrgName = Elib.getDataFromExcel("org", 1, 2) + javaUtility.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgslnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewORgBtn();
		CreatingNewOrganizationPage ocp = new CreatingNewOrganizationPage(driver);
		ocp.createNewOrg(OrgName);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.verifyHeaderOrgName(OrgName);
	}

	@Test(groups = "regressionTest")
	public void CreateOrgWithIndustriesTest() throws Throwable {
		String OrgName = Elib.getDataFromExcel("org", 4, 2) + javaUtility.getRandomNumber();
		String industry = Elib.getDataFromExcel("org", 4, 3);
		String type = Elib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgslnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewORgBtn();
		CreatingNewOrganizationPage ocp = new CreatingNewOrganizationPage(driver);
		ocp.createNewOrgWithIndustryAndType(OrgName, industry, type);

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
	}

	@Test(groups = "regressionTest")
	public void CreateOrgWithPhNOTest() throws Throwable {
		String OrgName = Elib.getDataFromExcel("org", 7, 2) + javaUtility.getRandomNumber();
		String PhNo = Elib.getDataFromExcel("org", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgslnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewORgBtn();
		CreatingNewOrganizationPage ocp = new CreatingNewOrganizationPage(driver);
		ocp.createNewOrg(OrgName, PhNo);

		// verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(OrgName)) {
			System.out.println(OrgName + " is created ===>pass");
		} else
			System.out.println(OrgName + " is not created ===>fail");

		// verify Header orgName info Expected result
		String actPhNo = driver.findElement(By.id("mouseArea_Phone")).getText();
		if (actPhNo.contains(PhNo)) {
			System.out.println(PhNo + " information is verified ===>pass");
		} else
			System.out.println(PhNo + " information is not verified ===>fail");
	}
}
