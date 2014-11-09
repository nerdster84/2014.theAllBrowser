package dide.theAllBrowser.view.gui_default.fileBrowser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import dide.theAllBrowser.controller.fileBrowser.impl.Controller;
import dide.theAllBrowser.model.Module;
import dide.theAllBrowser.view.layouts.LayoutCreator;

/**
 * FileBrowser is a Module for convenient File-Browsing.
 * 
 * First, only display a directories content, mr .didemann!
 * 
 * Read Directories
 * Open Files + Dirs
 * Copy Files + Dirs
 * Delete Files + Dirs
 * Move Files + Dirs
 * Rename Files + Dirs
 * Create New Folder
 * and so on...
 */

//LISTENER NOCH EINBAUEN!!

public class FileBrowser extends Module{

	String testPath = "G:/=DOWNLOADS/new Bilder/oh du schöner bvb.jpg";
	JTextPane fileListTextPane = null;
	Controller controller = new Controller();
	File activeFolder = null;
	String browseFirst = "C:/test/theAllBrowser/niceDirectory";
	
	public FileBrowser(String title) {
		this.setName(title);
		
		//////add components//////
		
		//add fileListPanel
		Module fileListPanel = new Module();
		fileListPanel.setLayout(new BoxLayout(fileListPanel,BoxLayout.LINE_AXIS));
				
		//add TextPane to fileListPanel
		fileListTextPane = new JTextPane();
		activeFolder = new File(browseFirst);
		fileListTextPane.setText(controller.getFilesOfDir(activeFolder));
		
		
		//fileListTextPane.setText("TESTETSETESTASETSET");
		fileListPanel.add(fileListTextPane);
		
		//try adding a picture to test the gui
		try {
			Image image = ImageIO.read(new File(testPath));
			//ImageIcon icon = new ImageIcon("G:/=DOWNLOADS/new Bilder/oh_du_schöner_bvb.jpg");
			JLabel imageLabel = new JLabel(new ImageIcon(image));
			//GridBagConstraints constraints_imageLabel = new GridBagConstraints();
			fileListPanel.add(imageLabel);
		} catch (Exception e) {
			System.exit(ERROR);
		}
		this.add(fileListPanel);
		this.setVisible(true);
		repaint();
	}
	
	
	public void update() {
		
		this.fileListTextPane.setText(controller.getFilesOfDir(activeFolder));
	}
	
	
}










