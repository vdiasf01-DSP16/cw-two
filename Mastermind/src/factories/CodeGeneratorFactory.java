package factories;

import controllers.ICodeGenerator;
import controllers.IPegFactory;

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
	 * @param pegFactory
	 * @return instance of CodeGenerator
	 */
	public ICodeGenerator create(IPegFactory pegFactory);
}
