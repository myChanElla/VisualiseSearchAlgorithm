package testing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import structures_dataTypes.Node;

public class BFSAlgorithm 
{
	/**
	 * Method for carrying out Breadth First Search
	 * @param start, the root node
	 * @param goal, the target node
	 **/
	public Node bfs (Node start, Node goal)
	{
			Queue<Node> frontier = new LinkedList<Node>();
			Set<Node> visited =  new HashSet<Node>();

			frontier.add(start);

			while(!frontier.isEmpty()) 
	        {
				Node x = frontier.poll();
				if(!visited.contains(x) && x.getOpen() == true) 
				{
					if (x == goal)
					{ 
						return x; // Goal Node found
					}
					visited.add(x);
					frontier.addAll(x.getChildren()); 
				}
			}
	   	return null; //goal node not found 
	}
}