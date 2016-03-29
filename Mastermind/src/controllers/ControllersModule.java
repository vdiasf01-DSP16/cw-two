package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Module to be used by Guice indicating the binding between interfaces and
 * implementations.
 * 
 * @author Pedro Gordo
 *
 */
class ControllersModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		/*
		 * Load properties
		 */
		Properties props = new Properties();
		try (FileInputStream inputStream = new FileInputStream(
				"resources/config.properties")) //$NON-NLS-1$
		{
			props.load(inputStream);
			inputStream.close();
			Names.bindProperties(binder(), props);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		/*
		 * Bind interfaces to implementations
		 */
		bind(Game.class).to(GameImpl.class);
		bind(IPegCreator.class).to(PegCreatorImpl.class);
		bind(IColourLoader.class).to(ColourLoaderImpl.class);
		bind(IFlowController.class).to(FlowControllerImpl.class);
		bind(ICodeGenerator.class).to(CodeGeneratorImpl.class);
		bind(IGuessChecker.class).to(GuessCheckerImpl.class);
	}

}
