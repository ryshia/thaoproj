package facebook;

import org.testng.annotations.Test;

import dataprovider.DataProviders;
import pages.FaceBookLoginPageFactory;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

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
	  	  
	  System.out.println("Before class end...");
	  
  }
  
  @Test
  public void testLogin() throws InterruptedException {
	  System.out.println("Before Test ...");
	  baseUrl="https://www.facebook.com/";
	  driver.get(baseUrl);
	  fbLoginPage.setEmail("abc@gmail.com");
	  fbLoginPage.setPassword("abcd1234");
	  Thread.sleep(1000);
	  fbLoginPage.clickLoginBtn();
	  
	  //String msg=fbLoginPage.getIncorrectPasswordMessage();
	  
	  //System.out.println("Login failed for user:  " + userName);
	//  assertEquals(msg, "Invalid Password");
			
  }
  
  @AfterMethod
  public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus()==ITestResult.FAILURE) {
	   utils.Screenshot.takeScreenShot(driver, result.getName());
	  }
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("After class Begin...");
	  Thread.sleep(2000);
	  driver.quit();
  }

}
