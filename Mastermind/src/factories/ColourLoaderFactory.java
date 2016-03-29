/**
 * 
 */
package factories;

import com.google.inject.Guice;

import controllers.IColourLoader;
import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

/**
 * Factory for ColourLoader.
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
	public static IColourLoader factoryMethod()
	{
		return Guice
				.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(IColourLoader.class);
	}
}
