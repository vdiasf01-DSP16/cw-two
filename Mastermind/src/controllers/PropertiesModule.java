package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class PropertiesModule extends AbstractModule {

	@Override
	protected void configure() {
		Properties defaults = new Properties();
		defaults.setProperty("myprop", "default");
		try {
			Properties props = new Properties(defaults);
			props.load(new FileInputStream("my.properties"));
			Names.bindProperties(binder(), props);
		} catch (IOException e) {
			// TODO
		}
	}
}
