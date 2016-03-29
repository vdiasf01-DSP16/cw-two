/**
 * 
 */
package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.inject.Inject;

/**
 * @author Pedro Gordo
 *
 */
public class ColourLoaderImpl implements IColourLoader
{
	private final Map<String, String> colours;
	
	/**
	 * Constructor to create an instance of ColourLoader.
	 * 
	 * @param path
	 *            to the file with the colours configuration
	 */
	@Inject
	public ColourLoaderImpl(String path)
	{
		File f = new File(path);
		Scanner r = null;
		try
		{
			r = new Scanner(f);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		colours = new HashMap<>();
		
		String scan;
		while (r.hasNextLine())
		{
			scan = r.nextLine();
			String colourCode = scan.split(",")[0];
			String colourName = scan.split(",")[1];
			colours.put(colourCode, colourName);
		}
	}


	@Override
	public Map<String, String> getColours()
	{
		return colours;
	}

}
