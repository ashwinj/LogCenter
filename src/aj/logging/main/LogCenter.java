/**
 * LogCenter.java
 * Mar 4, 2014
 */
package aj.logging.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aj.logging.main.loggers.LoggerThread;
import aj.logging.main.loggers.LoggerThreadFactory;

/**
 * This class tests the slf4j bridge api.
 * 
 * @author ashwin
 */
public class LogCenter {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(LogCenter.class);
		
		try {
			LoggerThread [] loggerThreads = new LoggerThread[4];
			loggerThreads[0] = LoggerThreadFactory.getJclLoggerThread();
			loggerThreads[0].start();
			loggerThreads[0].join();
			loggerThreads[1] = LoggerThreadFactory.getJulLoggerThread();
			loggerThreads[1].start();
			loggerThreads[1].join();
			loggerThreads[2] = LoggerThreadFactory.getLog4jLoggerThread();
			loggerThreads[2].start();
			loggerThreads[2].join();
			loggerThreads[3] = LoggerThreadFactory.getLogbackLoggerThread();
			loggerThreads[3].start();
			loggerThreads[3].join();
		} catch(InterruptedException e) {
			logger.error("\n\n\t\t******Thread execution error.********\n\n",e.getCause());
		}
		/*LoggerThreadFactory.getJclLoggerThread().start();
		LoggerThreadFactory.getJulLoggerThread().start();
		LoggerThreadFactory.getLog4jLoggerThread().start();
		LoggerThreadFactory.getLogbackLoggerThread().start();*/
		
	}

}
