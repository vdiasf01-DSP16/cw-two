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
public interface IStringToPeg {

	Map<Integer, IPeg> getPegs(String string);

}
