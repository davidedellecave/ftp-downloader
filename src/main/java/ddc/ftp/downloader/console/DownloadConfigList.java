package ddc.ftp.downloader.console;

import java.util.ArrayList;
import java.util.List;

import ddc.support.util.FormatUtils;

public class DownloadConfigList {
	private List<DownloadConfig> confList = new ArrayList<DownloadConfig>();
	private boolean enableParallelExecution;
	
	public List<DownloadConfig> getConfList() {
		return confList;
	}
	public void setConfList(List<DownloadConfig> configList) {
		this.confList = configList;
	}
	public boolean isEnableParallelExecution() {
		return enableParallelExecution;
	}
	public void setEnableParallelExecution(boolean enableParallelExecution) {
		this.enableParallelExecution = enableParallelExecution;
	}
	
	public String toString() {
		return FormatUtils.format(this);
	}
}
