/**
 * 
 */
package views;

import java.util.Scanner;

/**
 * @author Pedro Gordo
 *
 */
class CaptureUserGuessImpl implements ICaptureUserGuess
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see views.ICaptureUserGuess#captureGuess()
	 */
	@Override
	public String captureGuess()
	{
		String userGuess = new String();
		try (Scanner reader = new Scanner(System.in))
		{
			reader.nextLine();
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return userGuess;
	}
}
