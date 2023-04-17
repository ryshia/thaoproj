package com.thaoorg.thaoproj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GroupingTest {
	
	 @Test(groups= {"car","suv"})
	  public void test1() {
		 System.out.println("  GroupingTest-> BMW SUV");
	  }
	  
	 @Test(groups= {"car","sedan"})
	  public void test2() {
		  System.out.println("  GroupingTest-> Audi Sedan");
	  }
	  
	 @Test(groups= {"car","suv"})
	  public void test3() {
		  System.out.println("  GroupingTest-> Prius SUV");
	  }
	 @Test(groups= {"bike"})
	  public void test4() {
		  System.out.println("  GroupingTest-> Honda SH");
	  }
	  
	 @Test(groups= {"bike"})
	  public void test5() {
		  System.out.println("  GroupingTest-> Honda CBR");
	  }	  
	  
	  
 // @BeforeMethod (alwaysRun=true)
  public void beforeMethod() {
	  System.out.println("  GroupingTest-> before method");
  }

 // @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("  GroupingTest-> after method");
  }

  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  System.out.println("  GroupingTest-> before class");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("  GroupingTest-> after class");
  }

  
}
