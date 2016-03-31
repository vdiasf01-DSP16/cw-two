package controllers;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class GuessCheckerFactory
{

	/**
	 * Creates an instance of IGuessChecker.
	 * 
	 * @return the instance created
	 */
	public static IGuessChecker create()
	{
		return Guice.createInjector(new ControllersModule())
				.getInstance(IGuessChecker.class);
	}

}
