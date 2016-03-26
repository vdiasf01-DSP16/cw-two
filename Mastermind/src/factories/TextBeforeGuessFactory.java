package factories;

import com.google.inject.Guice;

import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;
import views.ITextBeforeGuess;

public class TextBeforeGuessFactory{
	
	public ITextBeforeGuess factoryMethod() {
		return Guice.createInjector(new PropertiesModule(), new BindingsModule()).getInstance(ITextBeforeGuess.class);
	}
}
