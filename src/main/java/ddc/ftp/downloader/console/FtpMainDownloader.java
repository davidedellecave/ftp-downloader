package ddc.ftp.downloader.console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ddc.ftp.downloader.FtpDownloader;
import ddc.ftp.downloader.Version;
import ddc.support.util.LogConsole;
import ddc.support.util.LogListener;


public class FtpMainDownloader extends SpringConsoleApp {
	private LogListener logger = new LogConsole(FtpMainDownloader.class);
	
	public static void main(String[] args) {
		FtpMainDownloader app = new FtpMainDownloader();
		if (args!=null && args.length>0) {
			app.setArgs(new String[] {args[0]});
		} else {
			app.setArgs(new String[] {"applicationContext.xml"});
		}
		app.run();
	}
	
	@Override
	public void execute() throws InterruptedException {
		DownloadConfigList config = (DownloadConfigList)super.getContext().getBean("FtpDownloaderConfiguration");
		doExecute(config);
	}
	
	private void doExecute(DownloadConfigList config) throws InterruptedException {
		int parallelThread = 1;
		if (config.isEnableParallelExecution()) {
			parallelThread = config.getConfList().size();
		}
		final ExecutorService executor = Executors.newFixedThreadPool(parallelThread);
		for (DownloadConfig p : config.getConfList()) {
			FtpDownloader d = new FtpDownloader(p);
			executor.execute(d);
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

	@Override
	public void infoApplicationHeader() {
		StringBuilder b = new StringBuilder();		
		b.append("\n=======================================\n");		
		b.append(Version.FULL_APP_NAME + "\n");
		b.append("=======================================\n");
		logger.info(b.toString());
	}

	@Override
	public void infoApplicationFooter() {
		String b = ("=======================================");
		logger.info(b);
	}

	@Override
	public void errorApplicationUsage() {
		// TODO Auto-generated method stub
		
	}

}
