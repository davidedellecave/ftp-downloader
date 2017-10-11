package ddc.ftp.downloader.console;

import java.io.File;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import ddc.app.console.AbstractConsoleApp;
import ddc.support.util.LogConsole;
import ddc.support.util.LogListener;

/**
 * @author davide 2013
 *
 */
public abstract class SpringConsoleApp extends AbstractConsoleApp {
	private static GenericApplicationContext context;
	private LogListener logger = new LogConsole(SpringConsoleApp.class);

	public GenericApplicationContext getContext() {
		return context;
	}
	
	public LogListener getLogger() {
		return logger;
	}

	public void setLogger(LogListener logger) {
		this.logger = logger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.davidedc.console.AbstractConsoleApp#validateArgs()
	 */
	@Override
	public boolean validateArgs() {
		String appContext = null;
		if (getArgs().length > 0) {
			appContext = getArgs()[0];
		}
		if (appContext == null)
			return false;
		logger.info("AppContext file:[" + appContext + "]");
		File ctxFile = new File(appContext);
		if (!ctxFile.exists()) {
			logger.error("AppContext file:[" + ctxFile.getAbsolutePath() + "] does not exist");
			return false;
		}
		context = getApplicationContext(ctxFile, false);
		return true;
	}

	private GenericApplicationContext getApplicationContext(File path, boolean validating) {
		GenericXmlApplicationContext gac = new GenericXmlApplicationContext();
		gac.setValidating(validating);
		Resource res = new FileSystemResource(path);
		gac.load(res);
		gac.refresh();
		return gac;
	}

}
