package dide.theAllBrowser.view.gui_default;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;

import dide.theAllBrowser.application.First;
import dide.theAllBrowser.model.Module;
import dide.theAllBrowser.view.*;
import dide.theAllBrowser.view.gui_default.fileBrowser.FileBrowser;
import dide.theAllBrowser.view.layouts.LayoutCreator;
import dide.theAllBrowser.util.observer.Event;
import dide.theAllBrowser.util.observer.IObserver;

public class Gui_Default extends JFrame implements IObserver{
	private static JFrame mainWindow;
	private static LayoutManager layout; 
	private Dimension size_min,
						size_max,
						size_pref;

	//Constructor
	private Gui_Default() {
		//create mainWindow
		mainWindow = new JFrame("TheAllBrowser");
		mainWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);	
		layout = new GridBagLayout();
		mainWindow.setLayout(layout);
		size_pref = Layout.DIM_GUIDEFAULT_STD;
		size_min = Layout.DIM_GUIDEFAULT_SMALL;
		size_max = Layout.DIM_GUIDEFAULT_BIG;
		mainWindow.setPreferredSize(size_pref);
		mainWindow.setMinimumSize(size_min);
		mainWindow.setMaximumSize(size_max);
		
		//Add Modules to mainWindow
		Module fileBrowser = new FileBrowser("File Browser");
		GridBagConstraints constraints_fileBrowser = new GridBagConstraints();
//		constraints_fileBrowser.gridwidth = 1;
//		constraints_fileBrowser.gridheight = 1;
		mainWindow.getContentPane().add(fileBrowser, constraints_fileBrowser);
		
		//repaint();
		mainWindow.setVisible(true);
		validate();
		//pack();
	}

	public static JFrame getInstance() {
		if (mainWindow != null) {
			return(mainWindow);
		} else {
			return(new Gui_Default());
		}
	}
	
	@Override
	public void update(Event e) {
		getInstance().validate();
	}
}

