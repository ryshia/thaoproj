package com.thaoorg.thaoproj;

import org.testng.annotations.Test;

import log4jdemo2.LoggingFileDemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;

public class GroupingTest {
	
	private static Logger log = LogManager.getLogger(GroupingTest.class.getName());
	
	 @Test
	  public void TestLogging() {
		  log.info("This is INFO log from log4jdemo2 package");
			log.warn("This is WARN log from log4jdemo2 package");
			log.trace("This is TRACE log from log4jdemo2 package");
			log.debug("This is DEBUG log from log4jdemo2 package");
			log.fatal("This is FATAL log from log4jdemo2 package");
			log.error("This is ERROR log from log4jdemo2 package");
	  }
	
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
