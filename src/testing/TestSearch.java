package testing;
import java.util.LinkedHashMap;

import search_algorithms.BFS;
import search_algorithms.DFS;
import structures_dataTypes.Coordinate;
import structures_dataTypes.GraphGenerator;
import structures_dataTypes.Node;

public class TestSearch 
{
	public static void main(String args[])
	{
		GraphGenerator gen = new GraphGenerator();
		LinkedHashMap<Integer, Node> graph = gen.genGraph(10, 10, null);
		Coordinate start = new Coordinate(0, 0);
		Coordinate goal = new Coordinate(3, 7);
		
		Node startNode = graph.get(start.genHash());
		Node goalNode = graph.get(goal.genHash());
		
		DFS depthSearch = new DFS();
		Node test = depthSearch.dfs(startNode, goalNode);
		BFS breadthSearch = new BFS();
		
		Node test1 = breadthSearch.bfs(startNode, goalNode);
		if(test == goalNode)
		{
			System.out.println("DFS Test Passed");
		}
		else
		{
			System.out.println("DFS Test Failed");
		}
		if(test1 == goalNode)
		{
			System.out.println("BFS Test Passed");
		}
		else
		{
			System.out.println("BFS Test Failed");
		}
	}
}
