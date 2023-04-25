package utils;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void takeScreenShot (WebDriver driver, String fileName) throws IOException
	{
		fileName=fileName +".png";
		String dir="C:\\THAO\\SourceCode\\example\\thaoproj\\Screenshots\\";
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File (dir+fileName));
	}
	
	public static String takeScreenShotExtent(WebDriver driver, String fileName) throws IOException
	{
		fileName=fileName +".png";
		String dir="C:\\THAO\\SourceCode\\example\\thaoproj\\Screenshots\\";
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fullPath=dir+fileName;
		FileUtils.copyFile(sourceFile, new File (fullPath));
		
		return fullPath;
	}

}
