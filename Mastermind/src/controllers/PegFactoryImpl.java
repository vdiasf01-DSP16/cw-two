/**
 * 
 */
package controllers;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import controllers.exception.NonExistingColourException;
import models.IPeg;
import models.PegImpl;

/**
 * @author Pedro Gordo
 *
 */
public class PegFactoryImpl implements IPegFactory
{
	private final Map<String, String> colours;

	/**
	 * Constructor for PegGenerator. It requires the loaded colours list.
	 * 
	 * @param colours
	 */
	@Inject
	public PegFactoryImpl(@Assisted Map<String, String> colours)
	{
		this.colours = colours;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.IPegFactory#getPeg(java.lang.String)
	 */
	@Override
	public IPeg getPeg(String colourCode) throws NonExistingColourException
	{
		if (colours.containsKey(colourCode) == false)
		{
			throw new NonExistingColourException();
		}

		return new PegImpl(colourCode, colours.get(colourCode));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.IPegFactory#getAPeg()
	 */
	@Override
	public IPeg getAPeg()
	{
		// TODO Auto-generated method stub
		Set<String> keySet = colours.keySet();
		int size = keySet.size();
		int random = new Random().nextInt(size);
		String colourCode = "";

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
			peg = getPeg(colourCode);
		}
		catch (NonExistingColourException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return peg;
	}
}
