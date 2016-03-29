package factories;

import controllers.ICodeGenerator;
import controllers.IPegCreator;

/**
 * Factory for CodeGenerator
 * 
 * @author Pedro Gordo
 *
 */
public interface CodeGeneratorFactory
{
	/**
	 * Creates a CodeGenerator instance.
	 * 
	 * @param pegCreator
	 * @return instance of CodeGenerator
	 */
	public ICodeGenerator create(IPegCreator pegCreator);
}
