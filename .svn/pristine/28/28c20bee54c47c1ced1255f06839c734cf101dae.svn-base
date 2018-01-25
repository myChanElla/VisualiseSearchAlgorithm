package uielements;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
/**
 * Custom JPanel used across the GUI
 * @author Chrystal
 *
 */
public class UIPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor, creates a UIPanel
	 * @param panelColor, background colour of the panel
	 */
	public UIPanel(Color panelColor){
	
		setBackground(panelColor);
	}
		
	/**
	 * Set grid bag constraints values
	 * @param container, the container that will contain the grid bag
	 * @param gridx, cell containing the leading edge of grid bag
	 * @param gridy, cell containing the top of the grid bag display area
	 * @param gridWidth, width of grid bag
	 * @param gridHeight, height of grid bag
	 */
	public void setGridBag(Container container, int gridx, int gridy, int gridWidth, int gridHeight, Insets insets)
	{
				
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = insets;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = gridx;
		gbc_panel.gridy = gridy;
		gbc_panel.gridwidth = gridWidth;
		gbc_panel.gridheight = gridHeight;
		container.add(this, gbc_panel);
	}	
}
