package basictest;

import java.time.Duration;
import java.util.List;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class JUnitIntroduction {
	WebDriver driver;
	String baseUrl;

	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class executed...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class done...");
	}
*/
	@Before
	public void setUp() throws Exception {
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();
		//baseUrl="https://letskodeit.teachable.com";
		baseUrl="https://courses.letskodeit.com/practice";
		//baseUrl="https://google.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void HiddenExpediaTest() throws InterruptedException {
					
		driver.get(baseUrl);
	    WebElement el=driver.findElement((By.xpath("//input[@id='displayed-text']")));
	
		
		System.out.println("is Textbox displayed: " + el.isDisplayed());
		System.out.println("is Textbox Enabled: " + el.isEnabled());
	
		Thread.sleep(1000);
		
		

		System.out.println("Click on HideButton: ");
		driver.findElement((By.xpath("//input[@id='hide-textbox']"))).click();
		System.out.println("is Textbox displayed: " + el.isDisplayed());
		System.out.println("is Textbox Enabled: " + el.isEnabled());
		Thread.sleep(1000);
		

		System.out.println("Click on ShowButton: ");
		driver.findElement((By.xpath("//input[@id='show-textbox']"))).click();
		System.out.println("is Textbox displayed: " + el.isDisplayed());
		System.out.println("is Textbox Enabled: " + el.isEnabled());
		Thread.sleep(1000);
		
		

}
	
	//@Test
	public void HiddenKodeTest() throws InterruptedException {
					
		driver.get(baseUrl);
	    WebElement el=driver.findElement((By.xpath("//input[@id='displayed-text']")));
	
		
		System.out.println("is Textbox displayed: " + el.isDisplayed());
		System.out.println("is Textbox Enabled: " + el.isEnabled());
	
		Thread.sleep(1000);
		
		

		System.out.println("Click on HideButton: ");
		driver.findElement((By.xpath("//input[@id='hide-textbox']"))).click();
		System.out.println("is Textbox displayed: " + el.isDisplayed());
		System.out.println("is Textbox Enabled: " + el.isEnabled());
		Thread.sleep(1000);
		

		System.out.println("Click on ShowButton: ");
		driver.findElement((By.xpath("//input[@id='show-textbox']"))).click();
		System.out.println("is Textbox displayed: " + el.isDisplayed());
		System.out.println("is Textbox Enabled: " + el.isEnabled());
		Thread.sleep(1000);
		
		

}
	
	//@Test
	public void MultipleOptionsTest() throws InterruptedException {
					
		driver.get(baseUrl);
	    WebElement el=driver.findElement((By.xpath("//select[@id='multiple-select-example']")));
	  Select sl= new Select(el);

		System.out.println("Size of select elements: " + el.getSize());
		System.out.println("Size of options elements: " + sl.getOptions().size());
		
		System.out.println("Select Orange by index: ");
		sl.selectByIndex(1);
		Thread.sleep(1000);
		
		

		System.out.println("Select Peach by value: ");
		sl.selectByValue("peach");
		Thread.sleep(1000);
		

		System.out.println("Select Apple by visibletext: ");
		sl.selectByVisibleText("Apple");
		Thread.sleep(1000);
		
		System.out.println("DeSelect Orange by index: ");
		sl.deselectByIndex(1);
		Thread.sleep(1000);
		
		for (int i=0; i<sl.getAllSelectedOptions().size(); i++) {
			System.out.println(sl.getAllSelectedOptions().get(i).getText());
				
		}

}

	
	//@Test
		public void OptionsTest() throws InterruptedException {
						
			driver.get(baseUrl);
		    WebElement el=driver.findElement((By.xpath("//*[@id='carselect']")));
		  Select sl= new Select(el);

			System.out.println("Size of select elements: " + el.getSize());
			System.out.println("Size of options elements: " + sl.getOptions().size());
			
			System.out.println("Select Honda by index: ");
			sl.selectByIndex(2);
			Thread.sleep(1000);
			

			System.out.println("Select Benz by value: ");
			sl.selectByValue("benz");
			Thread.sleep(1000);
			

			System.out.println("Select BMW by visibletext: ");
			sl.selectByVisibleText("BMW");
			Thread.sleep(1000);
			
			for (int i=0; i<sl.getOptions().size(); i++) {
				System.out.println(sl.getOptions().get(i).getText());
					
			}

	}
	
	//@Test
	public void ListOfElementTest() {
					
		driver.get(baseUrl);
	    List<WebElement> el=driver.findElements((By.xpath("//*[@name='cars' or @type='radio']")));

		for (int i=0; i<el.size(); i++) {
			if (!el.get(i).isSelected()) {
				el.get(i).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}

}

	
	//@Test
		public void GoogleTest() {
						
			driver.get(baseUrl);
			WebElement e1=driver.findElement(By.xpath("//input[@aria-label='Search']"));
			if (!e1.isEnabled())
				e1.sendKeys(" search test....");
		
	
}

	//@Test
	public void test2() {
		//fail("Test1");
		System.out.println("Test1 executed...");
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Clicked on login link...");
		driver.findElement(By.id("email")).sendKeys("abctest");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.id("password")).sendKeys("114555t");

		driver.findElement(By.id("email")).clear();
		}
	
	
	//@Test
	public void test1() throws InterruptedException {
		//fail("Test1");
		
		driver.get(baseUrl);
		String title=driver.getTitle();
		System.out.println("Web Tiltle: " + title);
		String currentUrl=driver.getCurrentUrl();
		
		System.out.println("Web Current URL is: " + currentUrl);
		
		String loginUrl="https://sso.teachable.com/secure/42299/identity/login/password";
		driver.navigate().to(loginUrl);
 currentUrl=driver.getCurrentUrl();
		
		System.out.println("Web Current URL navigate is: " + currentUrl);
		Thread.sleep(1000);
		driver.navigate().back();
 currentUrl=driver.getCurrentUrl();
		
		System.out.println("Web Current URL navigate back is: " + currentUrl);
		Thread.sleep(1000);
		driver.navigate().forward();
 currentUrl=driver.getCurrentUrl();
		
		System.out.println("Web Current URL navigate forward is: " + currentUrl);
		
		System.out.println("refresh url: " );
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		String pagesource=driver.getPageSource();
		System.out.println("pagesource: \n" +pagesource);
		}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("After method done...");
		Thread.sleep(5000);
		driver.quit();
		
	}


}
