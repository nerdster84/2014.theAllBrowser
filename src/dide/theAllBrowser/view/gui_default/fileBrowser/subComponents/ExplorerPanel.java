package dide.theAllBrowser.view.gui_default.fileBrowser.subComponents;

import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dide.theAllBrowser.controller.fileBrowser.IController;
import dide.theAllBrowser.controller.fileBrowser.impl.Controller;
import dide.theAllBrowser.util.observer.Event;
import dide.theAllBrowser.util.observer.IObserver;
import dide.theAllBrowser.view.Layout;


/**
 * Panel for one folder-explorer. to be added to an explorer-display-panel or smth like ditte 
 */
public class ExplorerPanel extends JPanel implements IObserver{

	private IController controller;
	private LayoutManager layout;
	private JPanel titlePanel,
					actualPanel,
					backButtonPanel, 	//Panel for button for cd ..
					openNewExplorer,		
					display;		//shows folder's content
	private JButton backButton;		//cd ..
	JTextField textField_title;		//display's the path of currentDir
//	private String 	currentFolder,
//	defaultFolder;
	
	//Constructor
	public ExplorerPanel(IController controller) {
			this.controller = controller;
			buildPanel();
			controller.setCurrentFolder(controller.getDefaultFolder());
			this.controller.addObserver(this);
			this.controller.setCurrentFolder(controller.getDefaultFolder());
			this.setSize(Layout.DIM_EXPLORERPANEL_STD);
			this.setMaximumSize(Layout.DIM_MAX);
			this.setMinimumSize(Layout.DIM_EXPLORERPANEL_SMALL);
			this.setBorder(Layout.BORDER_PANEL_EXPLORERPANEL);
			validate();
	}
	
	//method to actually build the whole ExplorerPanel-object
	private void buildPanel() {
		this.setLayout(new GridBagLayout());

		//add title-line: displays path of current working directory
		textField_title = new JTextField();
		textField_title.setText(controller.getCurrentFolder());
		textField_title.setEditable(false);
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.PAGE_START; 
		this.add(textField_title, gc);

		//this panel contains all elements except for the title-panel
		actualPanel = new JPanel();
		actualPanel.setLayout(new GridBagLayout());		
		
		//add button to 
		backButtonPanel = new JPanel();
		backButton = new JButton("Back");
		backButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				String path = controller.getCurrentFolder();
				File parent = new File(path);
				parent = parent.getParentFile();
				path = parent.toString();
				controller.setCurrentFolder(path);
				controller.notifyObservers();
			} });	
		
		backButtonPanel.add(backButton);
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
		File dir = new File(controller.getCurrentFolder());
		folderDisplay.setText(controller.getFilesOfDir(controller.getCurrentFolder()));
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

	@Override
	public void update(Event e) {
		
		//textField_title.setText(controller.getCurrentFolder());
		textField_title.setText("aovijsdiofjdsiofjifj");
		repaint();
	}
	
}
