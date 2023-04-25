package facebook;

import org.testng.annotations.Test;

import dataprovider.DataProviders;
import pages.FaceBookLoginPageFactory;
import pages.LetsKodeItPageFactory;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class LoginTest_DataProvider {
	
	private WebDriver driver;
	private String baseUrl;
	LetsKodeItPageFactory lkLoginPage;
	
 
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("Before class start...");
	 
	  //driver =new FirefoxDriver();
	  
	  ChromeOptions opt = new ChromeOptions();		
	  opt.addArguments("--remote-allow-origins=*");	  	
	  driver= new ChromeDriver(opt);

	  lkLoginPage = new LetsKodeItPageFactory(driver);
	  
	  baseUrl="https://www.letskodeit.com/login";
	  
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	  
	  System.out.println("Before class end...");
	  
  }
  
 // @Test (dataProvider="loginData", dataProviderClass=DataProviders.class)
  @Test (dataProvider="loginDataFromExcel", dataProviderClass=DataProviders.class)
  public void testLogin(String userName, String email, String password) throws InterruptedException {
	  System.out.println("Before Test ...");
	  lkLoginPage.clickSigninLink();
	  lkLoginPage.setEmail(email);
	  lkLoginPage.setPassword(password);
	  Thread.sleep(1000);
	  lkLoginPage.clickLoginBtn();
	  System.out.println("User name failed login: "+ userName);
	  System.out.println("End Test ...");
			
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
	  System.out.println("After class End...");
  }

}
