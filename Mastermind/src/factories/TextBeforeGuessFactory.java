package factories;

import com.google.inject.Guice;

import factories.modules.BindingsModule;
import factories.modules.PropertiesModule;
import views.ITextBeforeGuess;

/**
 * @author Pedro Gordo
 *
 */
public class TextBeforeGuessFactory
{
	/**
	 * Creates a n instance of ITextBeforeGuess.
	 * 
	 * @return the instance created
	 */
	public ITextBeforeGuess factoryMethod()
	{
		return Guice
				.createInjector(new PropertiesModule(), new BindingsModule())
				.getInstance(ITextBeforeGuess.class);
	}
}
