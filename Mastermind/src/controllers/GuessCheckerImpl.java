package controllers;

import java.util.ArrayList;
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
	// TODO create abstract pegs
	private final IPeg BLACK_PEG = new PegImpl("B", "Black");
	private final IPeg WHITE_PEG = new PegImpl("W", "White");

	private List<IPeg> secretCode;
	private IPegGenerator pegGenerator;

	/**
	 * Constructor requiring the secret code.
	 * 
	 * @param secretCode
	 * @param pegGenerator
	 *            TODO Inject it
	 */
	public GuessCheckerImpl(List<IPeg> secretCode, IPegGenerator pegGenerator)
	{
		this.secretCode = secretCode;
		this.pegGenerator = pegGenerator;
	}

	@Override
	public List<IPeg> getResult(String input) throws IllegalArgumentException
	{
		// parse the user input and return a map where the key is the peg
		// position
		List<IPeg> pegList = parseUserInput(input);

		// Validate arguments.
		if (pegList.size() != secretCode.size())
			throw new IllegalArgumentException(
					"The length of the secret code and user guess don't match!");

		List<IPeg> finalList = new LinkedList<>();
		int blackPegs = 0;
		int whitePegs = 0;

		// First count all user guess pegs that match on secret code colours as
		// white pegs
		// Then count how many user guess pegs match colour and index on black
		// pegs.
		// Subtract the now set as black peginput colour from the white peg
		// count.

		// All matched colours regardless of index
		List<IPeg> matchedPegByColour = new LinkedList<>();
		for (IPeg secretPeg : secretCode)
		{
			// Look for user guess pegs that match this secret peg colour
			for (IPeg guessPeg : pegList)
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
			IPeg guessPeg = pegList.get(index);

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

	private List<IPeg> parseUserInput(String input) throws IllegalArgumentException
	{
		// Parse user input and generate pegs
		List<String> parsedText = new ArrayList<>();
		for (char letter : input.toCharArray())
		{
			parsedText.add("" + letter);
		}

		List<IPeg> pegList = new ArrayList<>();
		for (int i = 0; i < parsedText.size(); i++)
		{
			String colour = parsedText.get(i);
			IPeg iPeg = pegGenerator.getPeg(colour);
			if (iPeg != null)
			{
				pegList.add(iPeg);
			}
		}
		return pegList;
	}
}
