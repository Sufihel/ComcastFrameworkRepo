package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class OrganizationsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgBtn;
	@FindBy(xpath = "//img[@title='Search in Organizations...']")
	private WebElement searchOrgBtn;
	@FindBy(name = "search_text")
	private WebElement searchEdtBox;
	@FindBy(xpath = "//input[@value=' Search Now ']")
	private WebElement searchBtn;
	@FindBy(id = "bas_searchfield")
	private WebElement searchInDD;

	public WebElement getSearchInBtn() {
		return searchInDD;
	}

	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getSearchOrgBtn() {
		return searchOrgBtn;
	}

	public WebElement getSearchEdtBox() {
		return searchEdtBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void clickOnCreateNewORgBtn() {
		createOrgBtn.click();
	}

	public void clickOnSearchOrgBtn() {
		searchOrgBtn.click();
	}

	public void SearchOrganization(String orgName) {
		searchEdtBox.sendKeys(orgName);
		WebdriverUtility webdriverUtility= new WebdriverUtility();
		webdriverUtility.select(searchInDD, "Organization Name");
		searchBtn.click();
	}

}
