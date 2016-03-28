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
	private List<IGuessPlay> playedList = new ArrayList<>();

	@Override
	public List<IGuessPlay> getPlayHistory()
	{
		return playedList;
	}

	@Override
	public void addGuessPlay(IGuessPlay guessPlay)
	{
		playedList.add(guessPlay);
	}
}
