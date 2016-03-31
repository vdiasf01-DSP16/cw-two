package models;

import java.util.List;

/**
 * @author Pedro Gordo
 *
 */
public class GuessPlayFactory
{
	/**
	 * @param guessSet
	 * @param resultSet
	 * @return the instance created
	 */
	public static IGuessPlay create(List<IPeg> guessSet, List<IPeg> resultSet)
	{
		return new GuessPlayImpl(guessSet, resultSet);
	}
}
