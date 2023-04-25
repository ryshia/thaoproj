package basictest;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pages.SearchPage;
import pages.SearchPageFactory;

public class FindLinks {
	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Before method executed...");
		driver= new FirefoxDriver();	
		
		baseUrl="https://expedia.com";	
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
	}
	
	@Test
	public void TestFindLinks() throws InterruptedException {

		List<WebElement> links=clickableLinks(driver);
		
		for (WebElement e: links) {
			String href=e.getAttribute("href");
			try {
				System.out.println("HREF: " + href + " --status: " + linkStatus(new URL(href)));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		}
				
		
	}
	
	List<WebElement> clickableLinks(WebDriver driver){
		
		List<WebElement> links= new ArrayList<WebElement>();
		List<WebElement> elements= driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement e: elements) {
			if (e.getAttribute("href")!=null) {
				links.add(e);
			}
				
		}
		return links;
		
	}
	
	String linkStatus (URL url) {
		
		String message="";
		try {
			
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.connect();
			message=conn.getResponseMessage();			
			conn.disconnect();
			return message;
			
		}catch (Exception e) {
			e.getMessage();
			
		}	
		
		return message;
		
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("After method done...");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
