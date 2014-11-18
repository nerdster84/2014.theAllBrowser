package dide.theAllBrowser.view.gui_default.fileBrowser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.LayoutManager;
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
import dide.theAllBrowser.view.gui_default.fileBrowser.subComponents.ExplorerPanel;

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

	Controller controller = new Controller();
	
	String pathImageDormund = "G:/=DOWNLOADS/new Bilder/oh du sch�ner bvb.jpg";
	String browseFirst = "C:/test/theAllBrowser/niceDirectory";
	Image dortmund;
	Image karikatur;
	
	Module fileListPanel;
		JTextPane fileListTextPane = new JTextPane();
		File activeFolder = null;
		
	Module screenPanel;
		
	public FileBrowser(String title) {
		this.setName(title);
		buildAddLayoutComponents();
		this.setVisible(true);
		repaint();
		validate();
	}
	
	public void update() {
		
		this.fileListTextPane.setText(controller.getFilesOfDir(activeFolder));
	}
	
	private void buildAddLayoutComponents() {
		//////add components//////
		
		JPanel upperHalf = new JPanel();
		JPanel lowerHalf = new JPanel();
				
		//upperHalf
			//explorerView contains all the folders views 
			JPanel explorerView = new JPanel();
				//configure layout manager or similar
				explorerView.setLayout(new BoxLayout(explorerView, BoxLayout.X_AXIS));
				//add folders to the JPanel explorerView 
				ExplorerPanel explorer1 = new ExplorerPanel("");
				explorerView.add(explorer1);
				ExplorerPanel explorer2 = new ExplorerPanel("");
				explorerView.add(explorer2);
		upperHalf.add(explorerView);
				
		this.add(upperHalf);
		
		//lowerHalf is to be done much later when code for upperHalf is finished
		this.add(lowerHalf);
		
		
		
		
		
		
		
//		//add fileListPanel
//		fileListPanel = new Module();
//		fileListPanel.setLayout(new BoxLayout(fileListPanel,BoxLayout.LINE_AXIS));
//		//add TextPane to fileListPanel
//		activeFolder = new File(browseFirst);
//		fileListTextPane.setText(controller.getFilesOfDir(activeFolder));
//		//fileListTextPane.setText("TESTETSETESTASETSET");
//		fileListPanel.add(fileListTextPane);
//		//try adding a picture to test the gui
//		try {
//			dortmund = ImageIO.read(new File(pathImageDormund));
//			//ImageIcon icon = new ImageIcon("G:/=DOWNLOADS/new Bilder/oh_du_sch�ner_bvb.jpg");
//			JLabel imageLabel = new JLabel(new ImageIcon(dortmund));
//			//GridBagConstraints constraints_imageLabel = new GridBagConstraints();
//			fileListPanel.add(imageLabel);
//		} catch (Exception e) {
//			System.exit(ERROR);
//		}
//		this.add(fileListPanel);
	}
	
}










