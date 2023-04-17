package facebook;

import org.testng.annotations.Test;

import pages.FaceBookLoginPageFactory;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	
	private WebDriver driver;
	private String baseUrl;
	FaceBookLoginPageFactory fbLoginPage;
	
 
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("Before class start...");
	 
	  driver =new FirefoxDriver();
	  
	 // ChromeOptions opt = new ChromeOptions();		
	 // opt.addArguments("--remote-allow-origins=*");	  	
	 // driver= new ChromeDriver(opt);
		
	  System.out.println("Before class inprogress...");
	  fbLoginPage = new FaceBookLoginPageFactory(driver);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  baseUrl="https://www.facebook.com/";
	  
	  System.out.println("Before class end...");
	  
  }
  
  @Test
  public void TestLogin() {
	  System.out.println("Before Test ...");
	  driver.get(baseUrl);
	  fbLoginPage.setEmail("abc@gmail.com");
	  fbLoginPage.setPassword("abcdefgh");
	  fbLoginPage.clickLoginBtn();
	  
	  String test=fbLoginPage.getIncorrectPasswordMessage();
	  
	  System.out.println("Login failed:  " + test);
			
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("After class Begin...");
	  Thread.sleep(2000);
	  driver.quit();
  }

}
