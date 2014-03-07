/**
 * LogbackLogger.java
 * Mar 4, 2014
 */
package aj.log.client.loggers;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class uses the slf4j api for
 * logback logging api.
 * 
 * @author Ashwin
 */
public class LogbackLogger extends AbsLogger {

	private volatile boolean active = true;
	private int timeElapsed = 0;
	private Logger log = LoggerFactory.getLogger(LogbackLogger.class.getName());

	public void run() {
		while (active) {
			int mod = timeElapsed % 7;
			switch(mod)
			{
			case 0:
				log.info("info level log.");
				break;
			case 1:
				log.debug("debug level log.");
				break;
			case 2:
				log.error("error level log");
				break;
			case 3:
				log.warn("warn level log");
				break;
			case 5:
				log.trace("trace level log");
				break;
			}
			try {
				Random r = new Random();
				int i = r.nextInt(8) + 7;
				timeElapsed += i; 
				Thread.sleep(i*1000);
			} catch (Exception e) {
				log.error("Thread interrupted " + e.getMessage(), e);
			}
		}
	}

	public void stopThread() {
		log.info("Stopping logging thread....");
		active = false;
		log.info("Logging thread stopped....");
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#start()
	 */
	@Override
	public synchronized void start() {
		log.info("Starting logger thread....");
		super.start();
	}

}
