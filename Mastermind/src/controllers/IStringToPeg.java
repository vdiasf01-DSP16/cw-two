/**
 * 
 */
package controllers;

import java.util.Map;

import models.IPeg;
import models.PegGenerationError;

/**
 * @author pdeara01
 *
 */
public interface IStringToPeg {

	/**
	 * Accepts the guess from the user in the form of string and returns a list
	 * of pegs.
	 * 
	 * @param string
	 * @return
	 * @throws PegGenerationError
	 */
	public Map<Integer, IPeg> getPegs(String string) throws PegGenerationError;

}
