package models;

import java.util.List;

/**
 * The historical data interface for all plays.
 * 
 * @author pdeara01
 *
 */
public interface IGuessHistory {

	/**
	 * The history of guesses played.
	 * 
	 * @return List IGuessPlay
	 */
	public List<IGuessPlay> getPlayHistory();
}
