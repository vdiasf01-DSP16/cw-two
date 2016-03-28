package controllers;

import java.util.List;

import models.IPeg;

/**
 * Peg Generator, returning a random peg or a specific Peg given a colour. If
 * colour specified is not found, will return null.
 * 
 * @author Pedro Gordo
 *
 */
public interface IPegGenerator
{

	/**
	 * For the supplied colour, returns a generated Peg. If the supplied colour
	 * is not known, it will return null.
	 * 
	 * @param colour
	 * @return IPeg
	 * @throws IllegalArgumentException
	 *             is thrown if the colour doesn't exist
	 */
	public IPeg getPeg(String colour) throws IllegalArgumentException;

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
	 * @return generated peg list
	 */
	public List<IPeg> getPegList(String colors);
}
