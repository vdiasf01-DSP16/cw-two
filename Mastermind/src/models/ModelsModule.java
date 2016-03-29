package models;

import com.google.inject.AbstractModule;

/**
 * @author Pedro Gordo
 *
 */
public class ModelsModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		bind(IGuessHistory.class).to(GuessHistoryImpl.class);
	}

}
