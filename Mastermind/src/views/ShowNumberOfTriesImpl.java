package views;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Pedro Gordo
 *
 */
class ShowNumberOfTriesImpl implements IShowNumberOfTries
{

	private String numberOfTriesText;

	/**
	 * @param numberOfTriesText
	 */
	@Inject
	public ShowNumberOfTriesImpl(
			@Named("numberOfTriesText") String numberOfTriesText)
	{
		super();
		this.numberOfTriesText = numberOfTriesText;
	}

	@Override
	public void show(int triesLeft)
	{
		System.out.println(
				String.format(this.numberOfTriesText, new Integer(triesLeft)));
		System.out.println();
	}

}
