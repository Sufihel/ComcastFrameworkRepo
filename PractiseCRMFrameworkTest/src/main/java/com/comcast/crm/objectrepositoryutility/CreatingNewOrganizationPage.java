package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreatingNewOrganizationPage {
	@FindBy(name = "accountname")
	private WebElement orgNameEdtBox;
	@FindBy(name = "phone")
	private WebElement phoneEdtBox;
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	@FindBy(name = "accounttype")
	private WebElement accountTypeDropdown;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	WebDriver driver;
	WebdriverUtility webdriverUtility = new WebdriverUtility();

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdtBox() {
		return orgNameEdtBox;
	}

	public WebElement getPhoneEdtBox() {
		return phoneEdtBox;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getAccountTypeDropdown() {
		return accountTypeDropdown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void createNewOrg(String orgname) {
		orgNameEdtBox.sendKeys(orgname);
		SaveBtn.click();
	}

	public void createNewOrg(String orgname, String phoneNum) {
		orgNameEdtBox.sendKeys(orgname);
		phoneEdtBox.sendKeys(phoneNum);
		SaveBtn.click();
	}

	public void createNewOrgWithIndustryAndType(String orgname, String IndustryType, String accountType) {
		orgNameEdtBox.sendKeys(orgname);
		webdriverUtility.select(industryDropdown, IndustryType);
		webdriverUtility.select(getAccountTypeDropdown(), accountType);
		SaveBtn.click();
	}

	public void createNewOrgWithIndustry(String orgname, int index) {
		orgNameEdtBox.sendKeys(orgname);
		webdriverUtility.select(industryDropdown, index);
		SaveBtn.click();
	}

	public void createOrgWithType(String orgname, String accountType) {
		orgNameEdtBox.sendKeys(orgname);
		webdriverUtility.select(getAccountTypeDropdown(), accountType);

	}

	public void createOrgWithType(String orgname, int index) {
		orgNameEdtBox.sendKeys(orgname);
		webdriverUtility.select(getAccountTypeDropdown(), index);

	}

}
