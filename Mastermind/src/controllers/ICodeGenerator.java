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
public interface ICodeGenerator
{
	/**
	 * Creates a new secret code
	 */
	void generateNewCode();

	/**
	 * Returns the generated secret code.
	 * 
	 * @return the list of pegs representing the secret code.
	 */
	public List<IPeg> getCode();

	/**
	 * Returns a string with a string representation of the generated code.
	 * 
	 * @return the secret code string
	 */
	public String getCodeString();
}
