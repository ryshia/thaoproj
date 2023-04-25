package cucumber.stepdefinition.withjunit;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FaceBookLoginPageFactory;

public class LoginTestSteps {
	
	private WebDriver driver;
	private String baseUrl;
	FaceBookLoginPageFactory fbLoginPage;
	
	//@before hook gets executed well before any other test scenario  
    @Before
    public void setUp() {
 
    	 driver =new FirefoxDriver();
		
		  fbLoginPage = new FaceBookLoginPageFactory(driver);
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
    }

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		  
		  baseUrl="https://www.facebook.com/";
		  driver.get(baseUrl);
	
	}
	@When("User enters a valid username and password is wrong")
	public void user_enters_a_valid_username_and_password_is_wrong() {
		 
		fbLoginPage.setEmail("abc@gmail.com");
		fbLoginPage.setPassword("abcdefgh");
	
	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		 fbLoginPage.clickLoginBtn();
	   
	}
	@Then("he will see the message regarding password incorrect {string}")
	public void he_will_see_the_message_regarding_password_incorrect(String string) {
	   
		System.out.println("Login failed:  " + fbLoginPage.getIncorrectPasswordMessage());
		assertEquals(fbLoginPage.getIncorrectPasswordMessage().equalsIgnoreCase("The password you’ve entered is incorrect. Forgot Password?"), true);		
		
	}
	
	@When("User enters an empty username and  password")
	public void user_enters_an_empty_username_and_password() {
		fbLoginPage.setEmail("");
		fbLoginPage.setPassword("abcdefgh");
	}
	
	@Then("he will see the message regarding email invalid {string}")
	public void he_will_see_the_message_regarding_email_invalid(String string) {
		System.out.println("The email or mobile number you entered isn’t connected to an account. Find your account and log in.");
	}
	
	//@after hook gets executed after executing the scenario.
	 @After
	 public void teardown() throws InterruptedException {
		Thread.sleep(2000);
	    driver.quit();
	 }

}
