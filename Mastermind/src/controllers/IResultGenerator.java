/**
 * 
 */
package controllers;

import java.util.List;

import models.IPeg;

/**
 * TODO review if this is not a duplicate of GuessChecker
 * 
 * @author Pedro Gordo
 *
 */
public interface IResultGenerator
{

	/**
	 * 
	 * @param generatedCode
	 */
	public void setGeneratedCode(List<IPeg> generatedCode);

	/**
	 * 
	 * @param guess
	 * @return list of pegs
	 */
	public List<IPeg> getResult(List<IPeg> guess);

}
