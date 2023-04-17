package facebook;

import org.testng.annotations.Test;

import pages.FaceBookLoginPageFactory;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class SeleniumGrid_LoginTest {
	
	private WebDriver driver;
	private String baseUrl;
	private String hubUrl;
	private FaceBookLoginPageFactory fbLoginPage;
	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  

	  hubUrl="http://192.168.0.6:4444";
	  
	
	  //ChromeOptions opt = new ChromeOptions();		
	  //opt.addArguments("--remote-allow-origins=*");
	  
	  EdgeOptions opt=new EdgeOptions();
	  opt.setCapability("useAutomationExtension", false);
	  
	  //FirefoxOptions opt= new FirefoxOptions();
	
	  System.out.println("Before class start...");
	  
	 driver= new RemoteWebDriver(new URL(hubUrl), opt);
		
	  System.out.println("Before class inprogress...");
	  fbLoginPage = new FaceBookLoginPageFactory(driver);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  baseUrl="https://www.facebook.com/";
	  
	  System.out.println("Before class end...");
	  
  }
  
  @Test
  public void TestLogin() throws InterruptedException {
	  System.out.println("Before Test ...");
	  driver.get(baseUrl);
	  fbLoginPage.setEmail("abc@gmail.com");
	  fbLoginPage.setPassword("abcdefgh");
	  Thread.sleep(2000);
	  fbLoginPage.clickLoginBtn();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("After class Begin...");
	  Thread.sleep(5000);
	  driver.quit();
	  
	  System.out.println("After class End...");
  }

}
