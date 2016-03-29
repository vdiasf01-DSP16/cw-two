package controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;

import controllers.exception.InvalidGuessInput;
import controllers.exception.NonExistingColourException;
import models.IPeg;
import models.PegImpl;

/**
 * Implementation for GuessChecker.
 * 
 * @author Pedro Gordo
 *
 */
class GuessCheckerImpl implements IGuessChecker
{
	// TODO create abstract pegs
	private final IPeg BLACK_PEG = new PegImpl("B", "Black"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg WHITE_PEG = new PegImpl("W", "White"); //$NON-NLS-1$//$NON-NLS-2$

	private List<IPeg> secretCode;
	private IPegCreator pegCreator;

	/**
	 * Constructor requiring the secret code.
	 * @param pegCreator
	 *            TODO Inject it
	 */
	@Inject
	public GuessCheckerImpl(IPegCreator pegCreator)
	{
		this.pegCreator = pegCreator;
	}

	@Override
	public List<IPeg> getResult(String input)
			throws NonExistingColourException, InvalidGuessInput
	{
		// parse the user input and return a map where the key is the peg
		// position
		List<IPeg> pegList = parseUserInput(input);

		// Validate arguments.
		if (pegList.size() != this.secretCode.size())
			throw new InvalidGuessInput();

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
		for (IPeg secretPeg : this.secretCode)
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
		for (int index = 0; index < this.secretCode.size(); index++)
		{
			IPeg secretPeg = this.secretCode.get(index);
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
			finalList.add(this.BLACK_PEG);
		}
		for (int i = 0; i < whitePegs; i++)
		{
			finalList.add(this.WHITE_PEG);
		}
		return finalList;
	}

	private List<IPeg> parseUserInput(String input)
			throws NonExistingColourException
	{
		// Parse user input and generate pegs
		List<String> parsedText = new ArrayList<>();
		for (char letter : input.toCharArray())
		{
			parsedText.add(Character.toString(letter));
		}

		List<IPeg> pegList = new ArrayList<>();
		for (int i = 0; i < parsedText.size(); i++)
		{
			String colour = parsedText.get(i);
			IPeg iPeg = this.pegCreator.createPeg(colour);
			if (iPeg != null)
			{
				pegList.add(iPeg);
			}
		}
		return pegList;
	}

	@Override
	public void setNewSecretCode(List<IPeg> secretCode)
	{
		this.secretCode = secretCode;
	}
}
