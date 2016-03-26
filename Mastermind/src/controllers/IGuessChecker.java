/**
 * 
 */
package controllers;

import java.util.List;

import models.IPeg;

/**
 * @author pdeara01
 *
 */
public interface IGuessChecker {

	List<IPeg> getResultSet(List<IPeg> input);

}
