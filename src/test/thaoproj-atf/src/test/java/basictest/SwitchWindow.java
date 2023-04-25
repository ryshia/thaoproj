package basictest;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchWindow {


	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();	
		//baseUrl="https://courses.letskodeit.com/practice";
		//baseUrl="https://jqueryui.com/droppable/";
		baseUrl="https://jqueryui.com/slider/";
		js=(JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
	}
	
	@Test
	public void Slide() throws InterruptedException {
		
		driver.switchTo().frame(0);
		
		 Thread.sleep(2000);
		
		WebElement from= driver.findElement(By.xpath("//div[@id='slider']//span"));
		
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(from, 200, 0).perform();
		Thread.sleep(2000);
		
		
		
	}	

	//@Test
	public void DropDrag() throws InterruptedException {
		
		driver.switchTo().frame(0);
		
		 Thread.sleep(2000);
		
		WebElement from= driver.findElement(By.id("draggable"));
		WebElement to=driver.findElement(By.id("droppable"));
		
		Actions act=new Actions(driver);
		//act.dragAndDrop(from, to).build().perform();
		act.clickAndHold(from).moveToElement(to).release().build().perform();
		Thread.sleep(2000);
		
		
		
	}	
	
	//@Test
	public void mouseHover() throws InterruptedException {
		
		js.executeScript("window.scrollBy(0,300);");
		
		 Thread.sleep(2000);
		
		WebElement mh= driver.findElement(By.id("mousehover"));
		 //mh.click();
		Actions act=new Actions(driver);
		act.moveToElement(mh).perform();
		 Thread.sleep(2000);
		
		 WebElement top=driver.findElement(By.xpath("//div//a[text()='Top']"));
		 //top.click();
		 act.moveToElement(top).click().perform();
		 
		 Thread.sleep(2000);
		
		
		
	}	
	
	//@Test
	public void alert() throws InterruptedException {
		
		 driver.findElement(By.id("name")).sendKeys("test successfull");		 
		 driver.findElement(By.id("alertbtn")).click();
		 Thread.sleep(2000);
		 Alert al =driver.switchTo().alert();
		 al.accept();
		
	}	
	
	//@Test
	public void confirm() throws InterruptedException {
		
		 driver.findElement(By.id("name")).sendKeys("test successfull");		 
		 driver.findElement(By.id("confirmbtn")).click();
		 Thread.sleep(2000);
		 Alert al =driver.switchTo().alert();
		 //al.accept();
		 al.dismiss();
		
		
	}	
	
	//@Test
	public void switch_iframe() throws InterruptedException {
		
		 //driver.switchTo().frame("courses-iframe");
		 //driver.switchTo().frame("iframe-name");
		driver.switchTo().frame(0);
	     driver.findElement(By.xpath("//input[@id='search']")).sendKeys("abc test iframe");
		 Thread.sleep(2000);
		 
		 driver.switchTo().defaultContent();
		 driver.findElement(By.id("name")).sendKeys("test successfull");
		 Thread.sleep(2000);
		
			
	}	
	
	//@Test
		public void switch_window() throws InterruptedException {
			
			 String parentHandle=driver.getWindowHandle();
			 System.out.println("Parent window: " + parentHandle);
			 driver.findElement(By.id("openwindow")).click();
			 
			 Set<String> handles =driver.getWindowHandles();
			 
			 for (String hl: handles) {
			   System.out.println(hl);
			   
			   if (!hl.equals(parentHandle)) {	
				   driver.switchTo().window(hl);
				   Thread.sleep(10000);
				   WebElement s= driver.findElement(By.xpath("//input[@id='search']"));
				   System.out.println("Search textbox displayed: " +s.isDisplayed());
				   
				   System.out.println("Search textbox enabled: " +s.isEnabled());
				   //s.click();
				   s.sendKeys("dfadgds");
				   Thread.sleep(2000);
				   driver.close();
				   break;
			   }			   
			  
			 }
			 
			 driver.switchTo().window(parentHandle);
			   Thread.sleep(2000);
			   driver.findElement(By.id("name")).sendKeys("test successfull");
			   Thread.sleep(2000);
			
				
		}	

		@After
		public void tearDown() throws Exception {
			System.out.println("After method done...");
			Thread.sleep(5000);
			driver.quit();
			
		}

}
