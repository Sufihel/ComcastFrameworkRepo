package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class HomePage {
	// Rule-1: Create a separate java class
	// Rule-2: Object Creation
	WebDriver driver;

	@FindBy(linkText = "Organizations")
	private WebElement orgslnk;
	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	@FindBy(linkText = "Products")
	private WebElement Productslnk;
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlnk;
	@FindBy(linkText = "More")
	private WebElement morelnk;
	@FindAll({ @FindBy(xpath = "(//img[@style='padding: 0px;padding-left:5px'])[1]"),
			@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") })
	private WebElement signoutDropdown;

	@FindBy(linkText = "Sign Out")
	private WebElement signpouBtn;
	// Rule-3: Object Initialization

	public WebElement getSignoutElement() {
		return signoutDropdown;
	}

	public WebElement getSignpouBtn() {
		return signpouBtn;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Rule-4: Object Encapsulation
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgslnk() {
		return orgslnk;
	}

	public WebElement getContactslnk() {
		return contactslnk;
	}

	public WebElement getProductslnk() {
		return Productslnk;
	}

	public WebElement getCampaignlnk() {
		return campaignlnk;
	}

	// Rule-5: Provide Action
	public void clickOnOrgaizations() throws Throwable {

		orgslnk.click();
	}

	public void clickOnContacts() {
		contactslnk.click();
	}

	public void clickOnProducts() {
		Productslnk.click();
	}

	public void navigateToCampaignPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(morelnk).perform();
		campaignlnk.click();
	}

	public void logout() throws InterruptedException {
		WebdriverUtility WBUtility= new WebdriverUtility();
		WBUtility.waitForElementPresent(driver, signoutDropdown);
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(signoutDropdown).perform();
		Thread.sleep(2000);
		
		WBUtility.waitForElementPresent(driver, signpouBtn);
		signpouBtn.click();
	}

}
