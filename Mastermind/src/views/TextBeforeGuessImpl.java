/**
 * 
 */
package views;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Pedro Gordo
 *
 */
public class TextBeforeGuessImpl implements ITextBeforeGuess
{

	private final String secretCodeText;
	private final String textBeforeGuess;

	/**
	 * @param secretCodeText
	 *            this text will be formatted with the generated secret code.
	 * @param textBeforeGuess
	 *            this text will be formatted with the number of plays
	 * @param numberOfPlays
	 */
	@Inject
	public TextBeforeGuessImpl(@Named("secretCodeText") String secretCodeText,
			@Named("textBeforeGuess") String textBeforeGuess,
			@Named("numberOfPlays") int numberOfPlays)
	{
		super();
		this.secretCodeText = secretCodeText;
		this.textBeforeGuess = String.format(textBeforeGuess, numberOfPlays);
	}

	@Override
	public void show(boolean easy, String secretCode)
	{
		if (easy)
		{
			System.out.println(String.format(secretCodeText, secretCode));
		}
		System.out.println(textBeforeGuess);
	}

}
