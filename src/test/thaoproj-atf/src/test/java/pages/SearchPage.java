package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	public static WebElement element=null;
	
	public static WebElement alertButton(WebDriver driver)
	{
		element = driver.findElement(By.id("alertbtn"));
		return element;
	}
	
	public static WebElement nameTextbox(WebDriver driver)
	{
		element = driver.findElement(By.id("name"));
		return element;
	}
	
	public static void clickAlert(WebDriver driver)
	{
		alertButton(driver).click();
	}
	public static void enterName(WebDriver driver, String name)
	{
		nameTextbox(driver).sendKeys(name);
	}

}
