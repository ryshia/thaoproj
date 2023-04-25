package basictest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findByClass("https://courses.letskodeit.com/practice", new FirefoxDriver());
		//findByClassFB("https://facebook.com", new ChromeDriver());
		
		findByTagName("https://demostore.x-cart.com/", new ChromeDriver());
		
	}
	
	public static void findByTagName(String baseUrl,WebDriver driver) {
		//driver =new ChromeDriver();		
		setDriverInitialProperties(driver);
		driver.get(baseUrl);		
		driver.findElement(By.tagName("a")).click();
	}
	
	public static void findByClass(String baseUrl,WebDriver driver) {
		//driver =new ChromeDriver();		
		setDriverInitialProperties(driver);
		driver.get(baseUrl);		
		driver.findElement(By.className("btn-style")).click();
	}
	
	public static void findByClassFB(String baseUrl,WebDriver driver) {
		//driver =new ChromeDriver();		
		setDriverInitialProperties(driver);
		driver.get(baseUrl);		
		driver.findElement(By.className("inputtext")).sendKeys("abc test");
		driver.findElement(By.className("_6ltg")).click();
	}
	
	
	private static void setDriverInitialProperties(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
