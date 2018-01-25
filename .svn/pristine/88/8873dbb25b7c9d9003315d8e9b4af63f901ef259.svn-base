package testing;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import structures_dataTypes.Node;
import uielements.VisualisationUI;

import java.util.ArrayList;

import visualisation.grid.GridVisualiser;

public class AstarAlgorithms 
{
	private Map<Node, Node> pathmap;
	public GridVisualiser grid = VisualisationUI.getGrid();
	
	public AstarAlgorithms()
	{
		this.pathmap = new LinkedHashMap<Node,Node>();
	}
	
	public Node astar (Node start, Node goal) 
	{
			PriorityQueue<Node> frontier = new PriorityQueue<Node>();
			Set<Node> visited = new HashSet<Node>();
			Map<Node, Double> distmap = new LinkedHashMap<Node, Double>();
			start.genHValue(goal);
			frontier.add(start);
			distmap.put(start, 0.0);
			pathmap.put(start, start);

	        while(!frontier.isEmpty()) 
	        {
				Node x = frontier.poll();
					if(!visited.contains(x) && x.getOpen())
					{
						if (x == goal) 
						{
							return x;
						}
						else
						{
							visited.add(x);
							ArrayList<Node> children = new ArrayList<Node>();
							children.addAll(x.getChildren());
							for(Node child : children)
							{
								child.genHValue(goal);
							}
							frontier.addAll(x.getChildren());
						}
					}
		        }
	        	return null;
		    }
}