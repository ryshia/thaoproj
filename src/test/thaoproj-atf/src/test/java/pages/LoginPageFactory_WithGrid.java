package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory_WithGrid {
	
	WebDriver driver;
	
	@CacheLookup
	//Marker annotation to be applied to WebElements to indicate that it rarely changes (that is, that the same instance in the DOM will always be used)
	@FindBy(id="email")
	WebElement email;
	
	@CacheLookup	
	@FindBy(id="pass")
	WebElement password;
	
	//FindBys=ALL conditions matched
	//FindAll=OR
	@FindAll({
		@FindBy(name="login"),
		@FindBy(xpath="//div/button[@data-testid='royal_login_button']")	
	})
	WebElement loginBtn;

	public LoginPageFactory_WithGrid(WebDriver driver) {	
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	public void setEmail(String mail) {
		email.sendKeys(mail);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	
}
