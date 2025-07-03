package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author saif
 * 
 * Contains login page elements and business librarylike login
 */

public class LoginPage {// Rule-1: Create a separate java class
	// Rule-2: Object Creation
	WebDriver driver;

	@FindBy(name = "user_name")
	private WebElement usernameEdit;
	@FindBy(name = "user_password")
	private WebElement passwordEdit;
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	// Rule-3: Object Initialization
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Rule-4: Object Encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Rule-5: Provide Action
	/**
	 * Maximise the window
	 * Login to application based on username and password
	 * @param username
	 * @param password
	 * @throws Throwable
	 */
	
	public void loginToApp(String username, String password) throws Throwable {
		// driver.manage().window().minimize();
		//Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}

}
