package dide.theAllBrowser.model;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Module extends JPanel{
	
	private Color color_background;
	private Color color_frame;
	private Color color_font;
	private String title;
	
	
	public Module() {
		new Module("");
	}
	
	public Module(String title) {
		super();
		this.title = title;
		setName(title);
		color_background = Color.WHITE;
		color_font = Color.BLACK;
		color_frame = Color.BLACK;
		this.setBackground(color_background);
		this.setForeground(color_font);
		
	}

//	protected void addSubPanel(Object type) {
//	}

}
