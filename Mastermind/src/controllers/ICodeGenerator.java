/**
 * 
 */
package controllers;

import java.util.Map;

import models.IPeg;

/**
 * @author pdeara01
 *
 */
public interface ICodeGenerator {

	void generateNewCode();

	Map<Integer, IPeg> getCode();
}
