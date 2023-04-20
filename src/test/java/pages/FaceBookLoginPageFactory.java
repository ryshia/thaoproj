package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FaceBookLoginPageFactory {
	
	WebDriver driver;
	ExtentTest test;
	
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
	
	@FindBy(xpath="//div[@class='_9ay7']")
	WebElement incorrectPassword;

	public FaceBookLoginPageFactory(WebDriver driver) {	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public FaceBookLoginPageFactory(WebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public void setEmail(String mail) {
		email.sendKeys(mail);
		//test.log(LogStatus.INFO, "Entered email");
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
		//test.log(LogStatus.INFO, "Entered password");
	}

	public void clickLoginBtn() {
		loginBtn.click();
		//test.log(LogStatus.INFO, "Clicked on login button");
	}

	public String getIncorrectPasswordMessage() {
		return incorrectPassword.getText();
	}
	
	public void logIn(String email, String password) {
		setEmail(email);
		 
		setPassword(password);
		clickLoginBtn();
	}
	
}
