package dide.theAllBrowser.model.fileBrowser;

import java.io.File;

public interface IFileOperations {
	
//	GETTERS
	
	String getCurrentDir();
	String getDefaultDir();
	String getoldPwd();
	String getFilesOfDir(String dir);
	
//    SETTERS	
	
	void setDefaultDir(String dir);
	void setDir(String dir);
	void setOldPwd(String dir);
}




