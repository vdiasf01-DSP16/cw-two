/**
 * 
 */
package controllers;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.exception.GuessHistoryFull;
import models.GuessHistoryFactory;
import models.IGuessHistory;
import models.IGuessPlay;

/**
 * @author Pedro Gordo
 *
 */
class FlowControllerImpl implements IFlowController
{
	private IGuessHistory guessHistory;
	private int numberOfPlays;

	/**
	 * Creates a new FlowController. One GuessHistory is created upon calling
	 * this constructor.
	 * 
	 * @param numberOfPlays
	 */
	@Inject
	public FlowControllerImpl(@Named(value = "numberOfPlays") int numberOfPlays)
	{
		super();
		this.guessHistory = GuessHistoryFactory.create();
		this.numberOfPlays = numberOfPlays;
	}

	@Override
	public boolean isGameFinished()
	{
		return this.numberOfPlays - this.guessHistory.getPlayHistory().size() == 0;
	}

	@Override
	public void addGuessPlay(IGuessPlay guessPlay) throws GuessHistoryFull
	{
		if (this.guessHistory.getPlayHistory().size()==this.numberOfPlays)
		{
			throw new GuessHistoryFull();
		}
		this.guessHistory.addGuessPlay(guessPlay);
	}

	@Override
	public IGuessHistory getHistory()
	{
		return this.guessHistory;
	}
}
