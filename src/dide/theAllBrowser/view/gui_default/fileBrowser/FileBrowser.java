package dide.theAllBrowser.view.gui_default.fileBrowser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import dide.theAllBrowser.controller.fileBrowser.impl.Controller;
import dide.theAllBrowser.model.Module;
import dide.theAllBrowser.util.observer.Event;
import dide.theAllBrowser.util.observer.IObserver;
import dide.theAllBrowser.view.Layout;
import dide.theAllBrowser.view.layouts.LayoutCreator;
import dide.theAllBrowser.view.gui_default.fileBrowser.subComponents.ExplorerPanel;
import dide.theAllBrowser.view.gui_default.fileBrowser.subComponents.NavigationPanel;

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

//FileBrowser is a module for GUI_Default. Yet it has a completely own GUI.

public class FileBrowser extends Module implements IObserver{
	
	private Controller controller = new Controller();
	private LayoutManager layout;
	private JPanel upperHalf,
			lowerHalf;
	private Module screenPanel,
			fileListPanel;
	private JTextPane fileListTextPane = new JTextPane();
	private File activeFolder = null;
	private String pathImageDormund = "G:/=DOWNLOADS/new Bilder/oh du sch�ner bvb.jpg";
	private String browseFirst = "C:/test/theAllBrowser/niceDirectory";
	private Image dortmund;
	private Image karikatur;
	
	private Dimension size_pref = Layout.DIM_GUIDEFAULT_STD;
	private Dimension size_min = Layout.DIM_GUIDEFAULT_SMALL;
	private Dimension size_max = Layout.DIM_GUIDEFAULT_BIG;
	

	
	//Constructor
	public FileBrowser(String title) {
		this.setName(title);
		buildAddLayoutComponents();
		this.setVisible(true);
		this.setPreferredSize(size_pref);
		this.setMaximumSize(size_max);
		this.setMinimumSize(size_min);
		repaint();
		validate();
	}
	
	public void update() {
		this.fileListTextPane.setText(controller.getFilesOfDir(activeFolder));
	}
	
	private void buildAddLayoutComponents() {
		//////add components//////
		
		layout = new GridBagLayout();
		this.setLayout(layout);
	//JPanel upperHalf
		upperHalf = new JPanel();
		upperHalf.setLayout(new GridBagLayout());

		//explorerView contains all the folders views 
			JPanel explorerView = new JPanel();
			//configure layout manager or similar
			explorerView.setLayout(new BoxLayout(explorerView, BoxLayout.X_AXIS));
			//explorerView.setPreferredSize(Layout.DIM_GUIDEFAULT_STD);
			//add folders to the JPanel explorerView 
			ExplorerPanel explorer1 = new ExplorerPanel("");
			explorerView.add(explorer1);
			ExplorerPanel explorer2 = new ExplorerPanel("");
			explorerView.add(explorer2);
			ExplorerPanel explorer3 = new ExplorerPanel("");
			explorerView.add(explorer3);
			GridBagConstraints constrExplorerPanel = new GridBagConstraints();
			constrExplorerPanel.gridx = 0;
			constrExplorerPanel.gridy = 0;
//			constrExplorerPanel.weighty = 0.1;
			//constrExplorerPanel.fill = GridBagConstraints.BOTH;
			upperHalf.setBorder(Layout.BORDER_PANEL_UPPERHALF);
			upperHalf.add(explorerView, constrExplorerPanel);
			
		//Navigation-Panel
			NavigationPanel navigationPanel = new NavigationPanel();
			GridBagConstraints constrNavPanel = new GridBagConstraints();
			constrNavPanel.gridx = 0;
			constrNavPanel.gridy = 1;
//			constrNavPanel.weighty = 0.0;
			constrNavPanel.anchor = constrNavPanel.FIRST_LINE_START;
		upperHalf.add(navigationPanel, constrNavPanel);
		upperHalf.setLayout(new BoxLayout(upperHalf, BoxLayout.Y_AXIS));
		GridBagConstraints constrUpper = new GridBagConstraints();
		constrUpper.gridx = 0;
		constrUpper.gridy = 0;
		constrUpper.weightx = 1;
		constrUpper.weighty = 1;
		constrUpper.fill = GridBagConstraints.BOTH;
		this.add(upperHalf, constrUpper);
		
	//lowerHalf is to be done much later when code for upperHalf is finished
		JPanel lowerHalf = new JPanel();
		GridBagConstraints constrLower = new GridBagConstraints();
		constrLower.gridx = 0;
		constrLower.gridy = 1;
		constrLower.weightx = 1;
		constrLower.weighty = 1;
		
		//constrLower.gridheight = 1;
		constrLower.fill = GridBagConstraints.BOTH;
		constrLower.anchor = GridBagConstraints.LINE_START;
		lowerHalf.setBorder(Layout.BORDER_PANEL_LOWERHALF);
		this.add(lowerHalf, constrLower);
		this.setBorder(Layout.BORDER_PANEL_FILEBROWSER);
		this.setLayout(layout);
		this.setPreferredSize(Layout.DIM_GUIDEFAULT_STD);
		this.setMinimumSize(Layout.DIM_GUIDEFAULT_SMALL);
		this.setMaximumSize(Layout.DIM_GUIDEFAULT_BIG);
		
		
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

	@Override
	public void update(Event e) {
		this.repaint();
		this.validate();
	}
	
}











