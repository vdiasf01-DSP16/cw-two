/**
 * 
 */
package controllers;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.exception.NonExistingColourException;
import models.IPeg;
import static models.PegFactory.create;

/**
 * @author Pedro Gordo
 *
 */
class PegGeneratorImpl implements IPegGenerator
{
	private final Map<String, String> colours;
	private final String errorForNonExistingColour;

	/**
	 * Constructor for PegGenerator. It requires the loaded colours list.
	 * 
	 * @param coloursLoader
	 * @param errorForNonExistingColour
	 */
	@Inject
	public PegGeneratorImpl(IColourLoader coloursLoader,
			@Named("errorForNonExistingColour") String errorForNonExistingColour)
	{
		this.colours = coloursLoader.getColours();
		this.errorForNonExistingColour = errorForNonExistingColour;
	}

	@Override
	public IPeg createPeg(String colourCode) throws NonExistingColourException
	{
		if (this.colours.containsKey(colourCode) == false)
		{
			throw new NonExistingColourException(
					this.errorForNonExistingColour);
		}

		return create(colourCode, this.colours.get(colourCode));
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

	@Override
	public IPeg getBlackPeg()
	{
		return create("B", "Black"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public IPeg getWhitePeg()
	{
		return create("W", "White"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
