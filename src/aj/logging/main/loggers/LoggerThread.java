/**
 * LoggerThread.java
 * Mar 4, 2014
 */
package aj.logging.main.loggers;

/**
 * This is the default Logger available to the user.
 * 
 * @author Ashwin
 */
public abstract class LoggerThread extends Thread {

	public LoggerThread() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#start()
	 */
	@Override
	public synchronized void start() {
		this.startLogging();
	}

	/**
	 * Starts the logging task. Each class extending
	 * <b>LoggerThread</b> class must implement this.
	 */
	public abstract void startLogging();
}
