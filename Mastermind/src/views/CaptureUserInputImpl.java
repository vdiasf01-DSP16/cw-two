/**
 * 
 */
package views;

import java.util.Scanner;

import org.apache.commons.io.input.CloseShieldInputStream;

/**
 * @author Pedro Gordo
 *
 */
class CaptureUserInputImpl implements ICaptureUserGuess
{
	@Override
	public String captureGuess()
	{
		String userGuess = new String();
		try (Scanner reader = new Scanner(
				new CloseShieldInputStream(System.in)))
		{
			userGuess = reader.nextLine();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println();
		return userGuess;
	}
}
