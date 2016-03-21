package models;

import java.util.List;

/**
 * The Guess history implementation for all past plays.
 * 
 * @author pdeara01
 *
 */
public class GuessHistoryImpl implements IGuessHistory {

	/**
	 * The list of past plays.
	 */
	private List<IGuessPlay> playedList;

	/**
	 * Constructor
	 * 
	 * @param playedList
	 */
	public GuessHistoryImpl(List<IGuessPlay> playedList) {
		this.playedList = playedList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IGuessPlay> getPlayHistory() {
		return playedList;
	}
}
