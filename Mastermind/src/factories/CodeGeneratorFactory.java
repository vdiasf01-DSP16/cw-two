package factories;

import com.google.inject.Guice;

import controllers.ICodeGenerator;
import controllers.IPegGenerator;
import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

public class CodeGeneratorFactory {

	public ICodeGenerator factoryMethod(IPegGenerator pegGenerator){
		ICodeGenerator codeGenerator = Guice.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(ICodeGenerator.class);
		codeGenerator.setPegGenerator(pegGenerator);
		return codeGenerator;
	}
}
