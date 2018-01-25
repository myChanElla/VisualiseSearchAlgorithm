package testing;

import java.util.*;

import structures_dataTypes.Node;

public class DFSAlgorithm 
{
	/**
	 * @param start node for search
	 * @param goal node to find
	 * @return goal node if found
	 */
	public Node dfs (Node start, Node goal) 
	{
			Stack<Node> frontier = new Stack<Node>();
			Set<Node> visited =  new HashSet<Node>();
			frontier.push(start);
	        while(!frontier.empty()) 
	        {
				Node x = frontier.pop();
				if(!visited.contains(x) && x.getOpen() == true) 
				{
					if (x == goal) 
					{	
						return x;
					}
					visited.add(x);
					frontier.addAll(x.getChildren());
				}
			}
		return null; //goal node not found
	}
}