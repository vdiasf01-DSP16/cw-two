package views;

import com.google.inject.Guice;

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
	public static ICaptureUserGuess create()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(ICaptureUserGuess.class);
	}
}
