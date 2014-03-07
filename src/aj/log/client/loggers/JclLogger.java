/**
 * JclLogger.java
 * Mar 4, 2014
 */
package aj.log.client.loggers;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class uses the slf4j bridge api for
 * apache common logging api.
 * 
 * @author Ashwin
 */
public class JclLogger extends AbsLogger {

	private volatile boolean active = true;
	private int timeElapsed = 0;
	private Log log = LogFactory.getLog(JclLogger.class);

	public void run() {
		while (active) {
			int mod = timeElapsed % 5;
			switch(mod)
			{
			case 0:
				log.info("info level log.");
				break;
			case 1:
				log.debug("debug level log.");
				break;
			case 2:
				log.warn("warn level log");
				break;
			case 3:
				log.error("error level log");
				break;
			case 4:
				log.fatal("fatal level log");
				break;
			}
			try {
				Random r = new Random();
				int i = r.nextInt(6) + 5;
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
