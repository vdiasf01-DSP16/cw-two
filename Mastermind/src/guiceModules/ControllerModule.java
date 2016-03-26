package guiceModules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import controllers.ColourLoaderImpl;
import controllers.FlowControllerImpl;
import controllers.IColourLoader;
import controllers.IFlowController;
import controllers.pegGenerator.IPegGenerator;
import controllers.pegGenerator.PegGeneratorFactory;
import controllers.pegGenerator.PegGeneratorImpl;

public class ControllerModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new FactoryModuleBuilder()
				.implement(IPegGenerator.class, PegGeneratorImpl.class)
				.build(PegGeneratorFactory.class));
		bind(IColourLoader.class).to(ColourLoaderImpl.class);
		bind(IFlowController.class).to(FlowControllerImpl.class);
//		bind(ICodeGenerator.class).to(CodeGeneratorImpl.class);
	}

}
