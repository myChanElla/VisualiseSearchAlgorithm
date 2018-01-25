package visualisation.datastructure;
import java.awt.Color;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import structures_dataTypes.Node;
import uielements.UILabel;
import uielements.VisualisationUI;
/**
 * This is a helper class which support the data structure visualisation class
 * @author Adedayo
 *
 */
public class DataStructHelper {
	DataStructVis dataStructPanel = VisualisationUI.getDataStructPanel();
	ArrayList<Node> waitingList = new ArrayList<>();
	
	/**
	 * A method which create the node to the data structure
	 * @param node
	 */
	public void createNode(Node node){
		if(dataStructPanel.buttons.size() == 12 ){
			switch (dataStructPanel.struct){
			case STACK:
				dataStructPanel.remove(dataStructPanel.buttons.get(0));
				dataStructPanel.buttons.remove(0);
				for(JLabel l : dataStructPanel.buttons){
					l.setLocation(l.getX(), l.getY()+20);
				}
				dataStructPanel.addNode(node);
				break;
			case QUEUE:		
				this.waitingList.add(node);			
				break;
			default:
				break;	
			}
			
		}
		else{
			dataStructPanel.addNode(node);
		}
	}
	
	/**
	 * This method removes the node from the data structure
	 * @param label
	 */
	public void removeNode(Node label){
		dataStructPanel.removeNode(label);
		for(Node n : waitingList){
			System.out.println(n.toString());
		}
		System.out.println("\n");
		if(!waitingList.isEmpty()){
			dataStructPanel.addNode(waitingList.get(0));
			waitingList.remove(0);
		}
	}
	
	/**
	 * Add the set of nodes to the data structure
	 * @param nodes
	 */
	public void addAll(Set<Node> nodes){
		for(Node n : nodes){
			dataStructPanel.addNode(n);
		}
	}
	
	/**
	 * set the node from the priority queue
	 * @param queue
	 */
	public void setNodesFromPriorityQueue(PriorityQueue<Node> queue){
		ArrayList<JLabel> labels = new ArrayList<>();
		for(Node n : queue){
			UILabel l = new UILabel(n.toString(), 15,new Color(50,62,79), new Color(166,179,198));
			l.setHorizontalAlignment(SwingConstants.CENTER);
			labels.add(l);	
		}
		dataStructPanel.setButtons(labels);
		//call method to present labels
		dataStructPanel.paintNodes();
	}

}
