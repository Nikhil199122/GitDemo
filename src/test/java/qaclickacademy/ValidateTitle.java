package qaclickacademy;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class ValidateTitle extends base{
	public WebDriver driver;
	public static  Logger log=Logger.getLogger(base.class.getName());
	LandingPage l;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to Home Page");
		
	}
	
	@Test
	public void ValidateAppTitle ()throws IOException
	{
		
		//one is inheritance
		//creating object to that class and invoke methods of it
		l=new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURES");
		log.info("Successfully valideted Text message");
		System.out.println("Test completed ");
		}
	
	@Test
	public void ValidateHeader ()throws IOException
	{
		
		Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
		}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
