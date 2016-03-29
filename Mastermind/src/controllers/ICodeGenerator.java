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
	 * 
	 * @return the generated secret code
	 */
	public List<IPeg> generateNewCode();
}
