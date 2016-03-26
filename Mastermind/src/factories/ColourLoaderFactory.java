/**
 * 
 */
package factories;

import com.google.inject.Guice;

import controllers.IColourLoader;
import guiceModules.ControllerModule;
import guiceModules.PropertiesModule;

/**
 * @author pedro
 *
 */
public class ColourLoaderFactory {

	public IColourLoader factoryMethod(){
		return Guice.createInjector(new PropertiesModule(), new ControllerModule())
				.getInstance(IColourLoader.class);
	}
}
