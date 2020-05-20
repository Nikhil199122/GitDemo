package qaclickacademy;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

import java.io.PrintStream;

import javax.naming.ldap.ExtendedRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportDemo<ExtentReport> {
	ExtentReports extent;
	
	
	@BeforeTest
	public void config()
	{
	 //	ExtentReports  ,  ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentAventReporter reporter= new ExtentAventReporter(path);
		//reporter.config().setReportName("Web Automation Results");
		//reporter.config().setDocumentTitle("Test Results");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikhil Shshsne");
		
		
	}
	
	
	@Test
	public  void initialDemo()
	{
	  //ExtentTest test = extent.createTest("Initail Demo");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\nshah\\Downloads\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://www.qaclickacademy.com/");
	  System.out.println(driver.getTitle());
	  driver.close();
	  
	  
	  extent.flush();
	  
	  
	}
	

}
