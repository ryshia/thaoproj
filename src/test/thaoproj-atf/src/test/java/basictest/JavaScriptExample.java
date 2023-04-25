package basictest;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExample {


	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();	
		baseUrl="https://courses.letskodeit.com/practice";
		
		js=(JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void jsScroll() throws InterruptedException {
		// driver.get(baseUrl);
		 js.executeScript("window.location='https://courses.letskodeit.com/practice';");	
		 Thread.sleep(3000);
		 
		 //Scroll Down		 
		 js.executeScript("window.scrollBy(0,1900);");
		 Thread.sleep(3000);
		 
		 //Scroll Down		 
		 js.executeScript("window.scrollBy(0,-1900);");
		 Thread.sleep(3000);
		 
		//Scroll Element into View
		 WebElement ms=driver.findElement(By.id("mousehover"));
		 js.executeScript("arguments[0].scrollIntoView(true);", ms);
		 
		 //or:
		// js.executeScript("return document.getElementById('mousehover').scrollIntoView(true);");
		 
		 Thread.sleep(3000);
		
		 //scroll up a bit
		 js.executeScript("window.scrollBy(0,-190);");
		 Thread.sleep(3000);
		 
		
		 WebElement tbx=driver.findElement(By.id("bmwcheck"));
		 js.executeScript("arguments[0].scrollIntoView(true);", tbx);
		 
		 js.executeScript("arguments[0].click();", tbx);
		 
		 Thread.sleep(3000);
		 
		// js.executeScript("document.getElementById('bmwcheck').scrollIntoView(true);");
		// js.executeScript("document.getElementById('bmwcheck').click();");
		 
	}

	//@Test
	public void jsfunction() throws InterruptedException {
		// driver.get(baseUrl);
		 js.executeScript("window.location='https://courses.letskodeit.com/practice';");	
		 Thread.sleep(3000);
		 WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
		 textBox.sendKeys("dfasdfas");
		 
		 long height=(long)js.executeScript("return window.innerHeight;");
		 long width=(long)js.executeScript("return window.innerWidth;");
		 
		 System.out.println("Window height: " + height);
		 System.out.println("Window width: " + width);
		
			
	}	

	@After
	public void tearDown() throws Exception {
		System.out.println("After method done...");
		Thread.sleep(3000);
		driver.quit();
		
	}

	
}
