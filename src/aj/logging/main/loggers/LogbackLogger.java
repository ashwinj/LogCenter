/**
 * LogbackLogger.java
 * Mar 4, 2014
 */
package aj.logging.main.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class uses the slf4j api for
 * logback logging api.
 * 
 * @author Ashwin
 */
public class LogbackLogger extends LoggerThread {

	/**
	 * slf4j api logger object {@link org.slf4j.Logger}
	 */
	private static Logger logger = LoggerFactory.getLogger(LogbackLogger.class);
	
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
