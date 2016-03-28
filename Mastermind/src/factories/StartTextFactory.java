package factories;

import com.google.inject.Guice;

import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;
import views.IStartText;

/**
 * @author Pedro Gordo
 *
 */
public class StartTextFactory
{
	/**
	 * Creates an instance of StartText.
	 * 
	 * @return the instance created
	 */
	public IStartText factoryMethod()
	{
		return Guice
				.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(IStartText.class);
	}
}
