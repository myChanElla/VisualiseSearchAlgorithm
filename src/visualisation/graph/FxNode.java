package visualisation.graph;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import structures_dataTypes.Node;

/**
 * A class to create a node element in JavaFX
 * @author Matt C.
 *
 */

public class FxNode {
	//the node and its coordinates
	private Circle circle;
	private double circleCoordX;
	private double circleCoordY;
	
	//the nodes level (height/distance from root) in the search tree
	private int level;
	
	//the number of children currently displayed
	private int children = 0;
	
	//the edge between this node and it's parent
	private Line line;
	
	//the parent fx node
	private FxNode fxparent;
	
	//the node label (contains its coordinates from the grid)
	private Text label;

	
	/**
	 * @param node, The graph node passed in
	 * @param panel, The panel that will contain the graph visualisation as a whole
	 */
	public FxNode(Node node, Pane panel, double coordX, double coordY){
		circleCoordX = coordX; 
		circleCoordY = coordY; 
		this.circle = new Circle(circleCoordX, circleCoordY, 20, node.color);
		
		label = new Text();
		label.setX(circleCoordX-10);
		label.setY(circleCoordY);
		label.setText(node.coord.getX() + ", " + node.coord.getY());
		
		panel.getChildren().add(circle);
		panel.getChildren().add(label);
	}
	
	//methods to shift the node left or right to make room for children
	public void shiftLeft(){
		double coord = getXCoord();
		setXCoord(coord - 40);
		label.setX(coord - 50);
		line.setEndX(line.getEndX() - 40);
		circle.setCenterX(circleCoordX);
	}
	public void shiftRight(){
		double coord = getXCoord();
		setXCoord(coord + 40);
		label.setX(coord + 30);
		line.setEndX(line.getEndX() + 40);
		circle.setCenterX(circleCoordX);
	}
	
	//update the centre of the node (redraws automatically in javafx)
	public void draw(){
		circle.setCenterX(circleCoordX);
	}
	
	//updates the edge between this node and it's parent
	public void updateLine() {
		if(fxparent != null){	//make sure this isn't the root node
			line.setStartX(fxparent.getXCoord());
			line.setStartY(fxparent.getYCoord() + 20);
		}
	}
	//set and get the line (edge)
	public void setLine(Line line){
		this.line = line;
	}
	public Line getLine(){
		return this.line;
	}
	
	//set and get the level of the node in the search tree
	public void setLevel(int level){
		this.level = level;
	}
	public int getLevel(){
		return this.level;
	}
	
	//set and get the number of fx children
	public void setChildren(int children){
		this.children = children;
	}
	public int getChildren(){
		return this.children;
	}
	
	//set the fx parent node
	public void setFxParent(FxNode parent){
		this.fxparent = parent;
	}
	
	//set and get X coordinate of the centre of the circle
	public double getXCoord(){
		return this.circleCoordX;
	}
	public void setXCoord(double coord){
		this.circleCoordX = coord;
	}

	//get y coordinate of the centre of the circle
	public double getYCoord() {
		return this.circleCoordY;
	}
	
	//change the color of the circle as displayed to the user
	public void setColor(Color color){
		circle.setFill(color);
	}
}
