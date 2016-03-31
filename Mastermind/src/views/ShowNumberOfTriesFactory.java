package views;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class ShowNumberOfTriesFactory
{
	/**
	 * @return the instance created
	 */
	public static IShowNumberOfTries create()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(IShowNumberOfTries.class);
	}
}
