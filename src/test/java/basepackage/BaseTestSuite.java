package basepackage;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.LoginPageFactory_WithGrid;

public class BaseTestSuite {
	
	protected static WebDriver driver;
	protected LoginPageFactory_WithGrid loginPage;

	@Parameters({"browser","url"})
	@BeforeClass (alwaysRun=true)
	public void beforeClassBase(String browser, String url) throws MalformedURLException {
		System.out.println("\nBaseTestSuite -> before class\n");
		
		driver=getDriverInstance(browser, url);
		  
		  loginPage = PageFactory.initElements(driver, LoginPageFactory_WithGrid.class);
		  
		  System.out.println("Before base class end...");
	}
	
	public static WebDriver getDriverInstance(String browser, String url) throws MalformedURLException {
		String hubUrl="http://192.168.0.6:4444";
		
		WebDriver wd=null;
		  
		if (browser.equalsIgnoreCase("chrome"))
		{
		  ChromeOptions opt = new ChromeOptions();		
		  opt.addArguments("--remote-allow-origins=*");
		  wd= new RemoteWebDriver(new URL(hubUrl), opt);
		} 
		
		if (browser.equalsIgnoreCase("MicrosoftEdge"))
		{
		  EdgeOptions opt=new EdgeOptions();
		 // opt.setCapability("useAutomationExtension", false);
		  wd= new RemoteWebDriver(new URL(hubUrl), opt);
		}
		
		if (browser.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions opt= new FirefoxOptions();
			wd= new RemoteWebDriver(new URL(hubUrl), opt);
		}
		//wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		  
		wd.get(url);
		System.out.println("After loading facebook...");
		return wd;
	}

	@AfterClass
	public void afterClassBase() throws InterruptedException {
		System.out.println("\nBaseTestSuite -> after class\n");
		
		  Thread.sleep(3000);
		  driver.quit();
		  
		  System.out.println("After base class End...");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("\nBaseTestSuite -> before Test\n");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\nBaseTestSuite -> after Test\n");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nBaseTestSuite -> before suite\n");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nBaseTestSuite -> after suite\n");
	}
}