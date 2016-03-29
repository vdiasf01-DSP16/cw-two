/**
 * 
 */
package controllers;

import controllers.exception.GuessHistoryFull;
import models.IGuessHistory;
import models.IGuessPlay;

/**
 * @author Pedro Gordo
 *
 */
public interface IFlowController
{
	/**
	 * Compares the guess history with the allowed number of tries and tells us
	 * if the game has finished.
	 * 
	 * @return true if game has finished, false otherwise.
	 */
	public boolean isGameFinished();

	/**
	 * Adds a guess play to the current history.
	 * 
	 * @param guessPlay
	 * @throws GuessHistoryFull
	 *             if we're trying to add a guess play to an history which is
	 *             full based on the allowed number of plays
	 */
	public void addGuessPlay(IGuessPlay guessPlay) throws GuessHistoryFull;

	/**
	 * @return the guess history
	 */
	public IGuessHistory getHistory();

	/**
	 * @return number of tries left
	 */
	public int getNumberOfTriesLeft();

	/**
	 * @return true if the user got the answer right, false otherwise
	 */
	public boolean hasCorrectAnswer();
}
