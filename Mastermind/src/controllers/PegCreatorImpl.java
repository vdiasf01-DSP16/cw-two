/**
 * 
 */
package controllers;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.google.inject.Inject;

import controllers.exception.NonExistingColourException;
import models.IPeg;
import models.PegImpl;

/**
 * @author Pedro Gordo
 *
 */
class PegCreatorImpl implements IPegCreator
{
	private final Map<String, String> colours;

	/**
	 * Constructor for PegGenerator. It requires the loaded colours list.
	 * 
	 * @param coloursLoader
	 */
	@Inject
	public PegCreatorImpl(IColourLoader coloursLoader)
	{
		this.colours = coloursLoader.getColours();
	}

	@Override
	public IPeg createPeg(String colourCode) throws NonExistingColourException
	{
		if (this.colours.containsKey(colourCode) == false)
		{
			throw new NonExistingColourException();
		}

		return new PegImpl(colourCode, this.colours.get(colourCode));
	}

	@Override
	public IPeg createRandomPeg()
	{
		Set<String> keySet = this.colours.keySet();
		int size = keySet.size();
		int random = new Random().nextInt(size);
		String colourCode = new String();

		int i = 0;
		for (String key : keySet)
		{
			if (i == random)
			{
				colourCode = key;
			}
			i++;
		}

		IPeg peg = null;
		try
		{
			peg = createPeg(colourCode);
		}
		catch (NonExistingColourException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return peg;
	}
}
