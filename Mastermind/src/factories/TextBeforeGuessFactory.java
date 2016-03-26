package factories;

import com.google.inject.Guice;

import guiceModules.BindingsModule;
import guiceModules.PropertiesModule;
import views.ITextBeforeGuess;

public class TextBeforeGuessFactory{
	
	public ITextBeforeGuess factoryMethod() {
		return Guice.createInjector(new PropertiesModule(), new BindingsModule()).getInstance(ITextBeforeGuess.class);
	}
}
