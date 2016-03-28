package classes;

import com.google.inject.Guice;

import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

/**
 * Factory to create a Game instance.
 * 
 * @author Keith Mannock
 *
 */
public class Factory
{

	/**
	 * Creates an instance of Game.
	 * 
	 * @return the instance created
	 */
	public static Game getInstance()
	{
		return Guice
				.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(Game.class);
	}
}
