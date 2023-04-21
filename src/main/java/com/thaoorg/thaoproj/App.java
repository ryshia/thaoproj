package com.thaoorg.thaoproj;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static Logger log = LogManager.getLogger(App.class.getName());
	
    public static void main( String[] args )
    {
    		//System.out.println("abc testing");
    		
    		//BasicConfigurator.configure();
    		log.info("This is TRACE log from main package");
    		log.debug("This is DEBUG log from main package");
    		log.fatal("This is FATAL log from main package");
    		log.error("This is ERROR log from main package");
    	
    }
}
