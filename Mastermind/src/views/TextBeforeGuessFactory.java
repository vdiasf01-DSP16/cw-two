/**
 * 
 */
package views;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class TextBeforeGuessFactory
{
	/**
	 * Creates an instance of ITextBeforeGuess.
	 * 
	 * @return the instance created
	 */
	public static ITextBeforeGuess create()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(ITextBeforeGuess.class);
	}
}
