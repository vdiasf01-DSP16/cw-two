package factories;

import com.google.inject.Guice;
import com.google.inject.Inject;

import controllers.IFlowController;
import guiceModules.FlowControllerModule;
import guiceModules.PropertiesModule;

public class FlowControllerFactory {
	
	@Inject
	public IFlowController factoryMethod() {
		return Guice.createInjector(new PropertiesModule(), new FlowControllerModule())
				.getInstance(IFlowController.class);
	}
}
