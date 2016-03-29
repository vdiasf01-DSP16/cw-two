package controllers;

import controllers.exception.NonExistingColourException;
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
	 * For the supplied colour, returns a generated Peg.
	 * 
	 * @param colour
	 * @return IPeg
	 * @throws NonExistingColourException
	 *             in case the colour doesn't exist in the resources/pegColours
	 *             file
	 */
	public IPeg createPeg(String colour) throws NonExistingColourException;

	/**
	 * Returns a generated Peg from a known random colour list.
	 * 
	 * @return IPeg
	 */
	public IPeg createRandomPeg();

	/**
	 * @return a black peg
	 */
	public IPeg getBlackPeg();

	/**
	 * @return a white peg
	 */
	public IPeg getWhitePeg();
}
