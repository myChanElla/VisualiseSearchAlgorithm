package visualisation.graph;

import javafx.scene.shape.Line;

/**
 * This class has the purpose of creating a Line (javafx.scene.shape.Line) 
 * representing an edge between two given nodes.
 * @author Matthias Casula
 *
 */
public class FxEdge {
	
	private Line line;
	
	/**
	 * Constructor of the edge
	 * @param xOrigin, the X coordinate of the parent node
	 * @param yOrigin, the Y coordinate of the parent node
	 * @param xDest, the X coordinate of the child node
	 * @param yDest, the Y coordinate of the child node
	 * @param panel, the JFX Pane that the edge is added to
	 */
	public FxEdge(FxNode parent, double circleCoordX, double circleCoordY, FxGraph fxgraph ){
		line = new Line();
		line.setStartX(parent.getXCoord());
		line.setStartY(parent.getYCoord()+20); //small offset so lines dont show over the top of nodes
		line.setEndX(circleCoordX);
		line.setEndY(circleCoordY);
		fxgraph.getChildren().add(line);
	}
	
	public Line getLine(){
		return this.line;
	}
}
