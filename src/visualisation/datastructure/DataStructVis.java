package visualisation.datastructure;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import structures_dataTypes.Node;
import structures_dataTypes.Struct;
import uielements.UILabel;

/**
 * This class visualise the data structure(stack/queue) panel 
 * @author Adedayo
 *
 */
public class DataStructVis extends JPanel {

	public static int BUTTON_LOCATION_X;  // location x 
	public static int BUTTON_LOCATION_Y;   // location y 
	private static final int BUTTON_SIZE_X = 100;   
	private static final int BUTTON_SIZE_Y = 25;
	public ArrayList<JLabel> buttons = new ArrayList<>();
	public Struct struct;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of class 
	 * @param struct	- Data structure component
	 */
	public DataStructVis(Struct struct)
	{
		super();
		this.struct = struct;
		this.setBounds(586, 430, 570, 342);
		BUTTON_LOCATION_X = (this.getWidth()/2) - (BUTTON_SIZE_X /2);
		BUTTON_LOCATION_Y = this.getHeight() - 92;
		this.setBackground(new Color(50,62,79));
		setLayout(null);
	}

	/**
	 * This method adds a node to the structure
	 * @param node	- the node to be placed
	 */
	public void addNode(Node node){	
		UILabel button = new UILabel(node.toString(), 15,new Color(50,62,79), new Color(166,179,198));
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setBounds(BUTTON_LOCATION_X, getNextYAlignment(), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		this.add(button);
		button.setVisible(true);
		this.buttons.add(button);
		this.repaint();	
	}

	/**
	 * This method removes the node from the structure
	 * @param node	-the node to be removed
	 */
	public void removeNode(Node node){
		switch (this.struct){
		//Depth First Search
		case STACK:{
			int index = -1;
			for(int i = this.buttons.size()-1;i>=0;i--){
				JLabel b = this.buttons.get(i);
				if(b.getText().equals(node.toString())){
					b.setForeground(Color.RED);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					remove(b);
					index = this.buttons.indexOf(b);
					if(index!=-1){
						this.buttons.remove(index);
					}
					break;
				}
			}
			break;
		}
		//Breadth First Search
		case QUEUE:{
			int index = -1;
			for(int x=0;x<this.buttons.size();x++){
				JLabel label = this.buttons.get(x);
				if(label.getText().equals(node.toString())){
					label.setForeground(Color.RED);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					remove(label);
					index = this.buttons.indexOf(label);
					if(index!=-1){
						this.buttons.remove(index);
					}
					for(JLabel l : this.buttons){
						l.setLocation(l.getX(), l.getY()+20);
					}
					break;
				}
			}
			break;
		}
		default:
			break;
		}

		this.revalidate();
		this.repaint();	
	}

	/**
	 * Gets the alignment of y
	 * @return new location of y
	 */
	public int getNextYAlignment(){
		return BUTTON_LOCATION_Y - (this.buttons.size() * 20);
	}

	/**
	 * Paint the node onto the data structure
	 */
	public void paintNodes(){
		for(Component l : this.getComponents()){
			if (l.getClass().equals(UILabel.class)){
				JLabel label = (JLabel) l;
				if (label.getText().startsWith("(")){
					this.remove(label);
				}
			}
		}
		for(int i=0; i<this.buttons.size();i++){
			if(i<=12){
				JLabel label = this.buttons.get(i);
				label.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y - (i * 20), BUTTON_SIZE_X, BUTTON_SIZE_Y);
				this.add(label);
				label.setVisible(true);
			}
		}
		this.repaint();	
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(166,179,198));
		g2.setStroke(new BasicStroke(2));

		String dataStructLabelText = "";
		String descTxt = "";

		switch (this.struct){
		case STACK:
			dataStructLabelText = "Stack (top 12 elements)";
			descTxt = "Last In First Out";
			g2.drawLine(BUTTON_LOCATION_X - 15, 30, BUTTON_LOCATION_X - 15, this.getHeight()+30);
			g2.drawLine(BUTTON_LOCATION_X + BUTTON_SIZE_X + 15, 30, BUTTON_LOCATION_X + BUTTON_SIZE_X + 15, this.getHeight()+30);		
			break;
		case QUEUE:
			dataStructLabelText = "Queue (top 12 elements)";
			descTxt = "First In First Out";
			g2.drawLine(BUTTON_LOCATION_X - 15, 0, BUTTON_LOCATION_X - 15, this.getHeight()-75);
			g2.drawLine(BUTTON_LOCATION_X + BUTTON_SIZE_X + 15, 0, BUTTON_LOCATION_X + BUTTON_SIZE_X + 15, this.getHeight()-75);		
			break;
		case PRIORITY_QUEUE:
			dataStructLabelText = "Priority Queue (top 12 elements)";
			descTxt = "First In First Out with Priority";
			g2.drawLine(BUTTON_LOCATION_X - 15, 0, BUTTON_LOCATION_X - 15, this.getHeight()-75);
			g2.drawLine(BUTTON_LOCATION_X + BUTTON_SIZE_X + 15, 0, BUTTON_LOCATION_X + BUTTON_SIZE_X + 15, this.getHeight()-75);		
			break;
		default:
			break;
		}

		UILabel dataStructLabel = new UILabel(dataStructLabelText, 12, new Color(166,179,198), null);	
		UILabel desc = new UILabel(descTxt, 12, new Color(166,179,198), null);
		dataStructLabel.setBounds(10, 10, 190, 30);
		desc.setBounds(10, 40, 200, 30);
		this.add(dataStructLabel);
		this.add(desc);
	}
	
	/**
	 * set the data structure
	 * @param s	- structure component
	 */
	public void setDataStruct(Struct s){
		this.struct = s;
	}

	/**
	 * set buttons array
	 * @param buttons
	 */
	public void setButtons(ArrayList<JLabel> buttons) {
		this.buttons = buttons;
	}
}
