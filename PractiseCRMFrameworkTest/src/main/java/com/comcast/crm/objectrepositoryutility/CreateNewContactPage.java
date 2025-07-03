package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewContactPage {
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement conLastName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "support_start_date")
	private WebElement conStartDate;

	@FindBy(name = "support_end_date")
	private WebElement conEndDate;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgSelectBtn;

	public WebElement getOrgSelectBtn() {
		return orgSelectBtn;
	}

	public WebElement getConStartDate() {
		return conStartDate;
	}

	public WebElement getConEndDate() {
		return conEndDate;
	}

	public WebElement getConLastName() {
		return conLastName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String lastName) {
		conLastName.sendKeys(lastName);
		saveBtn.click();
	}

	public void createContactWithSupportDate(String lastName, String startDate, String endDate) {
		conLastName.sendKeys(lastName);
		conStartDate.clear();
		conStartDate.sendKeys(startDate);
		conEndDate.clear();
		conEndDate.sendKeys(endDate);
		saveBtn.click();
	}

	public void createContactWithOrg(String lastName, String OrgName) {
		conLastName.sendKeys(lastName);
		orgSelectBtn.click();
		WebdriverUtility wlib = new WebdriverUtility();
		wlib.switchToTabOnUrl(driver, "module=Accounts");
		OrganizationPopUpPage orgPopUp = new OrganizationPopUpPage(driver);
		orgPopUp.searchOrgName(OrgName);
		wlib.switchToTabOnUrl(driver, "module=Contacts");
		saveBtn.click();
	}
}
