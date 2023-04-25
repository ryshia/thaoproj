package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportFactory {
	
	public static ExtentReports getInstance() {
		   ExtentReports report = new ExtentReports("C:\\THAO\\SourceCode\\example\\thaoproj\\ExtentReports\\report-demo.html",false);
		
		  report.addSystemInfo("Platform", "Windows 11");
		  report.addSystemInfo("Selenium", "4.x");
		  
		  return report;
	}

}
