package classes;

import com.google.inject.Guice;

import guiceModules.BindingsModule;
import guiceModules.PropertiesModule;

public class Factory {

	public static Game getInstance() {
		return Guice.createInjector(new PropertiesModule(), new BindingsModule()).getInstance(GameImpl.class);
	}
}
