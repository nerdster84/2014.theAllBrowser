package dide.theAllBrowser.model.fileBrowser;

import java.io.File;

public interface IFileOperations {
	String getCurrentDir();
	String getDefaultDir();
	void setCurrenctDir(String dir);
	void setDefaultDir(String dir);
	
	String getFilesOfDir(String dir);
	void setDir(String dir);
}




