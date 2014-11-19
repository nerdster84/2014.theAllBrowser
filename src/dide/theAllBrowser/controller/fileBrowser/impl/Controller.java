package dide.theAllBrowser.controller.fileBrowser.impl;

import java.io.File;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

import dide.theAllBrowser.controller.fileBrowser.*;
import dide.theAllBrowser.model.fileBrowser.impl.FileOperations;

public class Controller extends Observable implements IController{

	public Controller() {
	}
	public void update() {
	}
	
	private File[] getFileArrayFromDir(File dir) {
		if (! dir.isDirectory()) {
			System.out.println("Directory could not be read.");
			return(null);
		}
		File[] fileArray = null;
		try {
			fileArray = dir.listFiles();
		} catch (Exception e) {
			System.err.println("fileArray konnte nicht erzeugt werden");
			e.printStackTrace();
		}
		return(fileArray);
	}

	private String createStringFromFileList(File[] files) {
		StringBuilder sb = new StringBuilder();
		for (File file : files) {
			if (file.isFile()) {
				sb.append(file.getName());
			} else if (file.isDirectory()) {
				sb.append(file.getAbsolutePath());
			}
				
				sb.append("\n");
			
		}
		String result = null;
		result = sb.toString();
		return result;
	}

	@Override
	public String getFilesOfDir(File dir) {
		if (dir == null) {
			throw new NullPointerException("Argument dir falsch.");
		}
		String result = createStringFromFileList(getFileArrayFromDir(dir));
		return result;
		
	}

	
	

	
	
}
