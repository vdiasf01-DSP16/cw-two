package controllers;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class PegGeneratorFactory
{
	/**
	 * Creates an instance of PegGenerator.
	 * 
	 * @return the instance created
	 */
	public static IPegGenerator create()
	{
		return Guice.createInjector(new ControllersModule())
				.getInstance(IPegGenerator.class);
	}
}
