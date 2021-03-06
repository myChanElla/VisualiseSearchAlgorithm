package structures_dataTypes;
import java.util.LinkedHashSet;
import java.util.Observable;
import java.util.Set;
import javafx.scene.paint.Color;
import visualisation.graph.FxNode;

/**
 * @author Michael Platts
 * Node class represents each node by specifying its coordinate and whether the node is traversable, used by the graph and search algorithms.
 */
public class Node extends Observable implements Comparable<Node>
{
	
	//Coordinate of the node in the grid storing x and y values
	public Coordinate coord;
	//If the node can be searched or not true = can false = can't
	public boolean open;
	//The parent node of the current node 
	public Node parent;
	//JFX colour code of the node used for tree visualisation
	public Color color;
	public enum ColorChoice { START, GOAL, VISITED }
	//A list of the children reachable from this node
	public Set<Node> children = new LinkedHashSet<Node>();
	//f value for A* search (distance to the goal)
	public float hValue;
	
	//the parent node set in the search algs
	private Node searchParent = null;
	//the fxnode on the graph corresponding to this node
	private FxNode fxnode;
		
	
	/**
	 * Instantiates a new node.
	 *
	 * @param c 			-the coordinate of the node
	 * @param traversable 	-if the node is blocked
	 */
	public Node(Coordinate c, boolean traversable)
	{
		coord = c;
		open = traversable;
		color = Color.WHITE;
	}
	
	@Override
	public String toString(){
		return "(" + coord.getX() + ", " + coord.getY() + ")".replace("[", "").replace("]", "");
	}
	
	/**
	 * Equal method make sure a node equals to its coordinate value
	 * @param n2	- the node
	 * @return 		-true, if successful
	 */
	public boolean equals(Node n2){
		return (n2.getCoord() == this.coord);
	}
	
	/**
	 * Sets open if blocks are traversable by the search algorithm.
	 * @param bool -Boolean value
	 */
	public void setOpen(Boolean bool)
	{
		open = bool;
	}
	
	/**
	 * Gets whether the node is traversable
	 * @return the open
	 */
	public boolean getOpen()
	{
		return open;
	}
	
	/**
	 * Sets the parent.
	 * @param node -the new parent
	 */
	public void  setParent(Node node)
	{
		parent = node;
	}
	
	/**
	 * Gets the parent.
	 * @return - the parent node
	 */
	public Node getParent()
	{
		return parent;
	}
	
	
	/**
	 * Adds the child.
	 * @param node -the node wanted to add
	 */
	public void addChild(Node node)
	{
		children.add(node);
	}
	
	/**
	 * Gets the color.
	 * @return the color
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Sets the color.
	 * @param c the new color
	 */
	public void setColor(ColorChoice c){
		switch(c){
			case START: this.color = Color.GREEN;
				break;
			case VISITED: this.color = Color.color(0, 0.635, 0.91);
				break;
			case GOAL: this.color = Color.RED; 
			break;
		}
		setChanged();
		this.notifyObservers(this.color);
	}
	
	/**
	 * Gets the children of the node
	 * @return the children
	 */
	public Set<Node> getChildren()
	{
		return children;
	}
	
	/**
	 * Gets the coord.
	 * @return the coord
	 */
	public Coordinate getCoord()
	{
		return coord;
	}
	
	/**
	 * Generates a heuristic value for A* search.
	 * @param goal - the goal node
	 */
	public void genHValue(Node goal)
	{
		float distanceX = Math.abs(getCoord().getX() - goal.getCoord().getX());
		float distanceY = Math.abs(getCoord().getY() - goal.getCoord().getY());
		hValue = distanceX + distanceY;		
	}
	
	/**
	 * Gets the heuristic value.
	 * @return the f value
	 */
	public float getFValue()
	{
		return hValue;
	}
	
	/**
	 * Sets the search parent.
	 * @param parent the new search parent
	 */
	public void setFxNode(FxNode node){
		this.fxnode = node;
	}
	
	/**
	 * Gets the search parent.
	 * @return the search parent
	 */
	public FxNode getFxNode(){
		return this.fxnode;
	}
	
	/**
	 * Sets the search parent.
	 * @param parent the new search parent
	 */
	public void setSearchParent(Node parent){
		this.searchParent = parent;
	}
	
	/**
	 * Gets the search parent.
	 * @return the search parent
	 */
	public Node getSearchParent(){
		return this.searchParent;
	}
	
	@Override
	/**
	 * Override the compare to method and use the heuristic value to compare whether or not a node is greater or less than another
	 * @return 1 greater than -1 less than 0 equal to
	 */
	public int compareTo(Node n) 
	{
		float x = n.getFValue();
		if(hValue > x)
		{
			return 1;
		}
		if(hValue < x)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	@Override
	/**
	 * Override the equals method to be able to check if 2 nodes are equal by comparing the coordinate values of each node
	 */
    public boolean equals(Object other) 
    {
        if (this == other)
          return true;

        if (!(other instanceof Node))
          return false;

        Node otherPoint = (Node) other;
        return otherPoint.coord.getX() == coord.getX() && otherPoint.coord.getY() == coord.getY() && otherPoint.getOpen() == getOpen();
    }
}
