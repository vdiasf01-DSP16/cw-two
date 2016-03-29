/**
 * 
 */
package views;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

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
		/*
		 * Load properties
		 */
		Properties props = new Properties();
		try (FileInputStream inputStream = new FileInputStream(
				"resources/config.properties")) //$NON-NLS-1$
		{
			props.load(inputStream);
			inputStream.close();
			Names.bindProperties(binder(), props);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		/*
		 * Bind interfaces to implementations
		 */
		bind(IStartText.class).to(StartTextImpl.class);
		bind(ITextBeforeGuess.class).to(TextBeforeGuessImpl.class);
		bind(ICaptureUserGuess.class).to(CaptureUserGuessImpl.class);
	}

}
