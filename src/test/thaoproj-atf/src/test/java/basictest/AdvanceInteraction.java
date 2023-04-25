package basictest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvanceInteraction {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {		
		
		driver= new FirefoxDriver();
		//baseUrl="https://letskodeit.teachable.com";
		//baseUrl="https://www.google.com/travel/flights";
		baseUrl="https://www.goibibo.com/";	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
		public void testScreenShot() throws IOException {
		
		  String desfileName=getRandomString(10)+".png";
		  String dir=System.getProperty("user.dir")+"//screenshots//";
		  
		  TakesScreenshot scrShot =((TakesScreenshot)driver);
		  File sourceFile=scrShot.getScreenshotAs(OutputType.FILE);
		  File desFile=new File(dir+desfileName);
		  FileUtils.copyFile(sourceFile, desFile);
		}
	
	public  String getRandomString(int length)
	{
		driver.get(baseUrl);
		StringBuilder sb=new StringBuilder();
		String characters="qwertyuiopasdfghjklzxcvbnm0123456789";
		for (int i=0; i<length;i++)
		{
			int index=(int)(Math.random()*characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	
	//@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		// or @placeholder='Where from?'
		//@aria-label='Where else?'
		WebElement tb1= driver.findElement(By.xpath("//div[@class='sc-jcFjpl htmBRX']//input[@type='text']" ));
		
		tb1.sendKeys("Del");
		/*
		if (tb1!=null)
		{
			System.out.println("Tag: " + tb1.getTagName());
			System.out.println("Place holder: " + tb1.getAttribute("placeholder"));
			tb1.click();
		}
		
		
		*/
		
		
		//int s=tb.size();
		
		
		//if (s==1) {
		//	System.out.println("Size textbox: " + s);
		//	tb.get(0).sendKeys("abddfdf");
		//}
		//tb.sendKeys("Del");
		
		//WebElement ul= driver.findElement(By.xpath("//div[@id='h0T7hb-123']/ul"));
		
		//WebElement li=ul.findElement(By.id("c315"));
		//li.click();
		
		//String innerText=tb.getAttribute("innerText");
		//System.out.println(innerText);
		//List <WebElement> list=ul.findElement(By.tagName("li"));
		
	}
	
	@After
	public void tearDown() throws Exception {		
		
		Thread.sleep(3000);
		driver.quit();
	}


}
