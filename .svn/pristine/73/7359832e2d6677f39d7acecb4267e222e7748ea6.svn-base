package testing;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

import structures_dataTypes.Coordinate;
import structures_dataTypes.GraphGenerator;
import structures_dataTypes.Node;

/**
 * 
 * @author Michael Platts
 *  Tests the generation of graphs and retrieval of nodes from within it
 *
 */
public class GraphTest {
	
	LinkedHashMap<Integer, Node> test1;
	LinkedHashMap<Integer, Node> test2;
	LinkedHashMap<Integer, Node> test3;
	LinkedHashMap<Integer, Node> test4;
	
	/*
	 * Generate a linked hash map of nodes using the graph generator using different parameters
	 * of x and y. To use these to test if the nodes are  correctly generated.  
	 */
	public void setup()
	{
		GraphGenerator graph = new GraphGenerator();
		int x1 = 5;
		int y1 = 5;
		ArrayList<Node> closedNodes = new ArrayList<Node>();
		test1 = graph.genGraph(x1, y1, closedNodes);
		x1 = x1 + 5;
		y1 = y1 + 5;
		test2 = graph.genGraph(x1, y1, closedNodes);
		x1 = 7;
		y1 = 5;
		test3 = graph.genGraph(x1, y1, closedNodes);
		x1 = 10;
		y1 = 10;
		Coordinate c = new Coordinate(2,2);
		Node closedNode1 = new Node(c, false);
		c.setX(4);
		c.setY(5);
		Node closedNode2 = new Node(c, false);
		c.setX(7);
		c.setY(2); 
		Node closedNode3 = new Node(c, false);
		closedNodes.add(closedNode1);
		closedNodes.add(closedNode2);
		closedNodes.add(closedNode3);
		test4 = graph.genGraph(x1, y1, closedNodes);
	}

	@Test
	/**
	 * Test 1 tests that a small size graph is generated correctly.
	 */
	public void test1() 
	{
		GraphGenerator graph = new GraphGenerator();
		int x1 = 5;
		int y1 = 5;
		ArrayList<Node> closedNodes = new ArrayList<Node>();
		test1 = graph.genGraph(x1, y1, closedNodes);
		// check it isn't empty
		assertFalse(test1.isEmpty());
		// check the overall size is  correct 5x5
		assertTrue(test1.size() == 25);
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				// Check all of the correct nodes are there
				Coordinate c = new Coordinate(i,j);
				Node trueNode = new Node(c, true); 
				assertTrue(test1.containsKey(trueNode.coord.genHash()));
			}
		}
		// Check that a node that is too big isn't there.
		Coordinate c1 = new Coordinate(6,6);
		Node falseNode = new Node(c1, true);
		assertFalse(test1.containsKey(falseNode.coord.genHash()));
		c1.setX(-1);
		c1.setY(-1);
		falseNode.coord = c1;
		//Check that a node  that is too small isn't there
		assertFalse(test1.containsKey(falseNode.coord.genHash()));
	}
	
	@Test
	/**
	 * Test 3 checks that a large graph generates correctly
	 */
	public void test2() 
	{
		GraphGenerator graph = new GraphGenerator();
		int x1 = 10;
		int y1 = 10;
		ArrayList<Node> closedNodes = new ArrayList<Node>();
		test2 = graph.genGraph(x1, y1, closedNodes);
		// Check it isn't empty
		assertFalse(test2.isEmpty());
		// Check it is the correct size 10 x 10
		assertTrue(test2.size() == 100);
		// Check all the correct nodes are there
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				Coordinate c = new Coordinate(i,j);
				Node trueNode = new Node(c, true); 
				assertTrue(test2.containsKey(trueNode.coord.genHash()));
			}
		}
		// Check for a coordinate that is too large to be there
		Coordinate c1 = new Coordinate(11,11);
		Node falseNode = new Node(c1, true);
		assertFalse(test2.containsKey(falseNode.coord.genHash()));
		c1.setX(-1);
		c1.setY(-1);
		falseNode.coord = c1;
		// Check for a coordinate that is too small to be there
		assertFalse(test2.containsKey(falseNode.coord.genHash()));
	}
	
	@Test
	/**
	 * Test 3 checks that a none symmetrical graph generates correctly
	 */
	public void test3() 
	{
		GraphGenerator graph = new GraphGenerator();
		int x1 = 7;
		int y1 = 5;
		ArrayList<Node> closedNodes = new ArrayList<Node>();
		test3 = graph.genGraph(x1, y1, closedNodes);
		// Check it isn't empty
		assertFalse(test3.isEmpty());
		// Check it is the correct size
		assertTrue(test3.size() == 35);
		// Check that all the nodes that should be there are 
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				Coordinate c = new Coordinate(i,j);
				Node trueNode = new Node(c, true); 
				assertTrue(test3.containsKey(trueNode.coord.genHash()));
			}
		}
		// Check for a coordinate that is too large to not be there 
		Coordinate c1 = new Coordinate(8,8);
		Node falseNode = new Node(c1, true);
		assertFalse(test3.containsKey(falseNode.coord.genHash()));
		c1.setX(-1);
		c1.setY(-1);
		falseNode.coord = c1;
		// Check for a coordinate that is too small to not be there
		assertFalse(test3.containsKey(falseNode.coord.genHash()));
	}
	
	/**
	 * Test 4 checks that nodes that shouldn't be traversable are properly added
	 * and identified.
	 */
	@Test
	public void test4() 
	{
		GraphGenerator graph = new GraphGenerator();
		int x1 = 10;
		int y1 = 10;
		ArrayList<Node> closedNodes = new ArrayList<Node>();
		Coordinate cc1 = new Coordinate(2,2);
		Node closedNode1 = new Node(cc1, true);
		Coordinate cc2 = new Coordinate(4,5);
		Node closedNode2 = new Node(cc2, true);
		Coordinate cc3 = new Coordinate(7,2);
		Node closedNode3 = new Node(cc3, true);
		closedNodes.add(closedNode1);
		closedNodes.add(closedNode2);
		closedNodes.add(closedNode3);
		test4 = graph.genGraph(x1, y1, closedNodes);
		// Check it isn't empty
		assertFalse(test4.isEmpty());
		// Check it is the correct size 10x10
		assertTrue(test4.size() == 100);
		// Check that all the nodes that should be there are 
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				Coordinate c = new Coordinate(i,j);
				Node trueNode = new Node(c, true); 
				assertTrue(test4.containsKey(trueNode.coord.genHash()));
			}
		}
		// Check for a coordinate that is too large to be there isn't
		Coordinate c1 = new Coordinate(13,11);
		Node falseNode = new Node(c1, true);
		assertFalse(test4.containsKey(falseNode.coord.genHash()));
		c1.setX(-1);
		c1.setY(-1);
		falseNode.coord = c1;
		// Check for a coordinate that is too small to be there isn't 
		assertFalse(test4.containsKey(falseNode.coord.genHash()));
		
		// Check that nodes which shouldn't be traversable by the search
		// are identified as not being traversable
		Coordinate c2 = new Coordinate(2,2);
		Node closed = test4.get(c2.genHash());
		assertFalse(closed.open);
		c2.setX(4);
		c2.setY(5);
		closed = test4.get(c2.genHash());
		assertFalse(closed.open);
		c2.setX(7);
		c2.setY(2);
		closed = test4.get(c2.genHash());
		assertFalse(closed.open);
	}
}
