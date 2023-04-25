package performance;

import org.testng.annotations.Test;

import pages.SearchPageFactory;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class PerformanceTesting {
	long startTime;
	long endTime;
	long duration;
	double seconds;
	
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;

	@BeforeClass
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
		startTime = System.nanoTime();
		String selectedText="Mexico";
		driver.get(baseUrl);	
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(selectedText);
						
		endTime = System.nanoTime();
		duration = endTime - startTime;
		seconds = (double)duration / 1000000000.0;
		
		System.out.println("\nPage response time in second: " + seconds);
		
		//Note: We can save the response time for each method/action into excel sheet as well
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}