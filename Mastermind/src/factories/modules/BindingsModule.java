package factories.modules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import classes.Game;
import classes.GameImpl;
import controllers.CodeGeneratorImpl;
import controllers.ColourLoaderImpl;
import controllers.FlowControllerImpl;
import controllers.ICodeGenerator;
import controllers.IColourLoader;
import controllers.IFlowController;
import controllers.IPegCreator;
import controllers.PegCreatorImpl;
import factories.CodeGeneratorFactory;
import factories.PegCreatorFactory;
import views.IStartText;
import views.ITextBeforeGuess;
import views.StartTextImpl;
import views.TextBeforeGuessFactory;
import views.TextBeforeGuessImpl;

/**
 * Module to be used by Guice indicating the binding between interfaces and
 * implementations.
 * 
 * @author Pedro Gordo
 *
 */
public class BindingsModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		bind(Game.class).to(GameImpl.class);

		install(new FactoryModuleBuilder()
				.implement(IPegCreator.class, PegCreatorImpl.class)
				.build(PegCreatorFactory.class));

		bind(IColourLoader.class).to(ColourLoaderImpl.class);

		bind(IFlowController.class).to(FlowControllerImpl.class);

		install(new FactoryModuleBuilder()
				.implement(ICodeGenerator.class, CodeGeneratorImpl.class)
				.build(CodeGeneratorFactory.class));

		bind(IStartText.class).to(StartTextImpl.class);

		install(new FactoryModuleBuilder()
				.implement(ITextBeforeGuess.class, TextBeforeGuessImpl.class)
				.build(TextBeforeGuessFactory.class));
	}

}
