package visualisation.grid;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import structures_dataTypes.Coordinate;
import structures_dataTypes.Node;
/**
 * @author Michael Platts, Creation of panel and painting the components as well as methods to paint components correctly based on there type.
 * @author Ella, Algorithm to generate grid to correct size based on user selection.
 * This class simulates the grid created by user and is displayed on the VisualisingUI panel using the custom NodeSquare JComponent
 */
public class GridVisualiser extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public int x;	
	public int y;
	public Node start;	
	public Node goal;	
	public ArrayList<Node> nonTraversable ;
	public ArrayList<Coordinate> nodeSquares = new ArrayList<Coordinate>();
	
	/**
	 * Constructor of GridVisualiser class
	 * x - the horizontal size of the grid
	 * y- the vertical size of the grid
	 * start - the start node of the search
	 * goal - the goal node of the search
	 * nonTraversable - the array list of nodes that can't be searched
	 */
	public GridVisualiser()
	{
		this.x = GridMaker.chosenX; 
		this.y = GridMaker.chosenY;
		this.start = GridMaker.start;
		this.goal = GridMaker.end;
		this.nonTraversable = GridMaker.obstacles;
	}
	
	/**
	 * This method draws the grid according to users' input
	 * @param g	- The graphics object we are drawing on
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//the width and height of the component
		int width = getWidth();
		int height = getHeight();
		
		//the width and height of each cell
		int cellWidth = width/x;
		int cellHeight = height/y;
		
		//draw the grid
		for(int i=0; i < x; i++)
		{
			for (int j=0; j < y; j++)
			{
				Coordinate c = new Coordinate(i,j);
				NodeSquare square = new NodeSquare(c);
				square.setBounds(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
				square.changeColour(Color.WHITE);
				add(square);
				
				//Change the colour of the start node
				if(i==start.getCoord().getX())
				{
					if(j==start.getCoord().getY())
					{
						square.changeColour(Color.green);
					}
				}
				
				//Change the colour of the goal node
				if(i==goal.getCoord().getX())
				{
					if(j==goal.getCoord().getY())
					{
						square.changeColour(Color.red);
					}
				}
				
				//Change the colour of the nodes that can't be searched
				for(int m=0; m<nonTraversable.size(); m++)
				{
					if(nonTraversable.get(m).getCoord().getX()==i)
					{
						if(nonTraversable.get(m).getCoord().getY()==j)
						{
							square.changeColour(Color.LIGHT_GRAY);
						}
					}
				}
				
				//Change the colour of the nodes that have been searched
				if(nodeSquares.contains(square.coord))
				{
					square.changeColour(new Color(0, 162, 232));
				}
			}
		}
	}
	
	/**
	 * repaint the component when a change is made
	 */
	public void change()
	{
		repaint();
	}
	
	/**
	 * Add searched node to list and re-validate UI to show the change
	 * @param c	- The coordinate which is searched
	 */
	public void changeColour(Coordinate c)
	{
		nodeSquares.add(c);
		revalidate();
	}
	
	/**
	 * Return the list of node coordinates which are traversable
	 * @return an arrayList of Coordinates
	 */
	public ArrayList<Coordinate> getNodesList()
	{
		return nodeSquares;
	}	
}
