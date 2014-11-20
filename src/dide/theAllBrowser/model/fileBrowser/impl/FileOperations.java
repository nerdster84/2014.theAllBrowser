package dide.theAllBrowser.model.fileBrowser.impl;

import java.io.File;
import java.io.PrintStream;
import java.lang.IllegalArgumentException;
import javax.swing.JFrame;

import dide.theAllBrowser.model.fileBrowser.IFileOperations;

public class FileOperations implements IFileOperations {

	private static String defaultDir;
	private static String currentDir;
	private static String defaultFolderString;
	
	//Constructor
	public FileOperations() {
		defaultFolderString = "c:\\test";
		defaultDir = defaultFolderString;
		currentDir = defaultDir;
		
	}

	//GETTERS
	
	@Override
	public String getFilesOfDir(String dir) {
		if (dir == null) {
			throw new NullPointerException("Argument dir falsch.");
		}
		File path = new File(dir);
		String result = createStringFromFileList(getFileArrayFromDir(path));
		return result;
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
	public String getCurrentDir() {
		if (currentDir == null) {
//			System.err.println("currentDirectory darf nicht null sein!");
//			System.exit(JFrame.EXIT_ON_CLOSE);
			currentDir = getDefaultDir();
		}
		
		File test = new File(currentDir);
		if ( ! test.isDirectory()) 
			throw new IllegalArgumentException("currentDir ist kein directory");
		return currentDir;
	}

	//SETTERS
	
	@Override
	public void setCurrenctDir(String dir) {
		File file = null;
		try {
			file = new File(dir);
		} catch (Exception e) {
			System.err.println("dir konnte nicht zu file gecastet werden");
			e.printStackTrace();
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
		
		if (file.isDirectory()) {
			currentDir = dir;
		} else {
			System.out.println("currentDir konnte nicht neu gesetzt werden");
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
	}

	@Override
	public String getDefaultDir() {
		if (defaultDir == null) {
			defaultDir = defaultFolderString;			
//			System.err.println("defaultDirectory darf nicht null sein!");
//			System.exit(JFrame.EXIT_ON_CLOSE);
		}
		return defaultDir;
	}

	@Override
	public void setDefaultDir(String dir) {
		defaultDir = dir;
	}

	public void setDir(String dir) {
		if (dir == null) {
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
		File path = null;
		try {
			path = new File(dir);
		} catch (Exception e) {
			System.err.println("Argument kann nicht als Verzeichnis geladen werden.");
			e.printStackTrace();
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
		currentDir = dir;
	}

}