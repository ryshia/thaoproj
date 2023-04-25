package extentreport;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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

public class ExtentReport1 {
	
	private WebDriver driver;
	private String baseUrl;
	FaceBookLoginPageFactory fbLoginPage;
	ExtentReports report;
	ExtentTest test;
 
  @BeforeClass
  public void beforeClass() {

	 
	  report=utils.ExtentReportFactory.getInstance();
	  test =report.startTest("Test case 1: Login to Facebook with invalid credentials");
	 
	  driver =new FirefoxDriver();
	  test.log(LogStatus.INFO, "Browser started");
	  
	 // ChromeOptions opt = new ChromeOptions();		
	 // opt.addArguments("--remote-allow-origins=*");	  	
	 // driver= new ChromeDriver(opt);
		
	  System.out.println("Before class inprogress...");
	  fbLoginPage = new FaceBookLoginPageFactory(driver,test);
	 	  
	  driver.manage().window().maximize();
	  test.log(LogStatus.INFO, "Web page maximized");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  baseUrl="https://www.facebook.com/";

	  
  }
  
  @Test
  public void testLogin() {

	  driver.get(baseUrl);
	  
	  test.log(LogStatus.INFO, "Facebook login page opened");
	  fbLoginPage.logIn("abc@gmail.com", "abcd1234");
	  test.log(LogStatus.INFO, "Entered email, password and clicked on Login button.");
	 
	  
	  String msg=fbLoginPage.getIncorrectPasswordMessage();
	  
	   
	  //System.out.println("Login failed:  " + msg);
	 assertEquals(msg, "The password you?ve entered is incorrect. Forgot Password?");
	  //assertEquals(true, true);
	  test.log(LogStatus.PASS, "Message pass 1");
	  
			
  }
  
  @AfterMethod
  public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus()==ITestResult.FAILURE) {
	    String ssPath=utils.Screenshot.takeScreenShotExtent(driver, result.getName());
	    String img=test.addScreenCapture(ssPath);
	    
	    test.log(LogStatus.FAIL, "Message failed 2",img);
	    
	  }
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("After class Begin...");

	  Thread.sleep(2000);
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }


}
