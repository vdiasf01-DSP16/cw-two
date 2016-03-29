package views;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class LastTextFactory
{
	/**
	 * @return the instance created
	 */
	public static ILastText create()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(ILastText.class);
	}
}
