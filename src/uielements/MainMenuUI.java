package uielements;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import visualisation.grid.GridMaker;

import java.awt.GridBagLayout;

/**
 * 
 * @author Chrystal - UI creation, design and re-factoring 
 *
 */
public class MainMenuUI 
{
	private static JFrame frame;
	
	public static Color backgroundcolor = CustomiseUIColours.settAsBackGroundColour();
	public static Color primarycolor = CustomiseUIColours.settAsPrimaryColour();
	public static Color accentcolor = CustomiseUIColours.setAsAccentColour();
	public static Color textcolor = CustomiseUIColours.settAsTextColour();
	/**
	 * Launch the application.
	 */
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					new MainMenuUI();
					frame.setVisible(true);
					
					//RunTree();
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public MainMenuUI() 
	{
		initialize();
	}
	
	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		
		
//---------------------------------------- Create frame with a GridBagLayout to allow components to resize dynamically ----------------------------------------
		frame = new JFrame();
		frame.getContentPane().setBackground(backgroundcolor);
		frame.setBounds(100, 100, 800, 800);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{400, 400};
		gridBagLayout.rowHeights = new int[]{400,400};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};// 1.0, 1.0};//, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1,0,1.0};//, 1.0, 1.0, 1.0, 1.0,1.0};
		frame.getContentPane().setLayout(gridBagLayout);
	

// ---------------------------------------- Create panel to store an image on ----------------------------------------
		

		
		UIButton btnTreeImage = new UIButton("");
		btnTreeImage.setImage("/imgs/Search Tree.png","/imgs/Search Tree.png", 320, 370, false );
		btnTreeImage.setGridBag(frame.getContentPane(), 1, 0, 1, 1);
		
		
		UIButton btnExit = new UIButton("");
		btnExit.setToolTipText("Exit Program");
		btnExit.setImage("/imgs/exit.png","/imgs/exitRoll.png", 320, 370, true );
		btnExit.setGridBag(frame.getContentPane(), 1, 1, 1, 1);
		
		btnExit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));;
			}
		});
					
		UIButton btnHelp = new UIButton("");
		btnHelp.setGridBag(frame.getContentPane(), 0, 1, 1, 1);
		btnHelp.setImage("/imgs/help.png","/imgs/helpRoll.png", 320, 370,true );
		btnHelp.setToolTipText("Help");
		
		
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				HelpUI.loadHelp(0);
			}
		});
		
		UIButton btnStart = new UIButton("");
		btnStart.setGridBag(frame.getContentPane(), 0, 0, 1, 1);
		btnStart.setImage("/imgs/begin.png","/imgs/beginRoll.png", 320, 370, true );
		btnStart.setToolTipText("Start Creating Search");
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				GridMaker.openUI();
				frame.setVisible(false);
			}
		});
	}
}