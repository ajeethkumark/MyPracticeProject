package log4jTest;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerPractice {
	
	
	private static Logger logger=Logger.getLogger(LoggerPractice.class);
	public static void main(String[] arg)
	{
		//BasicConfigurator.configure();
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+File.separator+"log4j.properties");
	//	PropertyConfigurator.configure("E:\\spring\\ajeeth\\src\\log4j.properties");
		logger.trace("This is trace message");
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warn message");
		logger.error("This is error message");
		logger.fatal("This is fatal message");
		
		//Logger Notes
		/*
		 * log4j has three main component
		 * 
		 * Loggers:Responsible for capturing logging information
		 * Appender:Responsible for publishing logging information to various preferred destinations.
		 * Layouts:Responsible for formatting  logging information in different styles.	 * 
		 * 
		 */
	}

}
