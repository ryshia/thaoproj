package performance;

import static org.junit.Assert.*;

import java.time.Duration;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PerformanceTestingStopWatch {

	long startTime;
	long endTime;
	long duration;
	double seconds;
	
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	StopWatch watch = new StopWatch();

	@Before
	public void beforeClass() throws Exception {
		
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();	
				
		baseUrl="https://www.google.com/";
		js=(JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		 
	}

	@Test
	public void Test1() throws Exception {
		watch.start();
		String selectedText="Mexico";
		driver.get(baseUrl);	
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(selectedText);
						
		double seconds = (double)watch.getTime() / 1000.0;
		watch.reset();
		
		System.out.println("\nPage response time in second: " + seconds);
		
		//Note: We can save the response time for each method/action into excel sheet as well
	}
	
	@After
	public void afterClass() {
		driver.quit();
	}

}
