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
	 * Show text to be printed before the user tries to guess the sceret code.
	 * @param secretCode TODO
	 */
	public void show(List<IPeg> secretCode);
}
