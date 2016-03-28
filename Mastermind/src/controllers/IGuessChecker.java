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
	 * Returns a list of pegs based on the provided string with the color codes.
	 * 
	 * @param input
	 * @return the list of peg objects
	 */
	public List<IPeg> getResultSet(List<IPeg> input);

}
