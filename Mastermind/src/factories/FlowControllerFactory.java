package factories;

import com.google.inject.Guice;
import com.google.inject.Inject;

import controllers.IFlowController;
import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

/**
 * Factory for FlowController.
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
	public IFlowController factoryMethod()
	{
		return Guice
				.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(IFlowController.class);
	}
}
