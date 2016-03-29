package factories.modules;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author Pedro Gordo
 *
 */
public class PropertiesModule extends AbstractModule
{

	@Override
	protected void configure()
	{
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
	}

}
