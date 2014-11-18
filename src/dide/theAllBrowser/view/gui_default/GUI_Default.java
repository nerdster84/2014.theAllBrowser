package dide.theAllBrowser.view.gui_default;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

import dide.theAllBrowser.application.First;
import dide.theAllBrowser.model.Module;
import dide.theAllBrowser.view.*;
import dide.theAllBrowser.view.gui_default.fileBrowser.FileBrowser;
import dide.theAllBrowser.view.layouts.LayoutCreator;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;


//LISTENER NOCH EINBAUEN!!

public class GUI_Default extends JFrame implements MouseListener, Observer{
	
	private MouseListener mouseListener = createMouseListener();
	private static JFrame mainWindow;
	private static LayoutManager layout; 
	
	private GUI_Default() {
		//create mainWindow
		mainWindow = new JFrame("TheAllBrowser");
		mainWindow.setSize(Layout.SIZE_PROGRAM_X_AXIS, Layout.SIZE_PROGRAM_Y_AXIS);
		mainWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);	
		//mainWindow.addMouseListener(createMouseListener());
		mainWindow.addMouseListener(mouseListener);
		
		layout = LayoutCreator.getLayout_Grid_Default(); 
		mainWindow.setLayout(layout);
		
		//Add Modules to mainWindow
		Module fileBrowser = new FileBrowser("File Browser");
		GridBagConstraints constraints_fileBrowser = new GridBagConstraints();
		mainWindow.getContentPane().add(fileBrowser, constraints_fileBrowser);
		
		//repaint();
		//pack
		mainWindow.setVisible(true);
		validate();
	}

	public static JFrame getInstance() {
		if (mainWindow != null) {
			return(mainWindow);
		} else {
			return(new GUI_Default());
		}
	}
	
	public void update() {
		getInstance().validate();
	}

	
	private MouseListener createMouseListener() {
		MouseListener listener = new MouseListener() {
			
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
				update();
			}
		};
		return listener;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

