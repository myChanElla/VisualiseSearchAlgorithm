package visualisation.pseudocode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONException;

public class AlgorithmStrings 
{
	public static String parseFile(String jsonObj)
	{
		String text = "";
		String jsonString = "";
		BufferedReader br = null;	
		try 
		{
			String line;
			br = new BufferedReader(new FileReader("txt/algorithms.json"));
			while ((line = br.readLine()) != null) 
			{
				jsonString += line + "\n";
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		try 
		{
			JSONObject JSONobj = new JSONObject(jsonString);
			text = JSONobj.getString(jsonObj);
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return text;
	}
	
	public static String dfsAlgoText = parseFile("dfs");
	public static String bfsAlgoText = parseFile("bfs");
	public static String astarAlgoText = parseFile("astar");
}
