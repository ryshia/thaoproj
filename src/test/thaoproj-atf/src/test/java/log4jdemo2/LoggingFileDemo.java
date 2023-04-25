package log4jdemo2;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class LoggingFileDemo {
	private static Logger log = LogManager.getLogger(LoggingFileDemo.class.getName());
	
	  @Test
	  public void TestLogging() {
		  log.info("This is INFO log from log4jdemo2 package");
			log.warn("This is WARN log from log4jdemo2 package");
			log.trace("This is TRACE log from log4jdemo2 package");
			log.debug("This is DEBUG log from log4jdemo2 package");
			log.fatal("This is FATAL log from log4jdemo2 package");
			log.error("This is ERROR log from log4jdemo2 package");
	  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
