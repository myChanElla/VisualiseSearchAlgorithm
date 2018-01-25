package visualisation.pseudocode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * @author Michael Platts 
 * Used for parsing a JSON file that stores a collection of very large strings used within the program 
 */
public class TextStrings 
{
	
	/**
	 * Method to parse the JSON file and look for a particular JSON object
	 * @param jsonObj, the JSON object to get from the file 
	 * @return The string of the that JSON object
	 */
	public static String parseFile(String jsonObj)
	{
		String text = "";
		String jsonString = "";
		BufferedReader br = null;	
		try 
		{
			String line;
			// Read the JSON file containing the text
			br = new BufferedReader(new FileReader("txt/TextStrings.json"));
			while ((line = br.readLine()) != null) 
			{
				// Read the whole document
				jsonString += line + "\n";
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		try 
		{
			//Get the JSON object with the matching string
			JSONObject JSONobj = new JSONObject(jsonString);
			text = JSONobj.getString(jsonObj);
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return text;
	}
	
	public static String dfsAlgoText = parseFile("dfs"); // The text of the depth first search algorithm
	public static String bfsAlgoText = parseFile("bfs"); // The text of the breadth first search algorithm
	public static String astarAlgoText = parseFile("astar"); // The text of the A* search algorithm
	public static String menuText = parseFile("menu"); // The text on the main menu ui
}
