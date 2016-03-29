package factories;

import com.google.inject.Guice;

import controllers.ICodeGenerator;
import controllers.IPegFactory;
import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

/**
 * Factory for CodeGenerator
 * 
 * @author Pedro Gordo
 *
 */
public class CodeGeneratorFactory
{
	/**
	 * Creates a CodeGenerator instance.
	 * 
	 * @param pegFactory //TODO inject this
	 * @return instance of CodeGenerator
	 */
	public ICodeGenerator factoryMethod(IPegFactory pegFactory)
	{
		ICodeGenerator codeGenerator = Guice
				.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(ICodeGenerator.class);
		// TODO change to dependency injection
		codeGenerator.setPegGenerator(pegFactory);
		return codeGenerator;
	}
}
