package structures_dataTypes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/**
 * This class populates nodes which are traversable and expand it's children nodes.
 * Generates a full linked hash map that can be used for searching. 
 * @author Michael Platts
 *
 */
public class GraphGenerator 
{
	public LinkedHashMap<Integer, Node> graph = new LinkedHashMap<Integer, Node>();
	
	/**
	 * Generates the linked hash map populated with nodes that will be searched
	 * @param x				- Number of rows
	 * @param y				- Number of columns
	 * @param closedNodes	- Nodes of nodes which are not traversable
	 * @return				- List of nodes to be searched
	 */
	public LinkedHashMap<Integer, Node> genGraph(int x, int y, ArrayList<Node> closedNodes)
	{
		for(int i = 0; i<x; i++)
		{
			for(int j = 0; j<y; j++)
			{
				Coordinate c = new Coordinate(i, j);
				Node node = new Node(c, true);
				if(graph.get(node.getCoord().genHash()) == null)
				{
					graph.put(c.genHash(), node);
				}
			}
		}
		for(int i = 0; i<x; i++)
		{
			for(int j=0; j<y; j++)
			{
				Coordinate c = new Coordinate(i,j);
				genChildren(graph.get(c.genHash()), x, y);
			}
		}
		setClosed(closedNodes);
		return graph;
	}
	
	/**
	 * Generates all of the child nodes from the current node as long as they do not exceed the size of the grid
	 * @param xbound the largest size of the x coordinate of the grid
	 * @param ybound the largest size of the y coordinate of the grid
	 */
	public void genChildren(Node parent, int xbound, int ybound) 
	{
		int parentx = parent.getCoord().getX();
		int parenty = parent.getCoord().getY();

		/**
		 * 	   [ ]
		 * [ ] [N] [x]	
		 * 	   [ ]
		 */
		if((parentx + 1) <= xbound)
		{
			Coordinate c = new Coordinate((parentx+1), parenty);
			Node child = graph.get(c.genHash());
			if(child != null)
			{
				parent.addChild(child);
				child.setParent(parent);
			}
		}
		
		/**
		 * 	   [ ]
		 * [ ] [N] [ ]	
		 * 	   [x]
		 */
		if((parenty + 1) <= ybound)
		{
			Coordinate c = new Coordinate(parentx, (parenty+1));
			Node child = graph.get(c.genHash());
			if(child != null)
			{
				parent.addChild(child);
				child.setParent(parent);
			}
		}
		
		/**
		 * 	   [ ]
		 * [x] [N] [ ]	
		 * 	   [ ]
		 */		
		if((parentx - 1) >= 0)
		{
			Coordinate c = new Coordinate((parentx-1), parenty);
			Node child = graph.get(c.genHash());
			if(child != null)
			{
				parent.addChild(child);
				child.setParent(parent);
			}
		}
	
		/**
		 * 	   [x]
		 * [ ] [N] [ ]	
		 * 	   [ ]
		 */
		if((parenty - 1) >= 0)
		{
			Coordinate c = new Coordinate(parentx, (parenty-1));
			Node child = graph.get(c.genHash());
			if(child != null)
			{
				parent.addChild(child);
				child.setParent(parent);
			}
		}
		
	}
	
	/**
	 *Set all the nodes which are blocked to be non traversable
	 * @param closedNodes array list of non traversable nodes
	 */
	public void setClosed(ArrayList<Node> closedNodes)
	{
		for(int i = 0; i < closedNodes.size(); i++)
		{
			Node n = closedNodes.get(i);
			int hash = n.coord.genHash();
			n = graph.get(hash);
			n.open = false;
		}
	}
}
