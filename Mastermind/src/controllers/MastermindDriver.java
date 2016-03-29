package controllers;

/**
 * @author Keith Mannock
 *
 */
public class MastermindDriver
{

	/**
	 * Main method, no string arguments should be passed. Every configuration
	 * should be set in the configuration file.
	 * 
	 * @param args
	 *            argument passed WILL NOT be used
	 */
	public static void main(String[] args)
	{
		Game g = GameFactory.getInstance();
		g.runGames();
	}
}