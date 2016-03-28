/**
 * 
 */
package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controllers.FlowControllerImpl;
import controllers.IFlowController;
import controllers.exception.GuessHistoryFull;

/**
 * @author Pedro Gordo
 *
 */
public class TestFlowController
{
	private IFlowController flowController;
	private int numberOfPlays = 10;

	/**
	 * Initialize the private fields.
	 */
	@Before
	public void setUp()
	{
		flowController = new FlowControllerImpl(numberOfPlays);
	}

	/**
	 * Test if after the maximum number of tries the controller says the game is
	 * finished.
	 * 
	 * @throws GuessHistoryFull
	 */
	@Test
	public void testGameIsFinished() throws GuessHistoryFull
	{
		for (int i = 0; i < numberOfPlays; i++)
		{
			flowController.addGuessPlay(null);
		}
		assertTrue(flowController.isGameFinished());
	}

	/**
	 * Test if after just a couple of plays the game is not finished.
	 * 
	 * @throws GuessHistoryFull
	 */
	@Test
	public void testGameIsNotFinished() throws GuessHistoryFull
	{
		for (int i = 0; i < 2; i++)
		{
			flowController.addGuessPlay(null);
		}
		assertFalse(flowController.isGameFinished());
	}

	/**
	 * Test if after adding plays equal to the maximum allowed minus 1, the game
	 * is not finished.
	 * 
	 * @throws GuessHistoryFull
	 */
	@Test
	public void testGameIsNotFinishedOnLastTry() throws GuessHistoryFull
	{
		for (int i = 0; i < numberOfPlays - 1; i++)
		{
			flowController.addGuessPlay(null);
		}
		assertFalse(flowController.isGameFinished());
	}

	/**
	 * @throws GuessHistoryFull
	 * 
	 */
	@Test(expected = GuessHistoryFull.class)
	public void testAddGamePlayToFullHistory() throws GuessHistoryFull
	{
		for (int i = 0; i < numberOfPlays + 1; i++)
		{
			flowController.addGuessPlay(null);
		}
	}
}
