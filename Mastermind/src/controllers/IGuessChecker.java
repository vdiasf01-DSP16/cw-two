/**
 * 
 */
package controllers;

import java.util.List;

import controllers.exception.InvalidGuessSizeInput;
import controllers.exception.NonExistingColourException;
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
	 * @param secretCode
	 *            the generated secret code for this game run
	 * @param input
	 * 
	 * @return the list of peg objects
	 * @throws NonExistingColourException
	 *             when the colour doesn't exist
	 * @throws InvalidGuessSizeInput
	 *             when the user input is not valid, for example if the guess is
	 *             the wrong length TODO make sure there's a test for each of
	 *             these cases
	 */
	public List<IPeg> getResult(List<IPeg> secretCode, String input)
			throws NonExistingColourException, InvalidGuessSizeInput;

}
