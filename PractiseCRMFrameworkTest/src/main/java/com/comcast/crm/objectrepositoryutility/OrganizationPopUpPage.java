package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopUpPage {
	WebDriver driver;
	public OrganizationPopUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTxtField;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchOrgName(String OrgName) {
		searchTxtField.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
	}
	
}
