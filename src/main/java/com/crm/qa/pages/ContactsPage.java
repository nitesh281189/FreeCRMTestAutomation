package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	@CacheLookup //It will create small memory and store in that memory called cache memory
				 //and it will get data from cache memory 
				 //It increases the speed of the framework
				 //All the elements will be store in cache memory.It will pick from cache memory
				 //The problem is if somehow the element is refreshed or page got refreshed 
				 //Or if some dom property is changed, then cache memory element will be changed 
				 //It should not be used for each and every element. 
				 //To increase performance we use cache look up
	WebElement contactsLabel;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement newContact;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='company']//input")
	WebElement company;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;

	// @FindBy(xpath="//div[@class='ui checked fitted read-only checkbox']//input")
	// WebElement checkboxClick;

	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();

	}

	public void selectContactsByName(String name) {
		// name is to pass the contact name
		// We have to be generic with the framework design

		driver.findElement(
				By.xpath("//a[contains(text()," + name + ")]//parent::td//preceding-sibling::td//div//input")).click();
	}

	public void clickOnCreateContact() {
		newContact.click();
	}

	public void createNewContact(String status, String firstname, String lastname, String comp) {
		//Select select = new Select(driver.findElement(By.name("status")));
		//select.selectByVisibleText(status);

		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		company.sendKeys(comp);
		saveButton.click();

	}

}


//@FindBy is not a good solution for the check box beacuse its not viable 
