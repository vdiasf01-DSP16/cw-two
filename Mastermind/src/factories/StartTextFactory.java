package factories;

import com.google.inject.Guice;

import guiceModules.PropertiesModule;
import guiceModules.ViewModule;
import views.IStartText;

public class StartTextFactory extends DisplayFactory {

	@Override
	public IStartText factoryMethod() {
		return Guice.createInjector(new PropertiesModule(), new ViewModule()).getInstance(IStartText.class);
	}

}
