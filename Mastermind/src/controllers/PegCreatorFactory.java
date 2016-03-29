package controllers;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class PegCreatorFactory
{
	/**
	 * Creates an instance of PegGenerator.
	 * 
	 * @return the instance created
	 */
	public static IPegCreator create()
	{
		return Guice.createInjector(new ControllersModule())
				.getInstance(IPegCreator.class);
	}
}
