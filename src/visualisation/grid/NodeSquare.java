package visualisation.grid;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;

import structures_dataTypes.Coordinate;

/**
 * @author Michael Platts, Creator of Node square
 * @author Adedayo, added labels of coordinates
 * Custom JComponent used by the grid visualiser to draw the grid of nodes
 */
@SuppressWarnings("serial")
public class NodeSquare extends JComponent
{
	Coordinate coord; // Coordinate that the square also stores so we know which node this square represents
	private Color colour; // The colour of the node square when painted
	
	public NodeSquare(Coordinate coord)
	{
		this.coord = coord;
	}
	
	@Override
	/**
	 * Override the paint component so that we always draw a square
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(colour);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, getWidth()-1, getHeight()-1);
		JLabel label = new JLabel(coord.toString());
		label.setBounds(5,0,70,25);
		label.setFont(new Font("Serif", Font.BOLD, 8));
		this.add(label);
	}
	
	/**
	 * Changes the colour of the current node square
	 * @param col, The colour to change it to
	 */
	public void changeColour(Color col)
	{
		this.colour = col;
	}
	
	/**
	 * Gets the coordinate the node square holds
	 * @return coord, the coordinate of this node square
	 */
	public Coordinate getCoord()
	{
		return coord;
	}
}
