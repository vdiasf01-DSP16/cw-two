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
		this.flowController = new FlowControllerImpl(this.numberOfPlays);
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
		for (int i = 0; i < this.numberOfPlays; i++)
		{
			this.flowController.addGuessPlay(null);
		}
		assertTrue(this.flowController.isGameFinished());
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
			this.flowController.addGuessPlay(null);
		}
		assertFalse(this.flowController.isGameFinished());
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
		for (int i = 0; i < this.numberOfPlays - 1; i++)
		{
			this.flowController.addGuessPlay(null);
		}
		assertFalse(this.flowController.isGameFinished());
	}

	/**
	 * @throws GuessHistoryFull
	 * 
	 */
	@Test(expected = GuessHistoryFull.class)
	public void testAddGamePlayToFullHistory() throws GuessHistoryFull
	{
		for (int i = 0; i < this.numberOfPlays + 1; i++)
		{
			this.flowController.addGuessPlay(null);
		}
	}
}
