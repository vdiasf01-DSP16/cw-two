package factories;

import com.google.inject.Guice;

import guiceModules.PropertiesModule;
import guiceModules.ViewModule;
import views.ITextBeforeGuess;

public class TextBeforeGuessFactory{
	
	public ITextBeforeGuess factoryMethod() {
		return Guice.createInjector(new PropertiesModule(), new ViewModule()).getInstance(ITextBeforeGuess.class);
	}
}
