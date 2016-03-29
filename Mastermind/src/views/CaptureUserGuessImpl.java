/**
 * 
 */
package views;

import java.util.Scanner;

/**
 * @author Pedro Gordo
 *
 */
public class CaptureUserGuessImpl implements ICaptureUserGuess
{
	/* (non-Javadoc)
	 * @see views.ICaptureUserGuess#captureGuess()
	 */
	@Override
	public String captureGuess()
	{
		Scanner reader = new Scanner(System.in);
		String userGuess = reader.nextLine();
		reader.close();
		return userGuess;
	}
}
