package models;

import java.util.List;

/**
 * The guess play interface for each historical play.
 * 
 * @author pdeara01
 *
 */
public interface IGuessPlay {

	/**
	 * The list of pegs played.
	 * 
	 * @return List IPeg
	 */
	public List<IPeg> getGuessSet();
	
	/**
	 * The list of results for guessed play.
	 * 
	 * @return List IPeg
	 */
	public List<IPeg> getResultSet();
}
