package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {
	@Test
	public void createContactWithSupportDateTest() throws Throwable {
		String LastName = Elib.getDataFromExcel("Product", 2, 0) + javaUtility.getRandomNumber();

//Date dataObj = new Date();
//SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//String StartDate= sim.format(dataObj);
//
//Calendar cal = sim.getCalendar();
//cal.add(Calendar.DAY_OF_MONTH, 30);
//String EndDate = sim.format(cal.getTime());
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
			System.out.println(LastName + " is created ===>pass");
		} else
			System.out.println(LastName + " is not created ===>fail");

//verify Header msg Expected Result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(StartDate)) {
			System.out.println(StartDate + " information is verified ===>pass");
		} else
			System.out.println(StartDate + " information is not verified ===>fail");

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(EndDate)) {
			System.out.println(EndDate + " information is verified ===>pass");
		} else
			System.out.println(EndDate + " information is not verified ===>fail");

	}

}
