package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgNameInOrgInformationColumn;
	@FindBy(id = "dtlview_Industry")
	private WebElement IndustrytypeInOrgInformationColumn;
	@FindBy(id = "dtlview_Type")
	private WebElement IndustryAccounttypeInOrgInformationColumn;
	@FindBy(id = "mouseArea_Phone")
	private WebElement phoneInOrgInformationColumn;

	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement headerElement() {
		return headerMsg;
	}

	public WebElement getOrgNameInOrgInformationColumn() {
		return orgNameInOrgInformationColumn;
	}

	public WebElement getIndustrytypeInOrgInformationColumn() {
		return IndustrytypeInOrgInformationColumn;
	}

	public WebElement getIndustryAccounttypeInOrgInformationColumn() {
		return IndustryAccounttypeInOrgInformationColumn;
	}

	public WebElement getPhoneInOrgInformationColumn() {
		return phoneInOrgInformationColumn;
	}

	public void verifyHeaderOrgName(String actualOrgName) {
		String orgname = headerElement().getText();
		if (orgname.contains(actualOrgName)) {
			System.out.println(actualOrgName + " header verified= PASS");
		} else {
			System.out.println(actualOrgName + " header not verified= FAIL");
		}
	}

	public void verifyIndustryType(String IndustryType) {
		String industryType = IndustrytypeInOrgInformationColumn.getText();
		if (industryType.contains(IndustryType)) {
			System.out.println(IndustryType + "  verified= PASS");
		} else {
			System.out.println(IndustryType + "  not verified= FAIL");
		}
	}

	public void verifyOrgName(String actualOrgName) {
		String displayInfobox = orgNameInOrgInformationColumn.getText();
		if (displayInfobox.trim().equalsIgnoreCase(actualOrgName)) {
			System.out.println(actualOrgName + "  verified= PASS");
		} else {
			System.out.println(actualOrgName + "  not verified= FAIL");
		}
	}

	public void accountType(String Account) {
		String AccountType = IndustryAccounttypeInOrgInformationColumn.getText();
		if (AccountType.contains(Account)) {
			System.out.println(Account + "  verified= PASS");
		} else {
			System.out.println(Account + "  not verified= FAIL");
		}
	}

	public void phoneWithORG(String phone) {
		String phonenum = phoneInOrgInformationColumn.getText();
		if (phonenum.contains(phone)) {
			System.out.println(phone + "  verified= PASS");
		} else {
			System.out.println(phone + "  not verified= FAIL");
		}
	}

}