package controllers;

import models.IPeg;

/**
 * Peg Generator, returning a random peg or a specific
 * Peg given a colour. If colour specified is not found,
 * will return null.
 * 
 * @author pdeara01
 *
 */
public interface IPegGenerator {

	/**
	 * For the supplied colour, returns a generated Peg.
	 * If the supplied colour is not known, it will return null.
	 * 
	 * @param colour
	 * @return IPeg
	 */
	public IPeg getPeg(String colour);
	
	/**
	 * Returns a generated Peg from a known random colour list.
	 * 
	 * @return IPeg
	 */
	public IPeg getAPeg();

}
