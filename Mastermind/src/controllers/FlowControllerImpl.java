/**
 * 
 */
package controllers;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import models.GuessHistoryImpl;
import models.IGuessHistory;

/**
 * @author Pedro Gordo
 *
 */
public class FlowControllerImpl implements IFlowController {

	private IGuessHistory guessHistory = new GuessHistoryImpl();
	@Inject @Named(value = "numberOfPlays")
	private int numberOfPlays;
	
	/* (non-Javadoc)
	 * @see controllers.IFlowController#isGameFinished()
	 */
	@Override
	public boolean isGameFinished() {
		return numberOfPlays - guessHistory.getPlayHistory().size() >= 0;
	}
}
