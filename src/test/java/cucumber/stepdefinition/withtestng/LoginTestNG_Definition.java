package cucumber.stepdefinition.withtestng;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FaceBookLoginPageFactory;

public class LoginTestNG_Definition {
	
	private WebDriver driver;
	private String baseUrl;
	FaceBookLoginPageFactory fbLoginPage;
	  
    @Before
    public void setUp() {
 
    	 driver =new ChromeDriver();
		
		  fbLoginPage = new FaceBookLoginPageFactory(driver);
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
    }

	@Given("User is on Facebook homepage {string}")
	public void user_is_on_facebook_homepage(String string) {
		 baseUrl="https://www.facebook.com/";
		 driver.get(baseUrl);
	}
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String email, String password) {
		fbLoginPage.setEmail(email);
		fbLoginPage.setPassword(password);
	}
	
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		 fbLoginPage.clickLoginBtn();
	   
	}
	
	@Then("User should be able to see error message {string}")
	public void user_should_be_able_to_see_error_message(String errorMsg) {	
		assertEquals(fbLoginPage.getIncorrectPasswordMessage().equalsIgnoreCase(errorMsg), true);		

	}
	
	@Then("User should be able to login sucessfully and new page open")
	public void user_should_be_able_to_login_sucessfully_and_new_page_open() {
		System.out.println("Login successfully.");

	}
	
	 @After
	 public void teardown() throws InterruptedException {
		Thread.sleep(2000);
	    driver.quit();
	 }
}
