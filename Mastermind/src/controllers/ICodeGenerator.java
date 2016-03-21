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
public interface ICodeGenerator {

	public void generateNewCode();

	public List<IPeg> getCode();

}
