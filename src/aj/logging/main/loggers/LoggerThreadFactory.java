/**
 * LogCenterFactory.java
 * Mar 4, 2014
 */
package aj.logging.main.loggers;

/**
 * This class provides concrete instance of different loggers.
 * 
 * @author Ashwin
 */
public class LoggerThreadFactory {

	/**
	 * Provides a jcl logger instance.
	 * @return LoggerThread
	 */
	public static LoggerThread getJclLoggerThread() {
		return new JclLogger();
	}
	
	/**
	 * Provides a jul logger instance.
	 * @return LoggerThread
	 */
	public static LoggerThread getJulLoggerThread() {
		return new JulLogger();
	}

	/**
	 * Provides a log4j logger instance.
	 * @return LoggerThread
	 */
	public static LoggerThread getLog4jLoggerThread() {
		return new Log4jLogger();
	}
	
	/**
	 * Provides a logback logger instance.
	 * @return LoggerThread
	 */
	public static LoggerThread getLogbackLoggerThread() {
		return new LogbackLogger();
	}

}
