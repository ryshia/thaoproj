package basictest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	WebDriver driver;
	
	
	public WaitTypes(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement waitForElement (By locator, int timeout) {
		WebElement element= null;
		System.out.println("Waiting for max timeout: " + timeout + " seconds for element to be available");
		try {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Element is visible ");
		}catch(Exception e) {
			System.out.println("Element is not visible yet");
		}
		return element;
	}
	
	public void clickWhenReady (By locator, int timeout) {
	
		System.out.println("Waiting for max timeout: " + timeout + " seconds for element to be clickable");
		try {
			WebElement element=null;
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));
		element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		System.out.println("Element clicked");
		}catch(Exception e) {
			System.out.println("Element is not visible yet");
		}
	
	}
}
