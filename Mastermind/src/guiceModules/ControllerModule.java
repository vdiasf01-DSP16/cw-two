package guiceModules;

import com.google.inject.AbstractModule;

import controllers.CodeGeneratorImpl;
import controllers.FlowControllerImpl;
import controllers.ICodeGenerator;
import controllers.IFlowController;
import controllers.IPegGenerator;
import controllers.PegGeneratorImpl;

public class ControllerModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IFlowController.class).to(FlowControllerImpl.class);
		bind(ICodeGenerator.class).to(CodeGeneratorImpl.class);
		bind(IPegGenerator.class).to(PegGeneratorImpl.class);
	}

}
