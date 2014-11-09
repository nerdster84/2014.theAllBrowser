package dide.theAllBrowser.controller.fileBrowser;

import java.util.List;
import java.io.File;

public interface IController {
	void update();
	String getFilesOfDir(File dir);
	
}
