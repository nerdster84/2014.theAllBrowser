package dide.theAllBrowser.controller.fileBrowser.impl;

import java.io.File; 
import java.util.List;

import dide.theAllBrowser.util.observer.Event;
import dide.theAllBrowser.util.observer.Observable;
import dide.theAllBrowser.controller.fileBrowser.*;
import dide.theAllBrowser.model.fileBrowser.impl.FileOperations;

public class Controller extends Observable implements IController{

	private FileOperations fileOperations;
	
	//Constructor
	public Controller() {
		fileOperations = new FileOperations();
	}
	
	//GETTERS
	
	@Override
	public String getFilesOfDir(String path) {
		String result;
		result = fileOperations.getFilesOfDir(path);
		return result;
	}

	@Override
	public String getDefaultFolder() {
		return fileOperations.getDefaultDir();
	}
	
	@Override
	public String getCurrentFolder() {
		return fileOperations.getCurrentDir();
	}

	//SETTERS
	
	@Override
	public void setDefaultFolder(String path) {
		fileOperations.setDefaultDir(path);
	}
	
	@Override
	public void setCurrentFolder(String path) {
		fileOperations.setCurrenctDir(path);
		//dem notify.. noch einen Event als Argument übergeben
		this.notifyObservers();
	}
	
}
