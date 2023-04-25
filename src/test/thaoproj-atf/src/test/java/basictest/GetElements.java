package basictest;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetElements {
	
	WebDriver driver;
	String baseUrl;
	GenericMethods gm ;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();
		//baseUrl="https://letskodeit.teachable.com";
		baseUrl="https://courses.letskodeit.com/practice";
		//baseUrl="https://google.com";
		gm=new GenericMethods(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	

	//@Test
	public void testIsElementPresent() {
		 driver.get(baseUrl);
		// List<WebElement> elist=gm.getElementList("//input[@type='text']", "xpath");
		 System.out.println("Element exist : " +gm.isElementPresent("//input[@type='text']", "xpath"));
		 
		 System.out.println("Element exist : " +gm.isElementPresent("//abc", "xpath"));
			
	}
	
	//@Test
	public void testGetElementList() {
		 driver.get(baseUrl);
		 List<WebElement> elist=gm.getElementList("//input[@type='text']", "xpath");
		 System.out.println("Element list size: " +elist.size());
			
	}
	
	//@Test
	public void testGetElement() {
		 driver.get(baseUrl);
		 WebElement el=gm.getElement("name", "id");
		el.sendKeys("abcddfg");;
			
	}
	
	//@Test
	public void test() {
		 driver.get(baseUrl);
		 WebElement el=driver.findElement((By.id("opentab")));
		 System.out.println("Get text for open button: " + el.getText());
		 el=driver.findElement(By.id("name"));
		 System.out.println("Get attribute for enter name textbox: " + el.getAttribute("placeholder"));
			
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method done...");
		Thread.sleep(3000);
		driver.quit();
		
	}

	

}
