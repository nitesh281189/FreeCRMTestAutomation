package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory or OR-Object Repository
	
	@FindBy(xpath="//a[@class=\"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")
	WebElement login;
	
	@FindBy(name = "email")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;

	@FindBy(linkText = "Sign Up")
	WebElement signup;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		login.click();
		return driver.getTitle();
	}
	public HomePage login(String un, String pass) {
		login.click();
		email.sendKeys(un);
		password.sendKeys(pass);
		loginbtn.click();
		return new HomePage();
	}
	
}
