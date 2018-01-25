package visualisation.graph;
import java.util.LinkedHashMap;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.paint.Color;
import structures_dataTypes.Node;

@SuppressWarnings("serial")
public class GraphVisualiser extends JFXPanel {
	private LinkedHashMap<Integer,Node> graph;
	private ScrollPane sc;

	/**
	 * Create the panel.
	 * @param graph, the graph to depict.
	 */
	public GraphVisualiser(LinkedHashMap <Integer, Node> graph) {
		this.graph = graph;		
	}
	/**
	 * Set up the FxGraph, wrap it in a ScrollPane which is put on the scene and displayed.
	 */
	public void initialise(){
		FxGraph FXG = new FxGraph(graph);
		FXG.setMinSize(400, 300);
		
		sc = new ScrollPane();
		sc.setStyle("-fx-background-color:rgb(50,62,79); -fx-background:rgb(50,62,79);");
		sc.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sc.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sc.setPannable(true);
		
		Scene scene = new Scene(sc, this.getWidth(), this.getHeight(), Color.GRAY); 
		this.setScene(scene);
		
		//wrap the fxgraph in a group so it expands as nodes are added
		Group g = new Group(); 
		g.getChildren().add(FXG);
		sc.setContent(g);
	}
	
}
