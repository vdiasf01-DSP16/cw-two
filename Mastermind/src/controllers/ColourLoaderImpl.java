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
	 */
	@Inject
	public ColourLoaderImpl()
	{
		this.colours = new HashMap<>();
		
		File f = new File("resources/pegColours"); //$NON-NLS-1$
		try (Scanner r = new Scanner(f))
		{

			String scan;
			while (r.hasNextLine())
			{
				scan = r.nextLine();
				String colourCode = scan.split(",")[0]; //$NON-NLS-1$
				String colourName = scan.split(",")[1]; //$NON-NLS-1$
				this.colours.put(colourCode, colourName);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Map<String, String> getColours()
	{
		return this.colours;
	}

}
