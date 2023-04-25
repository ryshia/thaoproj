package basictest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
  WebDriver driver;
  public GenericMethods (WebDriver driver) {
	  this.driver=driver;
  }
  
  public WebElement getElement (String locator, String type) {
	  
	  type=type.toLowerCase();
	  if (type.equals("id")) {
		  System.out.println("Element found with " +type + ": " + locator );
		  return this.driver.findElement(By.id(locator));
	  }else if (type.equals("xpath")) {
		  System.out.println("Element found with " +type + ": " + locator );
		  return this.driver.findElement(By.xpath(locator));
	  }else  {
		  System.out.println("Either type or locator is not correct");
		  return null;
	  }
	  
  }
  
 public List<WebElement> getElementList (String locator, String type) {
	  
	  type=type.toLowerCase();
	  List<WebElement> elist= new ArrayList<WebElement>();
	  if (type.equals("id")) {		 
		  elist=this.driver.findElements(By.id(locator));
	  }else if (type.equals("xpath")) {		  
		  elist= this.driver.findElements(By.xpath(locator));
	  }else  {
		  System.out.println("Either type or locator is not correct");		  
	  }
	  
	  if (!elist.isEmpty()) {
		  System.out.println("Element found with " +type + ": " + locator );
	  }else {
		  System.out.println("Element NOT found with " +type + ": " + locator );
	  }
	  return elist;
	  
  }
 
 public Boolean isElementPresent (String locator, String type) {
	  
	  List <WebElement> list=this.getElementList(locator, type);
	  int size=list.size();
	  
	  return (size >0) ? true: false;
	  
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
