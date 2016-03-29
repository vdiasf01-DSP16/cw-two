/**
 * 
 */
package views;

import com.google.inject.AbstractModule;

/**
 * @author Pedro Gordo
 *
 */
public class ViewsModule extends AbstractModule
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure()
	{
		bind(ICaptureUserGuess.class).to(CaptureUserGuessImpl.class);
	}

}
