package classes;

import com.google.inject.Guice;

import guiceModules.ControllerModule;
import guiceModules.PropertiesModule;

public class Factory {

	public static Game getInstance() {
		return Guice.createInjector(new PropertiesModule(), new ControllerModule()).getInstance(GameImpl.class);
	}
}
