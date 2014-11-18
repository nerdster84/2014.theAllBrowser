package dide.theAllBrowser.view.gui_default.fileBrowser.subComponents;

import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import dide.theAllBrowser.view.Layout;


/**
 * Panel for one folder-explorer. to be added to an explorer-display-panel or smth like ditte 
 */
public class ExplorerPanel extends JPanel{

	private LayoutManager layout;
	private JPanel titlePanel,
					actualPanel,
					backButtonPanel, //Panel for button for cd ..
					openNewExplorer,		
					display;				//shows folder's content
	
	private JButton backButton;		//cd ..
	private String 	currentFolder,
					defaultFolder;
	private Dimension size_min,
						size_max,
						size_pref;

	
	//Constructor
	public ExplorerPanel(String style) {
		
		if ( (style == null) || (style.toString() == "") ) {
			style = "default";
		}
		switch(style) {
		case "default":
				System.out.println("ExplorerPanel(default) wird erzeugt");
		default:
			defaultFolder = "C:\test\theAllBrowser\niceDirectory";
			buildPanel();
			size_pref = new Dimension(500, 300);
			this.setSize(size_pref);
			this.setBorder(Layout.BORDER_STD);
			validate();
		}
	}
	
	//method to actually build the whole ExplorerPanel-object
	private void buildPanel() {
		
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		//layout = new GridLayout();
		
		//set layout-specific details
		this.setBackground(Layout.COL_BACKGROUND);
		
		
		//add title-line: display the pwd
		titlePanel = new JPanel();
		JTextField textField = new JTextField();
		textField.setText(defaultFolder);
		textField.setAlignmentX(LEFT_ALIGNMENT);
		titlePanel.add(textField);
		this.add(titlePanel);
		
		//the actual panel
		actualPanel = new JPanel();
		
		//add button to 
		backButtonPanel = new JPanel();
		backButton = new JButton("Back");
		backButtonPanel.add(backButton);
		actualPanel.add(backButtonPanel);
		
		//add display-panel for the actual folder-view
		JTextArea folderDisplay = new JTextArea("Hier kommt der Ordnerinhalt rein...");
		actualPanel.add(folderDisplay);
		this.add(actualPanel);
		this.setLayout(layout);
		
	}
	
	
	private void setFolder(String path) {
		if (path == null) {
			path = defaultFolder;
		}
		currentFolder = path;
	}
	
}
