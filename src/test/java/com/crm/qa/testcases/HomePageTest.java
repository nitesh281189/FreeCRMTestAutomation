package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//Control+Shift+o  for auto import of the packages and class.

public class HomePageTest extends TestBase {
	HomePage hp;
	LoginPage lp;
	ContactsPage cp;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException

	{
		TestBase.initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	
	public void verifyHomePageTitleTest()
	{
		String title=hp.validateHomePageTitle();
		Assert.assertEquals(title,"Cogmento CRM","HomePageTitleNotMatched");
		//Message is printed only when test case is failed
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest()
	{
		boolean f=hp.verifyCorrectUserName();
		Assert.assertTrue(f,"UserNameNotFound");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		cp=hp.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

//Write Test at the end when writing test methods 
//In above scenario for every test case browser will be launched 
//and then test will be executed and browser will be closed 
//So in case of 100 test cases , 100 times browser will be launched and 
//activity will be performed 
//This is the best practice because browser will be exhausted otherwise 
//Also the test case should be independent of each other 
//We should avoid dependency between two test cases 
//before each test case launch the browser and login
//After each test case close the browser 
//Always close the browser after the test case is executed.



