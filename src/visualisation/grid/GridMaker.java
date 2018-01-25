package visualisation.grid;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

import structures_dataTypes.Coordinate;
import structures_dataTypes.GraphGenerator;
import structures_dataTypes.Node;
import uielements.CustomiseUIColours;
import uielements.MainMenuUI;
import uielements.UIButton;
import uielements.UILabel;
import uielements.UIPanel;
import uielements.VisualisationUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
/**
 * @author Ella, Creator of the UI and grid for user customisation and selection of start and goal nodes. Debugging and fixing of edge cases 
 * @author Michael Platts, Passing of data to other objects once user has selected graph to generate, Refactoring and Debugging
 * @author Chrystal Gosden, Refactoring and Debugging. GUI designer.
 * This class displays the interface where users can interact with by creating a graph and try to perform a search.
 */
public class GridMaker {

	private JFrame frame;
	private JButton b;
	
	public boolean startButton;
	public boolean goalButton;
	public boolean blockButton;
	
	public static int chosenX;
	public static int chosenY;
	public static Node start;
	public static Node end;
	public static String searchType = "Depth First Search";
	
	public static ArrayList<JButton> gridButton ; //list of Buttons
	public static ArrayList<Coordinate> gridCoord;//list of Coordinates
	public static LinkedHashMap<String,Coordinate> linkage;//links between button Name(string coordinate) and coordinate
	private static Set<Node> blockSet;
	private static ArrayList<Node> block;
	public static ArrayList<Node> obstacles;
	
	//Boolean flags for which search is selected by the user
	public boolean isDFS = false;
	public boolean isBFS = false;
	public boolean isAstar = false;
	
	public static Color backgroundcolor = CustomiseUIColours.settAsBackGroundColour();
	public static Color primarycolor = CustomiseUIColours.settAsPrimaryColour();
	public static Color accentcolor = CustomiseUIColours.setAsAccentColour();
	public static Color textcolor = CustomiseUIColours.settAsTextColour();
	
	/**
	 * Launch the application.
	 */
	public static void openUI()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GridMaker window = new GridMaker();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor of GridMaker 
	 * Create the application.
	 */
	public GridMaker() {
		initialize();
		gridCoord = new ArrayList<Coordinate>();
		linkage = new LinkedHashMap<String, Coordinate>();
		blockSet= new HashSet<>();
		block= new ArrayList<Node>();
		obstacles= new ArrayList<Node>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(backgroundcolor);
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
				
		UIManager.put("ScrollBar.thumbHighlight", Color.LIGHT_GRAY);         
		UIManager.put("ScrollBar.thumbDarkShadow", Color.LIGHT_GRAY);
		UIManager.put("ScrollBar.highlight", Color.LIGHT_GRAY);
		UIManager.put("ScrollBar.trackHighlight", Color.LIGHT_GRAY);
		UIManager.put("ScrollBar.trackHighlight", Color.LIGHT_GRAY);
		UIManager.put("ComboBox.selectionBackground", Color.LIGHT_GRAY);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40,500};
		gridBagLayout.rowHeights = new int[]{0,0};
		gridBagLayout.columnWeights = new double[]{0.5,1.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0,1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
//----------------------------------------Create GridMakerPanel which allows user to enter details to customise grid---------------		
	
		//These are the values for the grid x and y combo boxes 
		Integer[] m = {5, 6, 7, 8, 9, 10}; 
		Integer[] n = {5, 6, 7, 8, 9, 10}; 
		chosenX = chosenX+5;
		chosenY = chosenY+5;

		UIPanel gridMakerPanel = new UIPanel(primarycolor);
		gridMakerPanel.setGridBag(frame.getContentPane(),0,0,1,1, new Insets(50,5,5,5)); //Insets(50,5,5,5)
				
		GridBagLayout gbl_gridMakerPanel = new GridBagLayout();
		gbl_gridMakerPanel.columnWidths = new int[]{8,8,8,8,8};
		gbl_gridMakerPanel.rowHeights = new int[]{0, 0};
		gbl_gridMakerPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_gridMakerPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0};
		gridMakerPanel.setLayout(gbl_gridMakerPanel);
		
		UIButton btnHome = new UIButton("", backgroundcolor, accentcolor, primarycolor, textcolor);;
		btnHome.setToolTipText("Home");
		btnHome.setGridBag(gridMakerPanel, 0, 0, 1, 1);
		btnHome.setImage("/imgs/home.png", "/imgs/homeRoll.png", 100, 75, false);
		
		btnHome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
			{
								
									//open up the visualisation UI pass the search type graph start and end nodes
				    MainMenuUI.main(null);					//VisualisationUI.openUI(searchType, graph, start, end);
					frame.setVisible(false);
			}
		});

		
		
		//----------------------------------------Add label to tell the user to select a grid size---------------		
		UILabel lblSizeOfBoard = new UILabel("Size of Board: ", 16, backgroundcolor, null);
		lblSizeOfBoard.setBold();
		lblSizeOfBoard.setGridBag(gridMakerPanel, 0, 1, 1, 1);
			
		//----------------------------------------Display gridX and gridy combo boxes to allow the user to choose a grid size---------------		
		JComboBox<Integer> gridXComboBx = new JComboBox<Integer>(m);
		gridXComboBx.setToolTipText("X coordinate");
		ComboBoxSetUp(gridXComboBx, gridMakerPanel, 0, 2, 1);
			
		gridXComboBx.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent event)
					{
						if(event.getStateChange()==ItemEvent.SELECTED)
						{
							chosenX = m[gridXComboBx.getSelectedIndex()];
						}
					}
				}
		);
				
		//label indicating times
		UILabel lblX = new UILabel("X", 16, backgroundcolor, null);
		lblX.setBold();
		lblX.setGridBag(gridMakerPanel, 1, 2, 1, 1);
		
		JComboBox<Integer> gridYComboBox = new JComboBox<Integer>(n);
		gridYComboBox.setToolTipText("Y coordinate");
		ComboBoxSetUp(gridYComboBox, gridMakerPanel, 2, 2, 1);
			
		gridYComboBox.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent event)
					{
						if(event.getStateChange()==ItemEvent.SELECTED)
						{
							chosenY = n[gridYComboBox.getSelectedIndex()];							
						}
					}
				}
		);
		
		//---------------------------------- A button which creates the grid according to the comboBoxes chosen above when it is clicked-------------------
		UIButton createGridBtn = new UIButton("Create Grid", backgroundcolor, accentcolor, primarycolor, textcolor);
		createGridBtn.setToolTipText("Generate the grid");
		createGridBtn.setGridBag(gridMakerPanel, 0, 4, 4, 1);
		
		UIButton selectStartBtn = new UIButton("Select Start Node", backgroundcolor, accentcolor, primarycolor, textcolor);
		selectStartBtn.setToolTipText("Select start node of the search");
		selectStartBtn.setGridBag(gridMakerPanel, 0, 6, 4, 1);		
		
		UIButton selectGoalNodeBtn = new UIButton("Select Goal Node", backgroundcolor, accentcolor, primarycolor, textcolor);
		selectGoalNodeBtn.setToolTipText("Select the goal of the search");
		selectGoalNodeBtn.setGridBag(gridMakerPanel, 0, 7, 4, 1);
			
		JToggleButton setBlocksBtn = new JToggleButton("Set Blocks");
		setBlocksBtn.setFocusable(false);
		setBlocksBtn.setToolTipText("Select blocked nodes");
		setBlocksBtn.setFont(new Font("Helvetica", Font.BOLD, 16));
		setBlocksBtn.setBackground(backgroundcolor);
		setBlocksBtn.setForeground(primarycolor);
		GridBagConstraints gbc_setBlocksBtn = new GridBagConstraints();
		gbc_setBlocksBtn.gridwidth = 3;
		gbc_setBlocksBtn.fill = GridBagConstraints.BOTH;
		gbc_setBlocksBtn.insets = new Insets(5, 5, 5, 5);
		gbc_setBlocksBtn.gridx = 0;
		gbc_setBlocksBtn.gridy = 8;
		gbc_setBlocksBtn.gridwidth = 4;
		gbc_setBlocksBtn.gridheight = 1;
		gridMakerPanel.add(setBlocksBtn, gbc_setBlocksBtn);
		
		
		
		//Create a JPanel for the grid board   300
		UIPanel mainPanel = new UIPanel(backgroundcolor);
		mainPanel.setGridBag(frame.getContentPane(), 1, 0, 2, 2, new Insets(20, 20, 20, 20));
		
		
		//add a listener to the grid button
		createGridBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				mainPanel.removeAll();
				block.clear();
				blockSet.clear();
				obstacles.clear();
				gridCoord.clear();		
				gridButton = new ArrayList<JButton>();
				
				//set the grid layout of board + assign coordinates to them
				mainPanel.setLayout(new GridLayout(chosenY, chosenX));
				
				createGrid();				
				createGridListener();
				


				 //put the two arrays into a linked hash map for easier calling in the furure
				for(int i=0; i<gridCoord.size();i++)
				{
						linkage.put(gridButton.get(i).getActionCommand(), gridCoord.get(i));
				}
				
				mainPanel.revalidate();
				mainPanel.repaint();
			}

			/**
			 * A method which create the grid, it is in terms of buttons.
			 */
			private void createGrid() 
			{
				for(int m=0; m < chosenY ; m++)
				{
					for(int n=0; n < chosenX; n++)
					{
						b=new JButton();
						b.setBackground(Color.WHITE);
						mainPanel.add(b);
						b.setActionCommand("("+ n + "," + m + ")"); //assign string coordinate to the button
						gridButton.add(b);
						Coordinate element = new Coordinate(n,m); //create list of Coordinates according to size of board
						gridCoord.add(element);
					}
				}
			}
			
			
			/**
			 * A method which add a listener to the grid to listen to the instructions when user is interacting
			 */
			private void createGridListener() 
			{
				for(int i=0; i<gridButton.size();i++)
				{
					gridButton.get(i).addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent event)
							{
								int index = gridButton.indexOf(event.getSource());
								if(index>=0)
								{
									
									if(startButton==true)
									{
										
										if(CheckSelected(index, false) != true){
											//make sure it hasn't been chosen before
											if(start!=null)
											{
												for(int i=0; i<gridButton.size();i++)
												{
													if(gridButton.get(i).getBackground()==Color.green)
													{
														gridButton.get(i).setBackground(Color.WHITE);
													}
												}
												start=null; //set the start node back to null	
											}		
									
											gridButton.get(index).setBackground(Color.green); //set button to green
															
											Coordinate a= linkage.get(gridButton.get(index).getActionCommand());//retrieve the grid coordinate
																									
											start=new Node(a, true);//create the start Node.
															
											startButton=false;
											selectGoalNodeBtn.setEnabled(true);
											setBlocksBtn.setEnabled(true);
										}
										
									}
									
									else if(goalButton==true)
									{
										if(CheckSelected(index, false) != true){
											//make sure it hasn't been chosen before
											if(end!=null)
											{
												for(int i=0; i<gridButton.size();i++)
												{
													if(gridButton.get(i).getBackground()==Color.red)
														gridButton.get(i).setBackground(Color.WHITE);
												}
												end=null; //set the end node back to null
											}
																
											gridButton.get(index).setBackground(Color.red);//set button to red
																
											Coordinate b= linkage.get(gridButton.get(index).getActionCommand());//retrieve the grid coordinate
																								
											end=new Node(b, true);//set the goal node
														
											goalButton=false;
											selectStartBtn.setEnabled(true);
											setBlocksBtn.setEnabled(true);
											
										}
									}
									else if(blockButton==true)
									{
										if(CheckSelected(index, true) != true){
										//if selected, allow change of board
											if(setBlocksBtn.isSelected())
											{
												if(gridButton.get(index).getBackground()==Color.LIGHT_GRAY)
												{
													gridButton.get(index).setBackground(Color.WHITE);
												}
												else
												{
													gridButton.get(index).setBackground(Color.LIGHT_GRAY);
												}			
												Coordinate c = linkage.get(gridButton.get(index).getActionCommand());//retrieve the grid coordinate
												Node n= new Node(c, false);
												
												block.add(n);
												}
											else
											{
													selectStartBtn.setEnabled(true);
													selectGoalNodeBtn.setEnabled(true);
													blockButton=false;
																									
											}
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "What do you want to put here?");
									}
								}
							}
						});
					}
				
			}

				});
				
//----------------------------------user selects start node button-----------------------		
				
		selectStartBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				startButton = true;
				//set an icon ---> make sure they choose the grid first before they can choose other selection button
				selectGoalNodeBtn.setEnabled(false);
				setBlocksBtn.setEnabled(false);	
			}
		});

//---------------------------------User selects goal node button------------------------
		selectGoalNodeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				goalButton = true;
				
				selectStartBtn.setEnabled(false);
				setBlocksBtn.setEnabled(false);
			}
		});

		
//--------------------------------User selects set blocks button------------------------------		
		setBlocksBtn.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt)
            {
            	setBlocksBtn.setBackground(accentcolor);
            	setBlocksBtn.setForeground(textcolor);
            }
            public void mouseExited(MouseEvent evt)
            {
            	setBlocksBtn.setBackground(backgroundcolor);
            	setBlocksBtn.setForeground(primarycolor);
            }
            public void mousePressed(MouseEvent evt)
            {
            	setBlocksBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            }
            public void mouseReleased(MouseEvent evt)
            {
            	setBlocksBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            }
		});

		UILabel clickAgainLabel = new UILabel("<html>Click this button again<br>\r\nto deselect blocks<html>" , 16, backgroundcolor, null);
		clickAgainLabel.setBold();
		clickAgainLabel.setGridBag(gridMakerPanel, 0, 9, 4, 1);
		clickAgainLabel.setVisible(false);
		
		setBlocksBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(setBlocksBtn.isSelected())
				{
					clickAgainLabel.setVisible(true);
					blockButton=true;
					selectStartBtn.setEnabled(false);
					selectGoalNodeBtn.setEnabled(false);
				}
				else
				{
					clickAgainLabel.setVisible(false);
					selectStartBtn.setEnabled(true);
					selectGoalNodeBtn.setEnabled(true);
				}
			}
		});
		
//----------------------------------The Design of the search panel--------------------------		
		UIPanel searchPanel = new UIPanel(primarycolor);
		searchPanel.setGridBag(frame.getContentPane(), 0, 1, 1, 1, new Insets(50, 5, 50, 5));
		GridBagLayout gbl_searchPanel = new GridBagLayout();
		gbl_searchPanel.columnWidths = new int[]{0, 0};
		gbl_searchPanel.rowHeights = new int[]{0, 0};
		gbl_searchPanel.columnWeights = new double[]{1.0, 1.0,1.0};
		gbl_searchPanel.rowWeights = new double[]{1.0,1.0,1.0};
		searchPanel.setLayout(gbl_searchPanel);
	
//-----------------------------------------Start to search label-----------------------------		
																		
		UILabel searchTypeLbl = new UILabel("Search type:", 16, backgroundcolor, null);
		searchTypeLbl.setBold();
		searchTypeLbl.setGridBag(searchPanel, 0, 0, 1, 1);															
																									
//--------------------------------------------------ComboBox for choosing search methods---------------------------		
																								
		JComboBox<String> searchTypeComboBox = new JComboBox<String>();
		ComboBoxSetUp(searchTypeComboBox, searchPanel, 0, 1, 2);
		searchTypeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Depth First Search", "Breadth First Search", "A* Search"}));
																						
		searchTypeComboBox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent event) 
			{
				if(event.getStateChange()==ItemEvent.SELECTED)
				{
					Object source = event.getSource();
					if(source instanceof JComboBox)
					{
						//Set the search type to what the user has selected
						@SuppressWarnings("unchecked")
						JComboBox<String> jcb = (JComboBox<String>)source;
						searchType = (String) jcb.getSelectedItem();
					}
				}
			}
		});
			
//-------------------------------------User selects the Start Search button-----------------------------		
		UIButton startSearchBtn = new UIButton("Start Search", backgroundcolor, accentcolor, primarycolor, textcolor);
		startSearchBtn.setToolTipText("Begin the Search");
		startSearchBtn.setGridBag(searchPanel, 0, 2, 2, 1);
		
		startSearchBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					//pass the data to generate the graph for the search 
							
					//blockSet is used to keep track of each node chosen
					blockSet.addAll(block);
									
					//count the number of that elements in blocks
					//if odd-> keep -> put to final list for 
					//if even-> do nothing			
					for(Node key : blockSet)
					{
						int x = Collections.frequency(block, key);
						if(x%2 == 1)
						{
							obstacles.add(key);
							
						}
					}
					
					
						
					GraphGenerator g = new GraphGenerator();
					LinkedHashMap<Integer, Node> graph= g.genGraph(chosenX, chosenY, obstacles);
			
					//open up the visualisation UI pass the search type graph start and end nodes
					VisualisationUI.openUI(searchType, graph, start, end);
					//VisualisationUI.openUI(searchType, graph, start, end);
					frame.setVisible(false);
				}
				catch(NullPointerException e)
				{
					JOptionPane.showMessageDialog(null, "You should set a start/goal node!");
				}
			}
		});
	}

	/**
	 * This method is used to clear all the parameters so that it starts clean.
	 */
	public static void refresh() 
	{
		chosenX = 0;
		chosenY = 0;
		block.clear();
		blockSet.clear();
		obstacles.clear();
	}
	
	
	/**
	 * Method to configure the design of the combo box
	 * @para gridComboBox	- the default combobox
	 * @para panel			- the JPanel which the combobox is put onto
	 * @para x				- Specifies the cell containing the leading edge of the component's display area
	 * @para y				- Specifies the cell containing the leading edge of the component's display area
	 * @para width			- Specifies the number of cells in a row for the component's display area
	 */
	public static void ComboBoxSetUp(@SuppressWarnings("rawtypes") JComboBox gridComboBox, JPanel panel,int x, int y, int width){
	
		
		gridComboBox.setFocusable(false);
		gridComboBox.setFont(new Font("Helvetica", Font.BOLD, 16));
		gridComboBox.setBackground(accentcolor);
		gridComboBox.setForeground(backgroundcolor);
		gridComboBox.setBorder(BorderFactory.createLineBorder(backgroundcolor));
		GridBagConstraints gbc_gridComboBox = new GridBagConstraints();
		gbc_gridComboBox.insets = new Insets(5, 5, 5, 5);
		gbc_gridComboBox.gridwidth = width;
		gbc_gridComboBox.gridx = x;
		gbc_gridComboBox.gridy = y;
		panel.add(gridComboBox, gbc_gridComboBox);
		
		
		
	}
	
	/**
	 * This is a check to see if the user is trying to place a block or start or goal node in a already selected space
	 * @param index - The index of the button on the grid being selected 
	 * @param isBlock - Is the space being selected already a block node if so cannot be replaced by a goal or a start node but can be turned off
	 * @return - True or False depending if this block has been selected before
	 */
	public boolean CheckSelected(int index, boolean isBlock)
	{
		if(isBlock == true)
		{
			if(gridButton.get(index).getBackground()==Color.white || gridButton.get(index).getBackground()==Color.LIGHT_GRAY)
			{
					return false;
			}
		}
		if(gridButton.get(index).getBackground()==Color.white)
			{
					return false;
			}
		
			
		return true;
	}
	
}