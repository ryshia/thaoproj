package basictest;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyEvent {


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
		driver.get(baseUrl);
	}
	
	//@Test
	public void actionCombinedKey() throws InterruptedException {
		
		Actions act= new Actions(driver);
		//act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		//act.keyDown(Keys.CONTROL).keyDown("a").keyUp("a").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(2000);	
	}
	
	//@Test
	public void sendCombinedKey() throws InterruptedException {
		
		//driver.findElement(By.xpath("//a[@href='/login']")).sendKeys(Keys.CONTROL+"a");
		driver.findElement(By.xpath("//a[@href='/login']")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
			Thread.sleep(2000);	
	}	
	
	@Test
	public void sendKey() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
			Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys("my name");
	//driver.findElement(By.id("password")).sendKeys("ffddfd");
	Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys(Keys.TAB);
	//driver.findElement(By.xpath("//input[@value='Login']")).sendKeys(Keys.ENTER);
		
		
		
	}	

	@After
	public void tearDown() throws Exception {
		System.out.println("After method done...");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
