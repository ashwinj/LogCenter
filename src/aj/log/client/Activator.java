package aj.log.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import aj.log.client.loggers.AbsLogger;
import aj.log.client.loggers.JclLogger;
import aj.log.client.loggers.JulLogger;
import aj.log.client.loggers.Log4jLogger;
import aj.log.client.loggers.LogbackLogger;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private AbsLogger [] loggers;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		loggers = new AbsLogger[4];
		loggers[0] = new JclLogger();
		loggers[1] = new JulLogger();
		loggers[2] = new Log4jLogger();
		loggers[3] = new LogbackLogger();
		for(int i = 0; i < 4; loggers[i++].start());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		for(int i = 0; i < 4; i++) {
			loggers[i].stopThread();
			loggers[i].join();
		}
	}

}
