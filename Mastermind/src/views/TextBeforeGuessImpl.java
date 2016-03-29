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
class TextBeforeGuessImpl implements ITextBeforeGuess
{
	private final boolean easy;
	private final String textBeforeGuess;
	private final String secretCodeText;

	/**
	 * @param easy
	 * @param secretCodeText
	 *            this text will be formatted with the generated secret code.
	 * @param textBeforeGuess
	 *            this text will be formatted with the number of plays
	 * @param numberOfPlays
	 */
	@Inject
	public TextBeforeGuessImpl(@Named("easy") boolean easy,
			@Named("secretCodeText") String secretCodeText,
			@Named("textBeforeGuess") String textBeforeGuess,
			@Named("numberOfPlays") int numberOfPlays)
	{
		super();
		this.easy = easy;
		this.textBeforeGuess = String.format(textBeforeGuess,
				new Integer(numberOfPlays));
		this.secretCodeText = secretCodeText;
	}

	@Override
	public void show(String secretCode)
	{
		if (this.easy)
		{
			System.out.println(String.format(this.secretCodeText, secretCode));
		}
		System.out.print(this.textBeforeGuess);
	}

}
