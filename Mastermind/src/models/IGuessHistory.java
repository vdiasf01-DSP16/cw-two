package models;

import java.util.List;

/**
 * The historical data interface for all plays.
 * 
 * @author Pedro Gordo
 *
 */
public interface IGuessHistory {

	/**
	 * The history of guesses played.
	 * 
	 * @return List IGuessPlay
	 */
	public List<IGuessPlay> getPlayHistory();
	
	/**
	 * Adds a GuessPlay to the current history.
	 * 
	 * @param guessPlay
	 */
	public void addGuessPlay(IGuessPlay guessPlay);
}
