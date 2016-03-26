/**
 * 
 */
package factories;

import com.google.inject.Guice;

import controllers.IColourLoader;
import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

/**
 * @author pedro
 *
 */
public class ColourLoaderFactory {

	public IColourLoader factoryMethod(){
		return Guice.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(IColourLoader.class);
	}
}
