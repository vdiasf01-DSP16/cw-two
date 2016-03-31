package models;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class GuessHistoryFactory
{
	/**
	 * @return the instance created
	 */
	public static IGuessHistory create()
	{
		return Guice.createInjector(new ModelsModule())
				.getInstance(IGuessHistory.class);
	}
}
