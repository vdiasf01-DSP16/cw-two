package controllers;

import java.util.List;

import models.IPeg;
import models.PegGenerationError;

/**
 * Peg Generator, returning a random peg or a specific Peg given a colour. If
 * colour specified is not found, will return null.
 * 
 * @author pdeara01
 *
 */
public interface IPegGenerator {

	/**
	 * For the supplied colour, returns a generated Peg. If the supplied colour
	 * is not known, it will return null.
	 * 
	 * @param colour
	 * @return IPeg
	 * @throws PegGenerationError
	 *             when the peg is not found or generated correctly.
	 */
	public IPeg getPeg(String colour) throws PegGenerationError;

	/**
	 * Returns a generated Peg from a known random colour list.
	 * 
	 * @return IPeg
	 */
	public IPeg getAPeg();

	/**
	 * Returns a list of pegs based on the input colours.
	 * 
	 * @param colors
	 * @return
	 */
	public List<IPeg> getPegList(String colors);
}
