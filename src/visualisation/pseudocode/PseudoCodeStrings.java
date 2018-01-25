package visualisation.pseudocode;

/**
 * 
 * @author Michael Platts
 * Contains the strings used by the pseudoCodeGen to print strings as the algorithm is running 
 */
public class PseudoCodeStrings 
{
	public String addNode = "frontier.add node: ";
	public String pushNode = "frontier.push node: ";
	public String whileLoop = "While the frontier !empty {\n";
	public String pollNode = "frontier.poll node ";
	public String popNode = "frontier.pop node ";
	public String alreadyVisited = " has already been visited";
	public String notTraversable = " is not traversable";
	public String addVisited = "visited.add node ";
	public String visitable = " is not already visited and is traversable";
	public String notEqual = " != goal node ";
	public String doesEqual = " == goal node ";
	public String addChildren = "frontier.addAll children of node ";
	public String completed = "GOAL NODE FOUND! \n";
	public String failed = "GOAL NODE NOT FOUND! \n";
	public String genH = "Calculating heuristic value for node: ";
}