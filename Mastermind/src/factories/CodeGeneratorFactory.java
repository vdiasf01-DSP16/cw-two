package factories;

import com.google.inject.Guice;

import controllers.ICodeGenerator;
import controllers.IPegGenerator;
import guiceModules.ControllerModule;
import guiceModules.PropertiesModule;

public class CodeGeneratorFactory {

	public ICodeGenerator factoryMethod(IPegGenerator pegGenerator){
		ICodeGenerator codeGenerator = Guice.createInjector(new PropertiesModule(), new ControllerModule())
				.getInstance(ICodeGenerator.class);
		codeGenerator.setPegGenerator(pegGenerator);
		return codeGenerator;
	}
}
