package com.crm.qa.base;


//author is nitesh agrawal
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e;
	public static WebEventListener eventListener;
	
	

	public TestBase()
	{
		try {
		prop=new Properties();
		FileInputStream fs=new FileInputStream("D:\\FreeCRMTest\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fs);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}			
	}
	public static void initialization() throws InterruptedException
	
	{
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\FreeCRMTest\\FreeCRMTest\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\FreeCRMTest\\FreeCRMTest\\FireFoxdriver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		e=new EventFiringWebDriver(driver);
		//Now create an Object of event listener handle to register it with EventFiringWebDriver
		eventListener=new WebEventListener();
		e.register(eventListener);
		driver=e;
		
		
		//maximize the window 
		driver.manage().window().maximize();
		//delete all the cookies of the browser 
		driver.manage().deleteAllCookies();
		//Enter the URL of the application
		driver.get(prop.getProperty("url"));
		//define page load time out 
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		//Implicit time out 
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	}


}


//Base class is done and above parameters are defined
