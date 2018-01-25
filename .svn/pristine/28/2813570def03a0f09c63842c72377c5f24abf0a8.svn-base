package structures_dataTypes;
/**
 * class representing coordinate points data type used by nodes
 * @author Michael Platts
 *
 */
public class Coordinate 
{
	private int x;
	private int y;
	
	/**
	 * Constructor
	 * @param x	- x Coordinate value
	 * @param y	- y Coordinate value
	 */
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * get x coordinate
	 * @return value of x coordinate
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * get y coordinate
	 * @return value of y coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * set the x coordinate
	 * @param value for x coordinate
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * set the y coordinate
	 * @param value for y coordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) 
	{
		Coordinate c = (Coordinate)o;
		return x == c.x && y == c.y;
	}
	
	/**
	 * Generates the hash used for the LinkedHashMap to store each node
	 * @return hash value
	 */
	public int genHash()
	{
		int hash = (x * 33) - (y) + (y * 31);
		return hash;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "(" + x + "," + y + ")".replace("[", "").replace("]", "");
	}
}
