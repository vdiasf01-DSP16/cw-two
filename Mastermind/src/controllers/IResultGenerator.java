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
public interface IResultGenerator {

	void setGeneratedCode(List<IPeg> generatedCode);

	List<IPeg> getResult(List<IPeg> guess);

}
