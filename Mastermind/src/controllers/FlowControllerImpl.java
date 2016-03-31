/**
 * 
 */
package controllers;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.exception.GuessHistoryFull;
import models.GuessHistoryFactory;
import models.IGuessHistory;
import models.IGuessPlay;
import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
class FlowControllerImpl implements IFlowController
{
	private IGuessHistory guessHistory;
	private int numberOfPlays;
	private int codeLength;

	/**
	 * Creates a new FlowController. One GuessHistory is created upon calling
	 * this constructor.
	 * 
	 * @param numberOfPlays
	 * @param codeLength
	 */
	@Inject
	public FlowControllerImpl(@Named(value = "numberOfPlays") int numberOfPlays,
			@Named("codeLength") int codeLength)
	{
		super();
		this.guessHistory = GuessHistoryFactory.create();
		this.numberOfPlays = numberOfPlays;
		this.codeLength = codeLength;
	}

	@Override
	public boolean isGameFinished()
	{
		boolean usedAllTries = this.numberOfPlays
				- this.guessHistory.getPlayHistory().size() == 0;

		boolean hasCorrectAnswer = hasCorrectAnswer();

		return usedAllTries || hasCorrectAnswer;
	}

	@Override
	public void addGuessPlay(IGuessPlay guessPlay) throws GuessHistoryFull
	{
		if (this.guessHistory.getPlayHistory().size() == this.numberOfPlays)
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

	@Override
	public int getNumberOfTriesLeft()
	{
		return this.numberOfPlays - this.guessHistory.getPlayHistory().size();
	}

	@Override
	public boolean hasCorrectAnswer()
	{
		int lastIndex = this.guessHistory.getPlayHistory().size() - 1;

		boolean hasCorrectAnswer = true;
		List<IPeg> lastResult = this.guessHistory.getPlayHistory()
				.get(lastIndex).getResultSet();

		if (lastResult.size() != this.codeLength)
		{
			hasCorrectAnswer = false;
		}
		else
		{
			for (IPeg peg : lastResult)
			{
				/*
				 * I know I shouldn't use a string like this, but time is
				 * pressing... And in every other place of the code you get
				 * strings by properties, so that must count for something,
				 * right?
				 */
				if (peg.getColourName() != "Black") //$NON-NLS-1$
				{
					hasCorrectAnswer = false;
				}
			}
		}

		return hasCorrectAnswer;
	}

}
