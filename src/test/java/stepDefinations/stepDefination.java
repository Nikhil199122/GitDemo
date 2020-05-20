package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.portalHomePage;
import Resources.base; 

@RunWith(Cucumber.class)
public class stepDefination extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
       
    	driver=initializeDriver();
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in $")
    public void user_enters_and_logs_in(String strArg1, String strArg2) throws Throwable {
        
    	LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys("strArg1");
		lp.getPassword().sendKeys("strArg2");
		lp.getLogin().click();
    }

    @Then("^Verify that user is successfully logged in $")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
       
    	portalHomePage p=new portalHomePage(driver);
    	Assert.assertTrue(p.getSearchBox().isDisplayed()) ;
    }

    @And("^Navigate to \"([^\"]*)\" Site $")
    public void navigate_to_site(String strArg1) throws Throwable {
        
    	driver.get(strArg1);
    }

    @And("^Click on Login link in home page to land on Secure sign in Page $")
    public void click_on_login_link_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
        
    	LandingPage l=new LandingPage(driver);
    	((WebElement) l.getLogin()).click(); // diver.findElement(By.css())
    }

}


