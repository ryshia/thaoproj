package extentreport;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.FaceBookLoginPageFactory;

public class ExtentReport2 {
	
	private WebDriver driver;
	private String baseUrl;
	FaceBookLoginPageFactory fbLoginPage;
	com.relevantcodes.extentreports.ExtentReports report;
	ExtentTest test;
	
	@BeforeMethod
	  public void beforeClass() {
		  
		 
		  report=utils.ExtentReportFactory.getInstance();
		  test =report.startTest("Test case 2: with extent report");
		 
		  driver =new FirefoxDriver();
		  test.log(LogStatus.INFO, "Browser  started");
			
		
		  fbLoginPage = new FaceBookLoginPageFactory(driver);
		 	  
		  driver.manage().window().maximize();
		  test.log(LogStatus.INFO, "Web page  maximized");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  baseUrl="https://www.facebook.com/";

		  
	  }
	  
	  @Test
	  public void testLogin1() {
	
		  driver.get(baseUrl);
		  
		  test.log(LogStatus.INFO, "Facebook login page opened 2");
		 
		  test.log(LogStatus.INFO, "Just stay here at login page 2");
		  
		   assertEquals(true, false);
		  test.log(LogStatus.PASS, "Message pass try abc 2");
		  
				
	  }
	 
	  
	  @AfterMethod
	  public void tearDown(ITestResult result) throws IOException, InterruptedException {
		  if (result.getStatus()==ITestResult.FAILURE) {
		    String ssPath=utils.Screenshot.takeScreenShotExtent(driver, result.getName());
		    String imgPath=test.addScreenCapture(ssPath);
		    
		    test.log(LogStatus.FAIL, "Message failed try abc",imgPath);
		    
		  }
		  Thread.sleep(1000);
		  driver.quit();
		  report.endTest(test);
		  report.flush();
		
	  }

	 
}
