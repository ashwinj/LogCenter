/**
 * Log4jLogger.java
 * Mar 4, 2014
 */
package aj.logging.main.loggers;

import org.apache.log4j.Logger;


/**
 * This class uses the slf4j bridge api for
 * log4j api.
 * 
 * @author Ashwin
 */
public class Log4jLogger extends LoggerThread {

	/**
	 * log4j api logger object {@link org.apache.log4j.Logger}
	 */
	private static Logger logger = Logger.getLogger(Log4jLogger.class);
	
	/* (non-Javadoc)
	 * @see aj.logging.main.LoggerThread#startLogging()
	 */
	@Override
	public void startLogging() {
		
		for (int i = 0; i < 10; i++)
            if (i % 2 == 0)
            	logger.info("Hello "+i);
            else
            	logger.debug("I am on index "+i);
	}

}
