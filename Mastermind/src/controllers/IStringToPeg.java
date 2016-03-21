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
public interface IStringToPeg {

	List<IPeg> getPegs(String string);

}
