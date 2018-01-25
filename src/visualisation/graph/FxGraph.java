package visualisation.graph;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.Set;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import structures_dataTypes.Node;



/**
 * Creates each node from a graph taken as param onto a JFX Pane.
 * @author Matt C.
 *
 */
public class FxGraph extends Pane {
	//initialise here so we can use inside Runnable scope
	//private FxNode currNode;
	private ColorListener listener;
	/**
	 * @param graph, the graph from the UI that is drawn
	 * @param panel, the JFX pane on which everything is drawn
	 */
	public FxGraph(LinkedHashMap<Integer, Node> graph){
		FxGraph fxgraph = this; //so we can pass this as an arg inside the Runnable scope
		Set<Integer> keys = graph.keySet();
		
		ArrayList<FxNode> fxnodes = new ArrayList<FxNode>();
		
		for (Integer i : keys){
			Platform.runLater(new Runnable() {  //run this code on the jfx thread
	            @Override
	            public void run() {
	            	Node node = graph.get(i);
	    			listener = new ColorListener(graph,node,fxgraph, fxnodes);
	            	node.addObserver(listener);	
	            }
	        });
		}
	}
}
