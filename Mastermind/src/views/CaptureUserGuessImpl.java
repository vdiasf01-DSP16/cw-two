/**
 * 
 */
package views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Pedro Gordo
 *
 */
class CaptureUserGuessImpl implements ICaptureUserGuess
{
	@Override
	public String captureGuess()
	{
		String userGuess = new String();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)))
		{
			userGuess = br.readLine();
			br.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return userGuess;
	}
}
