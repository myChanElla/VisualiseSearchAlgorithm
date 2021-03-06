package uielements;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Color;

/**
 * 
 * @author Chrystal
 *
 */
public class HelpUI {
	// Frame used to visualise the help pages
	private JFrame frame;
	public static Color backgroundcolor = CustomiseUIColours.settAsBackGroundColour();
	public static Color primarycolor = CustomiseUIColours.settAsPrimaryColour();
	public static Color accentcolor = CustomiseUIColours.setAsAccentColour();
	public static Color textcolor = CustomiseUIColours.settAsTextColour();
	// Help page number to be displayed
	private static int pageNumber;
	/**
	 * Launch the application.
	 * @param selectedPage, the help page number that has to be displayed
	 */
	public static void loadHelp(int selectedPage){
		pageNumber = selectedPage;
		// Put this on a separate thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpUI window = new HelpUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelpUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
// ----------------------------------------Create Frame with gridBagLayout in order to allow components to resize ----------------------------------------
		
		frame = new JFrame();
		frame.getContentPane().setBackground(backgroundcolor);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100,400,400,100};
		gridBagLayout.rowHeights = new int[]{70,70,540,60,60};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0,1.0,1.0,1.0,1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
//---------------------------------------- Add Title label to frame ----------------------------------------  		
		
		UILabel lblHelp = new UILabel("Help", 30, backgroundcolor, primarycolor);
		lblHelp.setGridBag(frame.getContentPane(), 0, 0, 4, 1);
		
		
// --------------------------------------- Information Label to tell the user what the information is showing ------------------
		String[] info = new String[5];
		
		info[0] = "How to Create a Grid";
		info[1] = "Visualisation Page";
		info[2] = "What is DFS?";
		info[3] = "What is BFS?";
		info[4] = "What is A* Search?";
		
		UILabel lblInfo = new UILabel(info[pageNumber], 26, backgroundcolor, primarycolor);
		lblInfo.setGridBag(frame.getContentPane(),2,1, 1,1);

							
//---------------------------------------- Add Help image label to frame ----------------------------------------  		
			
		String[] helpImages = new String[5];
		helpImages[0] = "/imgs/helpCreateGrid.png";
		helpImages[1] = "/imgs/visualisationPage.png";
		helpImages[2] = "/imgs/DFS.png";
		helpImages[3] = "/imgs/BFS.png";
		helpImages[4] = "/imgs/ASearch.png";
		
		
		UILabel lblHelpImage = new UILabel("", 0, null, null);
		lblHelpImage.setIcon(new ImageIcon(HelpUI.class.getResource(helpImages[pageNumber]))); // Original help image to be displayed
		lblHelpImage.setGridBag(frame.getContentPane(), 1, 2, 2, 1);
		
//---------------------------------------- Add Next button to frame ----------------------------------------  
			
		UIButton btnNext = new UIButton("Next ->");
		btnNext.setGridBag(frame.getContentPane(), 2, 3, 1, 1);
		
			UIButton btnBack = new UIButton("<- Back");
		btnBack.setGridBag(frame.getContentPane(), 1, 3, 1, 1);	
		
		btnNext.addActionListener(new ActionListener() {		// Takes user to the next help image
			public void actionPerformed(ActionEvent arg0) 
			{
				if (pageNumber < 4)
				{
					pageNumber++;
					lblInfo.setText(info[pageNumber]);
					lblHelpImage.setIcon(new ImageIcon(HelpUI.class.getResource(helpImages[pageNumber])));
					btnNext.setEnabled(true);
					btnBack.setEnabled(true);
					
				}
				else{
					btnBack.setEnabled(true);
					btnNext.setEnabled(false);
				}
			}
		});
		
//---------------------------------------- Add Back button to frame ----------------------------------------  		
		
	
			
		btnBack.addActionListener(new ActionListener() {	//Takes user to previous image
			public void actionPerformed(ActionEvent arg0) 
			{
				if (pageNumber > 0)
				{
					pageNumber--;
					lblInfo.setText(info[pageNumber]);
					lblHelpImage.setIcon(new ImageIcon(HelpUI.class.getResource(helpImages[pageNumber])));
					btnBack.setEnabled(true);
					btnNext.setEnabled(true);
				}
				else{
					btnNext.setEnabled(true);
					btnBack.setEnabled(false);
				}
			}
		});


//---------------------------------------- Add Close button to frame ----------------------------------------  		
		
		UIButton btnClose = new UIButton("Close");
		btnClose.setGridBag(frame.getContentPane(),3,4,1,1);
						
		btnClose.addActionListener(new ActionListener() { // Close HelpUI window
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
	
		
		
	}	
}
