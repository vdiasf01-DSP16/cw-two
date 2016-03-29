package views;

import models.IGuessHistory;

/**
 * @author Pedro Gordo
 *
 */
public interface IPrintHistory
{
	/**
	 * Prints the current history of the played guesses.
	 * 
	 * @param guessHistory
	 */
	public void print(IGuessHistory guessHistory);
}
