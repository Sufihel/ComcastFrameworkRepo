package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable {

		String LastName = Elib.getDataFromExcel("Sheet2", 4, 2) + javaUtility.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactslnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewConBtn().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(LastName);

// verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(LastName)) {
			System.out.println(LastName + " is created ===>pass");
		} else
			System.out.println(LastName + " is not created ===>fail");

	}
}
