/**
 * 
 */
package controllers;

/**
 * @author Pedro Gordo
 *
 */
public interface IFlowController
{
	/**
	 * Based on the guess history and number of tries per game, it tells if the
	 * game is finished or not.
	 * 
	 * @return true if game has finished, false otherwise.
	 */
	public boolean isGameFinished();
}
