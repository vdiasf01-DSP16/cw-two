/**
 * 
 */
package controllers;

import com.google.inject.Guice;

/**
 * GameFactory for ColourLoader.
 * 
 * @author Pedro Gordo
 *
 */
public class ColourLoaderFactory
{

	/**
	 * Creates an instance of ColourLoader.
	 * 
	 * @return the instance created
	 */
	public static IColourLoader create()
	{
		return Guice
				.createInjector(new ControllersModule())
				.getInstance(IColourLoader.class);
	}
}
