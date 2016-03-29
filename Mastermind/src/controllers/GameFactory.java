package controllers;

import com.google.inject.Guice;

/**
 * GameFactory to create a Game instance.
 * 
 * @author Keith Mannock
 *
 */
public class GameFactory
{

	/**
	 * Creates an instance of Game.
	 * 
	 * @return the instance created
	 */
	public static Game getInstance()
	{
		return Guice
				.createInjector(new ControllersModule())
				.getInstance(Game.class);
	}
}
