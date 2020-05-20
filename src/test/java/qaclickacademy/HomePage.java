package qaclickacademy;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ForgotPassword;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static  Logger log=Logger.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	 	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation (String Username,String Password,String text) throws IOException
	{
		
		//one is inheritance
		//creating object to that class and invoke methods of it 
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		((WebElement) l.getLogin()).click();  // diver.findElement(By.css())
	    LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys("Username");
		lp.getPassword().sendKeys("Password");
		
		log.info(text);
		
		lp.getLogin().click();
		/*ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();*/
		
		
		}  
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stand for how many different data type test should 	run 
		//coloumn stand for how many values per each test 
		Object[][] data=new Object[2][3];
		//0th Row 
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		/*//1st Row 
		data[1][0]="abc@qw.com";
		data[1][1]="456789";
		//data[1][2]="Resticted User";*/
		
		return data;
	}

}
