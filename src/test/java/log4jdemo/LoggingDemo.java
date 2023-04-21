package log4jdemo;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;

public class LoggingDemo {
	
  private static Logger log = LogManager.getLogger(LoggingDemo.class.getName());
	
  @Test
  public void TestLogging() {
	  log.info("This is INFO log from log4jdemo package");
		log.warn("This is WARN log from log4jdemo package");
		log.trace("This is TRACE log from log4jdemo package");
		log.debug("This is DEBUG log from log4jdemo package");
		log.fatal("This is FATAL log from log4jdemo package");
		log.error("This is ERROR log from log4jdemo package");
  }
  
  @BeforeClass
  public void beforeClass() {
  }  

  @AfterClass
  public void afterClass() {
  }

}
