package uielements;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * Custom Label used across the GUI 
 * @author Chrystal
 *
 */
public class UILabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private int fontsize;
	/**
	 * Constructor, creates label
	 * @param lblText, text on the label
	 * @param fontSize, font size of the text on the label
	 * @param foregroundColor, the colour of the text
	 * @param backgroundColor, the colour of the background
	 */
	public UILabel(String lblText, int fontSize, Color foregroundColor, Color backgroundColor)
	{
		this.fontsize = fontSize;
		setText(lblText);
		setForeground(foregroundColor);
		setOpaque(true);
		setBackground(backgroundColor);
		setFont(new Font("Helvetica", Font.PLAIN, fontSize));
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	/**
	 * Set grid bag constraints values
	 * @param container, the container that will contain the grid bag
	 * @param gridx, cell containing the leading edge of grid bag
	 * @param gridy, cell containing the top of the grid bag display area
	 * @param gridWidth, width of grid bag
	 * @param gridHeight, height of grid bag
	 */
	public void setGridBag(Container container, int gridx, int gridy, int gridWidth, int gridHeight)
	{
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.fill = GridBagConstraints.BOTH;
		gbc_lbl.insets = new Insets(5, 5, 5, 5);
		gbc_lbl.gridx = gridx;
		gbc_lbl.gridy = gridy;
		gbc_lbl.gridwidth = gridWidth;
		gbc_lbl.gridheight= gridHeight;
		container.add(this, gbc_lbl);
	}
	/**
	 * Image as icon 
	 * @param lblImage, the image
	 */
	public void setImage(String lblImage)
	{
		setOpaque(false);
		setIcon(new ImageIcon(HelpUI.class.getResource(lblImage)));
	}
	/**
	 * Set the font to bold
	 */
	public void setBold(){
		setFont(new Font("Helvetica", Font.BOLD, fontsize));
	}
	
}
