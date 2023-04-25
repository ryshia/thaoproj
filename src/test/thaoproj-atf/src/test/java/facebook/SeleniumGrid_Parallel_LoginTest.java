package facebook;

import org.testng.annotations.Test;

import basepackage.BaseTestSuite;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

public class SeleniumGrid_Parallel_LoginTest extends BaseTestSuite {

 
  @BeforeClass
  public void beforeClass() {
	 
  }
  
  @Test
  public void TestLogin() throws InterruptedException {
	  System.out.println("Before Login Test ...");
	 
	  loginPage.setEmail("abc@gmail.com");
	  loginPage.setPassword("abcdefgh");
	  Thread.sleep(2000);
	  loginPage.clickLoginBtn();
	  
	  System.out.println("After Login Test ...");
  }

  @AfterClass
  public void afterClass() {
	 
  }

}
