/**
 * JclLogger.java
 * Mar 4, 2014
 */
package aj.logging.main.loggers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * This class uses the slf4j bridge api for
 * apache common logging api.
 * 
 * @author Ashwin
 */
public class JclLogger extends LoggerThread {

	/**
	 * Jcl api logger object {@link org.apache.logging.Log}
	 */
	private static Log logger = LogFactory.getLog(JclLogger.class);
	
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
