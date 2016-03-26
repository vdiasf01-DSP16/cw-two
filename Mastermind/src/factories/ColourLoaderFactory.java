/**
 * 
 */
package factories;

import com.google.inject.Guice;

import controllers.IColourLoader;
import guiceModules.BindingsModule;
import guiceModules.PropertiesModule;

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
