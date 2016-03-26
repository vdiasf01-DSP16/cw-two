package classes;

import com.google.inject.Guice;

import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;

public class Factory {

	public static Game getInstance() {
		return Guice.createInjector(new PropertiesModule(), new BindingsModule()).getInstance(GameImpl.class);
	}
}
