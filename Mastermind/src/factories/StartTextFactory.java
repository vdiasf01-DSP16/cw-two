package factories;

import com.google.inject.Guice;

import guiceModules.BindingsModule;
import guiceModules.PropertiesModule;
import views.IStartText;

public class StartTextFactory{

	public IStartText factoryMethod() {
		return Guice.createInjector(new PropertiesModule(), new BindingsModule()).getInstance(IStartText.class);
	}

}
