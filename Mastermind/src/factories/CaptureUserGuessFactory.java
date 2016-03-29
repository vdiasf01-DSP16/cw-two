package factories;

import com.google.inject.Guice;

import views.ICaptureUserGuess;
import views.ViewsModule;

/**
 * @author Pedro Gordo
 *
 */
public class CaptureUserGuessFactory
{
	/**
	 * Creates an instance of ICaptureUserGuess.
	 * 
	 * @return the instance created
	 */
	public ICaptureUserGuess factoryMethod()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(ICaptureUserGuess.class);
	}
}
