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
	 *             the wrong length these cases
	 */
	public List<IPeg> getResult(List<IPeg> secretCode, String input)
			throws NonExistingColourException, InvalidGuessSizeInput;

	/**
	 * Parse the user input and return a list of pegs.
	 * 
	 * @param input
	 * @return the list of pegs from the user input
	 * @throws NonExistingColourException
	 */
	public List<IPeg> parseUserInput(String input)
			throws NonExistingColourException;
}
