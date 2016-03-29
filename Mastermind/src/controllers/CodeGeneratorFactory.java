package controllers;

import com.google.inject.Guice;
import com.google.inject.Provides;

/**
 * GameFactory for CodeGenerator
 * 
 * @author Pedro Gordo
 *
 */
public class CodeGeneratorFactory
{
	/**
	 * Creates a CodeGenerator instance.
	 * 
	 * @return instance of CodeGenerator
	 */
	public static ICodeGenerator create()
	{
		return Guice.createInjector(new ControllersModule())
				.getInstance(ICodeGenerator.class);
	}

	@Provides
	IPegCreator providePegCreator()
	{
		return PegCreatorFactory.create();
	}
}
