package database;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DBTest {
	
	//download mysql connector driver: https://mvnrepository.com/artifact/mysql/mysql-connector-java
		 
	  //Connection object:
	  static Connection conn=null;
	  //Statement object
	  private static Statement stmt;
	  
	  //Result set
	  private static ResultSet rs=null;
	  
	  //Constants for DB url/credentials
	  public static String DB_URL="jdbc:mysql://pds-sd-di.cua8asf8jbhp.us-west-2.rds.amazonaws.com:3306/pds_sd_di";
	  //Oracle: "jdbc:oracle:thin:@localhost:3306/users"
	  public static String DB_USER="pds_sd_di";
	  public static String DB_PASSWORD="pdssd_dev123";
	  
	  //DB Driver
	  
	  public static String driver="com.mysql.jdbc.Driver"; 
	  //Oracle: "oracle.jdbc.driver.Oracle"
	  
	  //WebDriver
	  public static WebDriver wd;
 
  @BeforeClass
  public void beforeClass() {
	 //Initialize WebDriver
	  wd= new FirefoxDriver();
	  
	  //Creating connection to DB
	  
	  try {
		  
		  //Register JDBC driver
		  Class.forName(driver);
		  //Get connection to DB
		  
		  System.out.println("Connecting to a selected database...");
		  conn = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
		  System.out.println("Connected database successfully...");
		  
		  //Send SQL statement to DB
		  System.out.println("Creating statement...");
		  stmt=conn.createStatement();
		  
	  }catch (Exception e) {
		  e.printStackTrace();
		 
		  
	  }
	  
  }
  
  @SuppressWarnings("deprecation")
@Test
  public void Testabc() {
	  String query= "SELECT * FROM pds_sd_di.transaction_info limit 1;";
			  
		try {
			//execute query, extract data from result set
			rs=stmt.executeQuery(query);
			while (rs.next()) {
				String transactionId=rs.getString("transactionId");
				String startTime= rs.getString("startTime");
				String operationDetail= rs.getString("operationDetail");
				
				//Display value
				
				System.out.println("\n TransactionID: "+ transactionId);
				System.out.println("\n Start Time: "+ startTime);
				System.out.println("\n Operation Detail: "+ operationDetail);
				
				String webUrl="https://www.directv.com/";
				wd.manage().window().maximize();
				wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				wd.get(webUrl);
				
				WebElement el =wd.findElement(By.id("global-nav-lnk-1-lt "));
				String text=el.getText();
				Assert.assertEquals(transactionId,text);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  
	  try {
		  if (rs!=null) {
			  rs.close();
		  }
		  if (stmt!=null) {
			  stmt.close();			  
		  }
		  
		  if (conn!=null) {
			  conn.close();
		  }
		  
	  }catch (SQLException e) {
		  e.printStackTrace();
	  }
	  
	  Thread.sleep(1000);
		wd.quit();
  }

}
