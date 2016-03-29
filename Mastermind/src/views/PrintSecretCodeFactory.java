package views;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class PrintSecretCodeFactory
{
	/**
	 * Creates an instance of IPrintSecretCode
	 * 
	 * @return the instance created
	 */
	public static IPrintSecretCode create()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(IPrintSecretCode.class);
	}
}
