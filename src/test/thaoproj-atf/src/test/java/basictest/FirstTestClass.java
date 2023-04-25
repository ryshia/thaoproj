package basictest;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		/* *** Firefox ****
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\ryshi\\Selenium\\libs\\drivers\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		String baseUrl= "https://learn.letskodeit.com";
		driver.get(baseUrl);
		*/
		
		/* *** Chrome ****
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ryshi\\Selenium\\libs\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		String baseUrl= "https://learn.letskodeit.com";
		driver.get(baseUrl);
		*/
		
		/* *** IE doesn't work ***
		//System.setProperty("webdriver.ie.driver","C:\\Users\\ryshi\\Selenium\\libs\\drivers\\IEDriverServer.exe");
		WebDriver driver;
		String baseURL = "https://courses.letskodeit.com/practice";		
		InternetExplorerOptions opts =  new InternetExplorerOptions();	
		opts.ignoreZoomSettings();
		driver = new InternetExplorerDriver(opts);
		driver.get(baseURL);
		*/
		
		/* *** Edge ***	
		//System.setProperty("webdriver.edge.driver","C:\\Users\\ryshi\\Selenium\\libs\\drivers\\msedgedriver.exe");
		WebDriver driver =new EdgeDriver();
		String baseUrl= "https://learn.letskodeit.com";
		driver.get(baseUrl);
	*/
		
		
		
		
	}

}
