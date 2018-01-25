package search_algorithms;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import structures_dataTypes.Node;
import structures_dataTypes.Node.ColorChoice;
import uielements.VisualisationUI;
import visualisation.datastructure.DataStructHelper;
import visualisation.grid.GridVisualiser;
import visualisation.pseudocode.PseudoCodeGen;
import visualisation.pseudocode.PseudoCodeStrings;

/**
 * @author Michael Platts
 * The Breadth first search algorithm
 */
public class BFS 
{
	PseudoCodeGen pseudoGen = new PseudoCodeGen(); // Generator for strings displayed in the pseudoCode text area 
	PseudoCodeStrings pseudoStrings = new PseudoCodeStrings(); // The strings that will be displayed as pseudo code
	private int speed = 1000; // The time the algorithm will sleep for between each step to control the speed
	private GridVisualiser grid = VisualisationUI.getGrid(); // The grid visualisation 
	DataStructHelper dataStructHelper = new DataStructHelper(); // The data structure visualisation
	
	public BFS(){
	}
	
	/**
	 * Method for carrying out Breadth First Search
	 * @param start, the root node
	 * @param goal, the target node
	 **/
	public Node bfs (Node start, Node goal)
	{
		try
		{
			//set start and goal node colours in javafx thread
			Platform.runLater(new Runnable() { 
	            @Override
	            public void run() {
	            	start.setColor(ColorChoice.START);
	            }
	        });
			
			pseudoGen.addPseudoText("Starting Breadth First Search ... \n");
			TimeUnit.MILLISECONDS.sleep(speed);
			Queue<Node> frontier = new LinkedList<Node>();
			pseudoGen.addPseudoText("Creating LinkedList&lt;Node&gt; frontier \n");
			Set<Node> visited =  new HashSet<Node>();
			pseudoGen.addPseudoText("Creating HashSet&lt;Node&gt; visited \n");
			TimeUnit.MILLISECONDS.sleep(speed);

			frontier.add(start);
			pseudoGen.addPseudoText("<font color=\"green\">" +pseudoStrings.addNode + start.toString() + "\n</font>");
			dataStructHelper.createNode(start);
			TimeUnit.MILLISECONDS.sleep(speed);
			pseudoGen.addPseudoText(pseudoStrings.whileLoop);
	        while(!frontier.isEmpty()) 
	        {
	        	// Check the next node in the queue
				Node x = frontier.poll();
				if(x != start && x != goal && x.getOpen())
				{
					//Change node colour in the grid visualisation 
					grid.changeColour(x.coord);
					
				}				
				pseudoGen.addPseudoText("<font color=\"red\">" +pseudoStrings.pollNode + x.toString() + "\n</font>");
				dataStructHelper.removeNode(x);
				TimeUnit.MILLISECONDS.sleep(speed);
				// Check the node hasn't already been visited and isn't blocked in the graph.
				if(!visited.contains(x) && x.getOpen() == true) 
				{
					pseudoGen.addPseudoText("Node " + x.toString() + pseudoStrings.visitable + "\n");
					if (x == goal)
					{ 
						TimeUnit.MILLISECONDS.sleep(speed);
						pseudoGen.addPseudoText("<font color=\"green\">" +x.toString() + pseudoStrings.doesEqual + "}" + "\n</font>");
						pseudoGen.addPseudoText("<font color=\"green\">" +pseudoStrings.completed + "</font>");
						Platform.runLater(new Runnable() { 
				            @Override
				            public void run() {
				    			goal.setColor(ColorChoice.GOAL);	
				            }
				        });
						return x; 
					}
					pseudoGen.addPseudoText("<font color=\"red\">" +x.toString() + pseudoStrings.notEqual + "\n</font>");
					TimeUnit.MILLISECONDS.sleep(speed);
					pseudoGen.addPseudoText(pseudoStrings.addVisited + x.toString() + "\n");
					visited.add(x);
					if (x != start){
						//set node colour in jfx thread
						Platform.runLater(new Runnable() { 
				            @Override
				            public void run() {
				            	x.setColor(ColorChoice.VISITED);
				            }
				        });
					}
					TimeUnit.MILLISECONDS.sleep(speed);
					pseudoGen.addPseudoText("<font color=\"green\">" +pseudoStrings.addChildren + x.toString() + "\n</font>");
					Set<Node> children = x.getChildren();
					Iterator<Node> it = children.iterator();
					while(it.hasNext()){
						Node next = it.next();
						if(!visited.contains(next)){
							frontier.add(next);
							dataStructHelper.createNode(next);
							Thread.sleep(200);
							Platform.runLater(new Runnable() { 
					            @Override
					            public void run() {
					            	next.setSearchParent(x);
					            }
					        });
							
						}
					}
				}else{
					if(visited.contains(x))
						pseudoGen.addPseudoText("Node " + x.toString() + pseudoStrings.alreadyVisited + "\n");
					else
						pseudoGen.addPseudoText("Node " + x.toString() + pseudoStrings.notTraversable + "\n");
				}
			}
	        pseudoGen.addPseudoText("<font color=\"red\">" +pseudoStrings.failed + "</font>");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return null; //goal node not found 
	}
	
	/**
	 * Sets the time the algorithm should wait for to adjust the speed
	 * @param s, the new speed value
	 */
	public void setSpeed(int s)
	{
		speed = s;
	}
}
