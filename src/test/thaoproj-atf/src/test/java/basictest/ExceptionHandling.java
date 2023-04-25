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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionHandling {


	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();	
		//baseUrl="https://freecrm.com/";
		//baseUrl="https://courses.letskodeit.com/practice";
		//baseUrl= "https://www.southwest.com/";
		//baseUrl="https://www.expedia.com/";
		
		baseUrl="https://www.google.com/flights/";
		js=(JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(baseUrl);
	}
	
	@Test
	public void NotInteractableExceptionGoogleFlight() throws InterruptedException {
		
		String selectedText="Playa del Carmen, Mexico";
				
		driver.findElement(By.xpath("//div[@aria-placeholder='Where from?']//input[contains(@jslog,'track:click')]")).click();
		driver.findElement(By.xpath("//div[@aria-label='Enter your origin']//input")).sendKeys("DEL");
		
		
		WebElement ul=driver.findElement(By.xpath("//div[@aria-label='Enter your origin']//ul"));

		List<WebElement> li =ul.findElements(By.tagName("li"));
		
		int size=li.size();
		System.out.println("List suggestion size: " + size);
		
		for (WebElement el: li) {
			//System.out.println(el.getText());
			
			System.out.println(el.getAttribute("aria-label"));
			
		}
		
		for (WebElement el: li) 
		{
			if (el.getAttribute("aria-label").contains(selectedText)){
			System.out.println("tested ok");
				el.click();
				break;
			}
			
		}
		
		
	}

	
	//@Test
	public void NotInteractableExceptionExpedia() throws InterruptedException {
		
				
		driver.findElement(By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']")).click();
		driver.findElement(By.xpath("//button[@data-stid='location-field-leg1-origin-menu-trigger']")).click();
	    driver.findElement(By.xpath("//input[@id='location-field-leg1-origin']")).sendKeys("DEL");
	}

	//@Test
	public void NotInteractableExceptionTest() throws InterruptedException {
		
		driver.switchTo().frame(0);
		
		WebElement search=driver.findElement(By.xpath("//input[@id='search']"));
		
		search.sendKeys("abcd");
		driver.switchTo().defaultContent();
		
	}
	
	//@Test
	public void StaleException2() throws InterruptedException {
		
		//String searchText="LAX";
		String selectedText="Burbank, CA - BUR";
		WebElement depart=driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode"));
		depart.sendKeys("LAX");
		
		System.out.println("Web source: " + depart.getAttribute("innerText"));
		
		WebElement ul=driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode--menu"));
		
		List<WebElement> li =ul.findElements(By.tagName("li"));
		
		int size=li.size();
		System.out.println("List suggestion size: " + size);
		
		for (WebElement el: li) {
			System.out.println(el.getText());
			
		}
		
		for (WebElement el: li) {
			if (el.getText().equals(selectedText)){				
				el.click();
				//System.out.println(el.getText());
				break;
			}
			
		}
		
	}
	
	//@Test
	public void StaleException1() throws InterruptedException {
		
		
		WebElement bmw=driver.findElement(By.id("bmwcheck"));
		
		//driver.get(baseUrl);
		bmw.click();
		
	}
	
	//@Test
	public void clickableException() throws InterruptedException {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		//WebElement login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Login']")));
		//login.click();
		
		//Boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		//if (invisible){
		//	driver.findElement(By.xpath("//a[text()='Login']")).click();
		//}
		
		WebElement login=driver.findElement(By.xpath("//a[text()='Login']"));
		js.executeScript("arguments[0].click();", login);
		
		
		
		Thread.sleep(2000);	
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("After method done...");
		Thread.sleep(10000);
		driver.quit();
		
	}

}
