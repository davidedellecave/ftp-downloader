package ddc.ftp.downloader.console;

import ddc.ftp.FtpFileMatcher;
import ddc.ftp.matcher.TrueMatcher;
import ddc.support.util.FormatUtils;


public class RemotePath {
	private String path="/";
	private boolean isRecursive=true;
	
//	private FtpFileMatcher folderSelector=null;
	private FtpFileMatcher fileSelector=new TrueMatcher();
//	private String serverSideFileSelector=null;
	
	public RemotePath() {
	}
	
	public String getPath() {
		return path;
	}	
	public void setPath(String basePath) {
		this.path = basePath;
	}	
	public boolean isRecursive() {
		return isRecursive;
	}
	public void setRecursive(boolean isRecursive) {
		this.isRecursive = isRecursive;
	}	
//	public FtpFileMatcher getFolderSelector() {
//		return folderSelector;
//	}
//	public void setFolderSelector(FtpFileMatcher folderSelector) {
//		this.folderSelector = folderSelector;
//	}
	public FtpFileMatcher getFileSelector() {
		return fileSelector;
	}
	public void setFileSelector(FtpFileMatcher fileSelector) {
		this.fileSelector = fileSelector;
	}

//	public String getServerSideFileSelector() {
//		return serverSideFileSelector;
//	}
//
//	public void setServerSideFileSelector(String serverSideSelector) {
//		this.serverSideFileSelector = serverSideSelector;
//	}
	
	public String toString() {
		return FormatUtils.format(this);
	}

}
