package dide.theAllBrowser.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Layout {
	
	//SIZES
	//size of the main program
	public static final int SIZE_PROGRAM_STD_X_AXIS = 1200;
	public static final int SIZE_PROGRAM_STD_Y_AXIS = 600;
	public static final int SIZE_PROGRAM_SMALL_X_AXIS = 600;
	public static final int SIZE_PROGRAM_SMALL_Y_AXIS = 400;
	public static final int SIZE_PROGRAM_BIG_X_AXIS = 1600;
	public static final int SIZE_PROGRAM_BIG_Y_AXIS = 1200;
	//ExplorerPanel (=panel for viewing the directory of an folder with back-button)
	public static final int SIZE_EXPLORERPANEL_STD_X_AXIS = 250;
	public static final int SIZE_EXPLORERPANEL_STD_Y_AXIS = 300;
	public static final int SIZE_EXPLORERPANEL_SMALL_X_AXIS = 100;
	public static final int SIZE_EXPLORERPANEL_SMALL_Y_AXIS = 100;
	public static final int SIZE_EXPLORERPANEL_BIG_X_AXIS = 400;
	public static final int SIZE_EXPLORERPANEL_BIG_Y_AXIS = 400;
	//size of the textfield in the explorerpanel
	public static final int SIZE_TEXTFIELD_STD_X_AXIS = 3/4 * SIZE_EXPLORERPANEL_STD_X_AXIS;
	public static final int SIZE_TEXTFIELD_STD_Y_AXIS = 3/4 * SIZE_EXPLORERPANEL_STD_Y_AXIS;
	public static final int SIZE_TEXTFIELD_SMALL_X_AXIS = 3/4 * SIZE_EXPLORERPANEL_SMALL_X_AXIS;
	public static final int SIZE_TEXTFIELD_SMALL_Y_AXIS = 3/4 * SIZE_EXPLORERPANEL_SMALL_Y_AXIS;
	public static final int SIZE_TEXTFIELD_BIG_X_AXIS = 3/4 * SIZE_EXPLORERPANEL_BIG_X_AXIS;
	public static final int SIZE_TEXTFIELD_BIG_Y_AXIS = 3/4 * SIZE_EXPLORERPANEL_BIG_Y_AXIS;
	
//	public static final int SIZE_NAVIGATIONPANEL_STD_Y = ;
//	public static final int SIZE_NAVIGATIONPANEL_SMALL_Y = ;
//	public static final int SIZE_NAVIGATIONPANEL_BIG_Y = ;
	
	
	//DIMENSIONS
	
	public static final Dimension DIM_MAX = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
	public static final Dimension DIM_GUIDEFAULT_STD = new Dimension(SIZE_PROGRAM_STD_X_AXIS, SIZE_PROGRAM_STD_Y_AXIS);
	public static final Dimension DIM_GUIDEFAULT_SMALL = new Dimension(SIZE_PROGRAM_SMALL_X_AXIS, SIZE_PROGRAM_SMALL_Y_AXIS);
	public static final Dimension DIM_GUIDEFAULT_BIG = new Dimension(SIZE_PROGRAM_BIG_X_AXIS, SIZE_PROGRAM_BIG_Y_AXIS);
	public static final Dimension DIM_EXPLORERPANEL_STD= new Dimension(SIZE_EXPLORERPANEL_STD_X_AXIS, SIZE_EXPLORERPANEL_STD_Y_AXIS);
	public static final Dimension DIM_EXPLORERPANEL_SMALL= new Dimension(SIZE_EXPLORERPANEL_SMALL_X_AXIS, SIZE_EXPLORERPANEL_SMALL_Y_AXIS);
	public static final Dimension DIM_EXPLORERPANEL_BIG= new Dimension(SIZE_EXPLORERPANEL_BIG_X_AXIS, SIZE_EXPLORERPANEL_BIG_Y_AXIS);
//	public static final Dimension DIM_NAVIGATIONPANEL_STD= new Dimension(SIZE_PROGRAM_STD_X_AXIS, SIZE_PROGRAM_STD_Y_AXIS);
//	public static final Dimension DIM_NAVIGATIONPANEL_SMALL= new Dimension(SIZE_PROGRAM_SMALL_X_AXIS, si);
//	public static final Dimension DIM_NAVIGATIONPANEL_BIG= new Dimension(SIZE_PROGRAM_BIG_X_AXIS, );
	
	public static final Dimension DIM_TEXTFIELD_STD = new Dimension(SIZE_TEXTFIELD_STD_X_AXIS, SIZE_TEXTFIELD_STD_X_AXIS);
	public static final Dimension DIM_TEXTFIELD_SMALL = new Dimension(SIZE_TEXTFIELD_SMALL_X_AXIS, SIZE_TEXTFIELD_SMALL_Y_AXIS);
	public static final Dimension DIM_TEXTFIELD_BIG = new Dimension(SIZE_TEXTFIELD_BIG_X_AXIS, SIZE_TEXTFIELD_BIG_Y_AXIS);
	
	
//	public static final Dimension GUIDEFAULT_size_min = DIM_GUIDEFAULT;
//	public static final Dimension GUIDEFAULT_size_max = DIM_GUIDEFAULT;
//	public static final Dimension GUIDEFAULT_size_pref = DIM_GUIDEFAULT;
//	public static final Dimension EXPLORERPANEL_size_min = DIM_EXPLORERPANEL_SMALL;
//	public static final Dimension EXPLORERPANEL_size_max = DIM_EXPLORERPANEL_STD;
//	public static final Dimension EXPLORERPANEL_size_pref = DIM_EXPLORERPANEL_BIG;
//	public static final Dimension DIM_NAVIGATIONPANEL_STDsize_min = DIM_NAVIGATIONPANEL_STD;
//	public static final Dimension DIM_NAVIGATIONPANEL_STDsize_max = DIM_NAVIGATIONPANEL_STD;
//	public static final Dimension DIM_NAVIGATIONPANEL_STDsize_pref = DIM_NAVIGATIONPANEL_STD;
	
	//FRAME-STUFF
	public static final Border BORDER_STD = BorderFactory.createLineBorder(Color.BLACK, 2);
	public static final Border BORDER_ATTENTION = BorderFactory.createLineBorder(Color.RED, 4);
	//BORDERS FOR THE DIFFERENT PANELS TO BE ABLE TO SEE THEM EASILY
	public static final Border BORDER_PANEL_GUIDEFAULT = BorderFactory.createLineBorder(Color.BLACK, 2);
	public static final Border BORDER_PANEL_FILEBROWSER = BorderFactory.createLineBorder(Color.red, 2);
	public static final Border BORDER_PANEL_UPPERHALF = BorderFactory.createLineBorder(Color.cyan, 2);
	public static final Border BORDER_PANEL_LOWERHALF = BorderFactory.createLineBorder(Color.green, 2);
	public static final Border BORDER_PANEL_EXPLORERPANEL = BorderFactory.createLineBorder(Color.blue, 2);
	public static final Border BORDER_PANEL_NAVIGATIONPANEL = BorderFactory.createLineBorder(Color.yellow, 2);

	//COLORS
	public static final Color COL_BORDERS = Color.BLACK;
	public static final Color COL_BACKGROUND = Color.blue;
	public static final Color COL_FONT = Color.BLACK;
}
