package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	HomePage hp;
	LoginPage lp;
	ContactsPage cp;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod

	public void setup() throws InterruptedException {
		TestBase.initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		cp=hp.clickOnContactsLink();
	}

	@Test(priority = 1)

	public void verifyConatctsPageLabelTest() {
		boolean f = cp.verifyContactsLabel();
		Assert.assertTrue(f, "Contact is missing from the Label");
	}

//	@Test(priority = 2)
//	public void selectContactTest() {
//		cp.selectContactsByName("AyanshAgrawal");
//	}

	
	@DataProvider
	public void getTestData()
	{
				
	}
	
	@Test
	public void validateCreateNewContact()
	{
		cp.clickOnCreateContact();
		cp.createNewContact("New", "Tom", "Peter", "Google");
	}
	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
