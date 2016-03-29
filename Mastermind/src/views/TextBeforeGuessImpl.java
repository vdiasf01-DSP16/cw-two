/**
 * 
 */
package views;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

/**
 * @author Pedro Gordo
 *
 */
public class TextBeforeGuessImpl implements ITextBeforeGuess
{
	private final boolean easy;
	private final String textBeforeGuess;
	private final String secretCodeText;
	private final String secretCodeValue;

	/**
	 * @param easy
	 * @param secretCodeText
	 *            this text will be formatted with the generated secret code.
	 * @param textBeforeGuess
	 *            this text will be formatted with the number of plays
	 * @param numberOfPlays
	 * @param secretCodeValue
	 */
	@Inject
	public TextBeforeGuessImpl(@Named("easy") boolean easy,
			@Named("secretCodeText") String secretCodeText,
			@Named("textBeforeGuess") String textBeforeGuess,
			@Named("numberOfPlays") int numberOfPlays,
			@Assisted String secretCodeValue)
	{
		super();
		this.easy = easy;
		this.textBeforeGuess = String.format(textBeforeGuess, numberOfPlays);
		this.secretCodeText = secretCodeText;
		this.secretCodeValue = secretCodeValue;
	}

	@Override
	public void show()
	{
		if (easy)
		{
			System.out.println(String.format(secretCodeText, secretCodeValue));
		}
		System.out.print(textBeforeGuess);
	}

}
