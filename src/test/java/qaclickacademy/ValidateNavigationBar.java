package qaclickacademy;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
//Adding logs 
//Generating html reports 
//Screenshots on failure 
//Jenkins integration 
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class ValidateNavigationBar extends base{
	public WebDriver driver;
	
	public static  Logger log=Logger.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void validateAppNavBar()throws IOException
	{
		//one is inheritance
		//creating object to that class and invoke methods of it 
	
		LandingPage l=new LandingPage(driver);
		
		//compare the text from the browser with ax`ctual text.- Error..
		//driver.findElement(l.Navbar);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed ");
		// Assert.assertFalse(false);
		
		
		
		}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
