package controllers;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * GameFactory for FlowController.
 * 
 * @author Pedro Gordo
 *
 */
public class FlowControllerFactory
{

	/**
	 * Creates an instance of FlowController.
	 * 
	 * @return the instance created
	 */
	@Inject
	public static IFlowController factoryMethod()
	{
		return Guice
				.createInjector(new ControllersModule())
				.getInstance(IFlowController.class);
	}
}
