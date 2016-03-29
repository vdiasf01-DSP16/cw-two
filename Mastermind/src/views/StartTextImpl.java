package views;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Pedro Gordo
 *
 */
class StartTextImpl implements IStartText
{
	private final String startText;

	/**
	 * @param startText
	 *            this text will be formatted with the code length and the
	 *            number of plays
	 * @param codeLength
	 * @param numberOfPlays
	 */
	@Inject
	public StartTextImpl(@Named("startText") String startText,
			@Named("codeLength") int codeLength,
			@Named("numberOfPlays") int numberOfPlays)
	{
		this.startText = String.format(startText, new Integer(codeLength),
				new Integer(numberOfPlays));
	}

	@Override
	public void show()
	{
		System.out.println(this.startText);
	}
}
