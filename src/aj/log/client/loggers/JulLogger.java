/**
 * JulLogger.java
 * Mar 4, 2014
 */
package aj.log.client.loggers;

import java.util.Random;
import java.util.logging.*;

/**
 * This class uses the slf4j bridge api for
 * java.util.logging api.
 * 
 * @author Ashwin
 */
public class JulLogger extends AbsLogger {

	private volatile boolean active = true;
	private int timeElapsed = 0;
	private Logger log = Logger.getLogger(JulLogger.class.getName());

	public void run() {
		while (active) {
			int mod = timeElapsed % 7;
			switch(mod)
			{
			case 0:
				log.info("info level log.");
				break;
			case 1:
				log.config("config level log.");
				break;
			case 2:
				log.warning("warning level log");
				break;
			case 3:
				log.fine("fine level log");
				break;
			case 4:
				log.finer("finer level log");
				break;
			case 5:
				log.finest("finest level log");
				break;
			case 6:
				log.severe("severe level log");
				break;
			}
			try {
				Random r = new Random();
				int i = r.nextInt(8) + 7;
				timeElapsed += i; 
				Thread.sleep(i*1000);
			} catch (Exception e) {
				log.severe("Thread interrupted " + e.getMessage());
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
