package stepdefs;
 
import pageobjects.ServiceHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Created by Yash on 11/23/2018.
 */
public class StepDefinition extends ServiceHooks{
	StepDefinition(){
		super();
	}
	
    
	@Given("^I am on the HIA login page on URL$")
    public void i_am_on_the_page_on_URL() throws Throwable {
		System.out.println("Login to Google");
        //throw new PendingException();
    }
 
    
	@When("^I fill in Username with username and password$")
    public void i_fill_in_with() throws Throwable {
		System.out.println("Login to Google2");
        //throw new PendingException();
    }
 
    @Then("^I click on the Log In button$")
    public void i_click_on_the_button() throws Throwable {
    	System.out.println("Login to Google3");
        //throw new PendingException();
    }
}
