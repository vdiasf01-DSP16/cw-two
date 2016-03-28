/**
 * 
 */
package controllers;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

/**
 * @author Pedro Gordo
 *
 */
public class ColourLoaderImpl implements IColourLoader
{

	/**
	 * Constructor to create an instance an instance of ColourLoader.
	 * 
	 * @param path
	 *            to the file with the colours configuration
	 */
	@Inject
	public ColourLoaderImpl(String path)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, String> getColours()
	{
		// TODO Auto-generated method stub
		return new HashMap<>();
	}

}
