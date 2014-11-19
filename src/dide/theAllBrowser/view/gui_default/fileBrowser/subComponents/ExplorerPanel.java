package dide.theAllBrowser.view.gui_default.fileBrowser.subComponents;

import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dide.theAllBrowser.controller.fileBrowser.impl.Controller;
import dide.theAllBrowser.view.Layout;


/**
 * Panel for one folder-explorer. to be added to an explorer-display-panel or smth like ditte 
 */
public class ExplorerPanel extends JPanel{

	private Controller controller;
	private LayoutManager layout;
	private JPanel titlePanel,
					actualPanel,
					backButtonPanel, //Panel for button for cd ..
					openNewExplorer,		
					display;				//shows folder's content
	
	private JButton backButton;		//cd ..
	private String 	currentFolder,
					defaultFolder;
//	private Dimension size_min,
//						size_max,
//						size_pref;

	
	
	//Constructor
	public ExplorerPanel(String style) {
		
		if ( (style == null) || (style.toString() == "") ) {
			style = "default";
		}
		switch(style) {
		case "default":
				System.out.println("ExplorerPanel(default) wird erzeugt");
		default:
			controller = new Controller();
			defaultFolder = "C:\\test\\theAllBrowser\\niceDirectory";
			setFolder(defaultFolder);
			buildPanel();
//			size_pref = Layout.DIM_EXPLORERPANEL_STD;
//			size_max = Layout.DIM_EXPLORERPANEL_BIG;
//			size_min = Layout.DIM_EXPLORERPANEL_SMALL;
			this.setSize(Layout.DIM_EXPLORERPANEL_STD);
			this.setMaximumSize(Layout.DIM_MAX);
			this.setMinimumSize(Layout.DIM_EXPLORERPANEL_SMALL);
			this.setBorder(Layout.BORDER_PANEL_EXPLORERPANEL);
			validate();
		}
	}
	
	//method to actually build the whole ExplorerPanel-object
	private void buildPanel() {
		
		this.setLayout(new GridBagLayout());
		
		//add title-line: display the pwd
		//titlePanel = new JPanel(new GridBagLayout());
		JTextField textField = new JTextField();
		textField.setText(defaultFolder);
		textField.setEditable(false);
//		textField.setPreferredSize(Layout.DIM_TEXTFIELD_STD);
//		textField.setMinimumSize(Layout.DIM_TEXTFIELD_SMALL);
//		textField.setMaximumSize(Layout.DIM_TEXTFIELD_BIG);
		GridBagConstraints gc = new GridBagConstraints();
//		gc.weightx = 1;
//		gc.weighty = 1;
//		gc.fill = GridBagConstraints.BOTH;
//		gc.anchor = GridBagConstraints.PAGE_START; 
//		titlePanel.add(textField);
//		gc = new GridBagConstraints();

		this.add(textField, gc);
		//this.add(titlePanel, gc);
		gc.weightx = 1;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.PAGE_START; 
		this.add(textField, gc);
		//the actual panel (contains all elements except for the title-panel)
		actualPanel = new JPanel();
		actualPanel.setLayout(new GridBagLayout());		
		
		//add button to 
		backButtonPanel = new JPanel();
		backButton = new JButton("Back");
		backButtonPanel.add(backButton);
		//backButton.setMaximumSize(Layout.DIM_MAX);
		//backButton.setPreferredSize(Layout.DIM_EXPLORERPANEL_SMALL);
		gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.2;
		gc.fill = GridBagConstraints.BOTH;
		actualPanel.add(backButtonPanel, gc);
		
		//add display-panel for the actual folder-view
		JTextArea folderDisplay = new JTextArea();
		//folderDisplay.setText("Hier kommt der Ordnerinhalt rein...");
		File dir = new File(currentFolder);
		folderDisplay.setText(controller.getFilesOfDir(dir));
		folderDisplay.setLineWrap(true);
		folderDisplay.setBorder(Layout.BORDER_STD);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		actualPanel.add(folderDisplay, gc);
		
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		this.add(actualPanel, gc);
		
		
	}
	
	
	private void setFolder(String path) {
		if (path == null) {
			path = defaultFolder;
		}
		currentFolder = path;
	}
	
}
