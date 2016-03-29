package views;

import com.google.inject.Guice;

/**
 * @author Pedro Gordo
 *
 */
public class PrintHistoryFactory
{
	/**
	 * @return the instance created
	 */
	public static IPrintHistory create()
	{
		return Guice.createInjector(new ViewsModule())
				.getInstance(IPrintHistory.class);
	}
}
