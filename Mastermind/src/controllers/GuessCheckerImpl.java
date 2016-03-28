package controllers;

import java.util.LinkedList;
import java.util.List;

import models.IPeg;
import models.PegImpl;

/**
 * Implementation for GuessChecker.
 * 
 * @author Pedro Gordo
 *
 */
public class GuessCheckerImpl implements IGuessChecker
{
	private final IPeg BLACK_PEG = new PegImpl("B", "Black");
	private final IPeg WHITE_PEG = new PegImpl("W", "White");

	private List<IPeg> secretCode;

	/**
	 * Constructor requiring the secret code.
	 * 
	 * @param secretCode
	 */
	public GuessCheckerImpl(List<IPeg> secretCode)
	{
		this.secretCode = secretCode;
	}

	@Override
	public List<IPeg> getResultSet(List<IPeg> userGuess)
	{
		// Validate arguments.
		if (userGuess.size() != secretCode.size())
			throw new IllegalArgumentException(
					"Secret code and user guess does not match!");

		List<IPeg> finalList = new LinkedList<>();
		int blackPegs = 0;
		int whitePegs = 0;

		// First count all user guess pegs that match on secret code colours as
		// white pegs
		// Then count how many user guess pegs match colour and index on black
		// pegs.
		// Subtract the now set as black peg colour from the white peg count.

		// All matched colours regardless of index
		List<IPeg> matchedPegByColour = new LinkedList<>();
		for (IPeg secretPeg : secretCode)
		{
			// Look for user guess pegs that match this secret peg colour
			for (IPeg guessPeg : userGuess)
			{
				if (guessPeg.getColour().equals(secretPeg.getColour()))
				{
					matchedPegByColour.add(secretPeg);
					whitePegs++;
					break;
				}
			}
		}

		// Subtract from white count the pegs that also match index.
		for (int index = 0; index < secretCode.size(); index++)
		{
			IPeg secretPeg = secretCode.get(index);
			IPeg guessPeg = userGuess.get(index);

			// If index and colour match, it is a black peg and not white
			if (secretPeg.getColour().equals(guessPeg.getColour()))
			{
				blackPegs++;
				whitePegs--;
			}
		}

		// The number of white and black pegs expected in the result.
		for (int i = 0; i < blackPegs; i++)
		{
			finalList.add(BLACK_PEG);
		}
		for (int i = 0; i < whitePegs; i++)
		{
			finalList.add(WHITE_PEG);
		}
		return finalList;
	}
}
