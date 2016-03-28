/**
 * 
 */
package controllers;

import java.util.List;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
public interface IGuessChecker
{
	/**
	 * Returns a list of pegs based on the user input. This input is then
	 * checked against the secret code.
	 * 
	 * @param input
	 * @return the list of peg objects
	 * @throws IllegalArgumentException
	 *             when the user input is not valid, for example if the colour
	 *             doesn't exist or the guess is the wrong length TODO make sure
	 *             there's a test for each of these cases
	 */
	public List<IPeg> getResult(String input) throws IllegalArgumentException;
}
