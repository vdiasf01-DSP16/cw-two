package factories;

import com.google.inject.Guice;

import controllers.ICodeGenerator;
import guiceModules.ControllerModule;
import guiceModules.PropertiesModule;

public class CodeGeneratorFactory {

	public ICodeGenerator factoryMethod(){
		return Guice.createInjector(new PropertiesModule(), new ControllerModule())
				.getInstance(ICodeGenerator.class);
	}
}
