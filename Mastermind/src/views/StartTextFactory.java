package views;

import com.google.inject.Guice;

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
	public static IStartText factoryMethod()
	{
		return Guice
				.createInjector(new ViewsModule())
				.getInstance(IStartText.class);
	}
}
