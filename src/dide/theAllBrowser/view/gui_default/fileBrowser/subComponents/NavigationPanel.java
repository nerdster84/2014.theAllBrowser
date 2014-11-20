package dide.theAllBrowser.view.gui_default.fileBrowser.subComponents;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import dide.theAllBrowser.controller.fileBrowser.IController;
import dide.theAllBrowser.util.observer.Event;
import dide.theAllBrowser.util.observer.IObserver;
import dide.theAllBrowser.view.Layout;

public class NavigationPanel extends JPanel implements IObserver{

	IController controller;
	LayoutManager layout;
	JButton backButton,
			newExplorer,
			selectDir, 
			rootDir,
			quickChoseFromFavorites,
			fav1,
			fav2;
	
	
	public NavigationPanel(IController controller) {
		//this.controller = controller;
		//this.controller.addObserver(this);
		buildPanel();
	}
	
	private void buildPanel() {
		//layout = new BoxLayout(this, BoxLayout.X_AXIS);
		layout = new GridLayout(1,10); 
		
		this.setLayout(layout);
		backButton = new JButton("back");
		newExplorer  = new JButton("newExplorer");
		selectDir  = new JButton("selectDir");
		rootDir  = new JButton("rootDir");
		quickChoseFromFavorites  = new JButton("quickChoseFavs");
		fav1  = new JButton("fav1");
		fav2  = new JButton("fav2");

		this.add(backButton);
		this.add(newExplorer);
		this.add(selectDir);
		this.add(rootDir);
		this.add(quickChoseFromFavorites);
		this.add(fav1);
		this.add(fav2);
//		this.setPreferredSize(Layout.DIM_NAVIGATIONPANEL_STD);
//		this.setMinimumSize(Layout.DIM_NAVIGATIONPANEL_STD);
//		this.setMaximumSize(Layout.DIM_EXPLORERPANEL_BIG);
//		this.setBorder(Layout.BORDER_PANEL_NAVIGATIONPANEL);
		this.setVisible(true);
	}

	@Override
	public void update(Event e) {

		
	}
}
