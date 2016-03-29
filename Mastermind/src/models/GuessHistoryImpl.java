package models;

import java.util.ArrayList;
import java.util.List;

/**
 * The Guess history implementation for all past plays.
 * 
 * @author Pedro Gordo
 *
 */
public class GuessHistoryImpl implements IGuessHistory
{
	/**
	 * The list of past plays.
	 */
	private final List<IGuessPlay> playedList = new ArrayList<>();

	@Override
	public List<IGuessPlay> getPlayHistory()
	{
		return this.playedList;
	}

	@Override
	public void addGuessPlay(IGuessPlay guessPlay)
	{
		this.playedList.add(guessPlay);
	}
}
