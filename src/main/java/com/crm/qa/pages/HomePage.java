package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameDisplayed;
	
	@FindBy(linkText="Contacts")
	WebElement contacts;
	//span[contains(text(),'Contacts')]//parent::a
	
	@FindBy(linkText="Deals")
	WebElement deals;
	
	//span[contains(text(),'Contacts')]

	//Initializing the items 
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink()
	{
		TestUtil.clickon(driver, contacts, TestUtil.explicit_wait);
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink()
	{
		deals.click();
		return new DealsPage();
		
	}

	public boolean verifyCorrectUserName()
	{
		return userNameDisplayed.isDisplayed();
	}
}


