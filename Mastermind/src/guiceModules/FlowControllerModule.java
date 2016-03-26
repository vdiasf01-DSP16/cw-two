package guiceModules;

import com.google.inject.AbstractModule;

import controllers.FlowControllerImpl;
import controllers.IFlowController;

public class FlowControllerModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IFlowController.class).to(FlowControllerImpl.class);
	}

}
