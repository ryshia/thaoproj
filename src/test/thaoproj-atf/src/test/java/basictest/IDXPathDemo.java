package basictest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IDXPathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sign in fucntion
		//signIn("https://learn.letskodeit.com");
		
		//findByName fucntion
		//findByName("https://courses.letskodeit.com/practice");
		
		//find element by linktext fucntion
		findByLinkText("https://letskodeit.teachable.com");
		
	}
	
	public static void signIn(String baseUrl) {
		WebDriver driver =new ChromeDriver();		
		setDriverInitialProperties(driver);
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	}
	
	public static void findByName(String baseUrl) {
		WebDriver driver =new ChromeDriver();		
		setDriverInitialProperties(driver);
		driver.get(baseUrl);		
		driver.findElement(By.name("enter-name")).sendKeys("Test automation");
	}
	
	public static void findByLinkText(String baseUrl) {
		WebDriver driver =new FirefoxDriver();		
		setDriverInitialProperties(driver);
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(baseUrl);
		driver.findElement(By.partialLinkText("Prac")).click();
	
	}
	
	private static void setDriverInitialProperties(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
}
