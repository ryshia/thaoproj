package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetsKodeItPageFactory {
	WebDriver driver;
	
	@FindBy (xpath="//a[normalize-space()='Sign In']")
	WebElement signIn;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="login-password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	public LetsKodeItPageFactory(WebDriver driver) {	
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	

	public void clickSigninLink() {
		signIn.click();		
	}
}
