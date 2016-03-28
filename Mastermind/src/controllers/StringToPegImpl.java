/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import models.IPeg;
import models.PegGenerationError;

/**
 * @author Pedro Gordo
 *
 */
public class StringToPegImpl implements IStringToPeg
{
	private final IPegGenerator pegGenerator;

	/**
	 * Constructor that takes an instance of PegGenerator. TODO requires DI
	 * 
	 * @param pegGenerator
	 */
	@Inject
	public StringToPegImpl(IPegGenerator pegGenerator)
	{
		this.pegGenerator = pegGenerator;
	}

	@Override
	public Map<Integer, IPeg> getPegs(String string) throws PegGenerationError
	{
		List<String> parsedText = new ArrayList<>();
		for (char letter : string.toCharArray())
		{
			parsedText.add("" + letter);
		}

		Map<Integer, IPeg> pegList = new HashMap<>();
		for (int i = 0; i < parsedText.size(); i++)
		{
			String colour = parsedText.get(i);
			IPeg iPeg = pegGenerator.getPeg(colour);
			if (iPeg != null)
			{
				pegList.put(i, iPeg);
			}
		}
		
		return pegList;
	}
}
