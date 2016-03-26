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

	void generateNewCode();

	List<IPeg> getCode();
	
	public String getCodeString();
	
	public void setPegGenerator(IPegGenerator pegGenerator);
}
