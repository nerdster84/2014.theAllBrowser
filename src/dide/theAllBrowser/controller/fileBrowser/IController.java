package dide.theAllBrowser.controller.fileBrowser;

import java.util.List;
import java.io.File;

import dide.theAllBrowser.util.observer.IObservable;

public interface IController extends IObservable{

	//Methods for ExplorerPanel
	
	//GETTERS
	String getDefaultFolder();
	String getCurrentFolder();
	String getFilesOfDir(String path);
	
	//SETTERS
	void setCurrentFolder(String path);
	void setDefaultFolder(String path);
}
