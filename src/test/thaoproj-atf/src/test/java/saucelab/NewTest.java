package saucelab;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.FaceBookLoginPageFactory;

public class NewTest {
	private WebDriver driver;
	private String baseUrl;
	private FaceBookLoginPageFactory fbLoginPage;
	
  @Test
  public void f() throws MalformedURLException {
	  ChromeOptions browserOptions = new ChromeOptions();
	  browserOptions.setPlatformName("Windows 11");
	  browserOptions.setBrowserVersion("latest");
	  Map<String, Object> sauceOptions = new HashMap<>();
	  sauceOptions.put("build", "selenium-build-FNXOM");
	  //sauceOptions.setCapability("name", "oauth-ryshia.v-f52c4");
	  browserOptions.setCapability("sauce:options", sauceOptions);
	  URL url = new URL("https://oauth-ryshia.v-f52c4:c9e7d73e-e658-4c4a-9818-1ee0177834f7@ondemand.us-west-1.saucelabs.com:443/wd/hub");
	  RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
	  
	  fbLoginPage = new FaceBookLoginPageFactory(driver);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  baseUrl="https://www.facebook.com/";
	  driver.get(baseUrl);
	  fbLoginPage.setEmail("abc@gmail.com");
	  fbLoginPage.setPassword("abcdefgh");	
	  fbLoginPage.clickLoginBtn();
  }
}
