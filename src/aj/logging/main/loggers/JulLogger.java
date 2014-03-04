/**
 * JulLogger.java
 * Mar 4, 2014
 */
package aj.logging.main.loggers;

import java.util.logging.*;


/**
 * This class uses the slf4j bridge api for
 * java.util.logging api.
 * 
 * @author Ashwin
 */
public class JulLogger extends LoggerThread {

	/**
	 * Jul api logger object {@link java.util.Logger}
	 */
	private static Logger logger = Logger.getLogger(JulLogger.class.getSimpleName());
	
	/* (non-Javadoc)
	 * @see aj.logging.main.LoggerThread#startLogging()
	 */
	@Override
	public void startLogging() {
		
		for (int i = 0; i < 10; i++)
            if (i % 2 == 0)
            	logger.log(Level.INFO, "Hello "+i);
            else
            	logger.log(Level.FINE, "I am on index "+i);
	}

}
