package views;

import java.util.List;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
public interface ITextBeforeGuess
{
	/**
	 * Show text to be printed before the user tries to guess the secret code.
	 * 
	 * @param secretCode
	 *            the generated secret code for this game run
	 */
	public void show(List<IPeg> secretCode);
}
