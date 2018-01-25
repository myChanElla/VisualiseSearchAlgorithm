package uielements;
import search_algorithms.Astar;
import search_algorithms.BFS;
import search_algorithms.DFS;
import structures_dataTypes.Node;

/**
 * VisualisationController controls the running of the algorithm e.g speed.
 * Runs the algorithm on a new thread separate from the thread running the GUI.
 * @author Michael Platts
 *
 */
public class VisualisationController implements Runnable
{
	String searchType; // The search type selected by the user
	Node start; // The node where the search should start 
	Node goal; // The node the search is trying to find
	DFS s1; // Depth first search object
	BFS s2; // Breadth first search object
	Astar s3; // A* search object
	
	
	/**
	 * Constructor of the class
	 * @param search	- The type of search chosen
	 * @param start		- The start node
	 * @param goal		- The goal node
	 */
	public VisualisationController(String search, Node start, Node goal)
	{
		searchType = search;
		this.goal = goal;
		this.start = start;
	}
	
	@Override
	public void run() 
	{
			beginSearch(searchType, start, goal);
	}
	
	/**
	 * Begin the search on a new thread
	 * @param search	- The type of search chosen 
	 * @param start		- The start node
	 * @param goal		- The goal node
	 */
	public void beginSearch(String search, Node start, Node goal) 
	{
		//Switch based upon what search type has been chosen
		if(search == "Depth First Search")
		{
			DFS dfs = new DFS();
			s1 = dfs;
			dfs.dfs(start, goal);
		}
		else if(search == "Breadth First Search")
		{
			BFS bfs = new BFS();
			s2 = bfs;
			bfs.bfs(start, goal);
		}
		else if(search == "A* Search")
		{
			Astar astar = new Astar();
			s3 = astar;
			astar.astar(start, goal);
		}
	}
	
	/**
	 * Method to change the speed of the search
	 * @param speed
	 */
	public void changeSpeed(int speed)
	{
		if(searchType == "Depth First Search" && s1 != null)
		{
			s1.setSpeed(speed);
		}
		else if(searchType == "Breadth First Search" && s2 != null)
		{
			s2.setSpeed(speed);
		}
		else if(searchType == "A* Search" && s3 != null)
		{
			s3.setSpeed(speed);
		}
	}
}

