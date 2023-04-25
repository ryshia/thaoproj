package basictest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new FirefoxDriver();
		String baseUrl= "https://learn.letskodeit.com";
		driver.manage().window().maximize();
		//Implicitwait wait for all the elements
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.id("email")).sendKeys("testa a");
		
		//Explicit wait
		//WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("dfdsgd");;
		
		//Explicit wait customize
		
		GenericMethods wt = new GenericMethods(driver);
		WebElement el=wt.waitForElement(By.id("email"), 3);
		el.sendKeys("dfdsfsd abddfh");
		
		wt.clickWhenReady(By.name("commit"), 3);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
