package visualisation.pseudocode;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import uielements.VisualisationUI;

/**
 * @author Adedayo, Creation of methods to adjust text in the pseudo text pane and html font format
 * @author Michael Platts, Debugging and adjustment of some methods to fix how the text is displayed
 *
 */
public class PseudoCodeGen 
{
	JTextPane pseudoText = VisualisationUI.getPseudoText();
	
	public void setPseudoText(String text)
	{
		pseudoText.setText(text);
	}
	
	public void addPseudoText(String text){
		append(text);
	}
	
	public void setPseudoHTML(String html)
	{
		setPseudoText(html);
	}
	
	public void append(String s) 
	{
		try 
		{
				HTMLEditorKit kit = (HTMLEditorKit) pseudoText.getEditorKit();
			    HTMLDocument doc = (HTMLDocument) pseudoText.getDocument();
			    try {
					kit.insertHTML(doc, doc.getLength(), String.format("<font size=\"4\" face=\"verdana\"> %s </font>", s), 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
		catch(BadLocationException exc) 
		{
		      exc.printStackTrace();
		 }
	}
}
