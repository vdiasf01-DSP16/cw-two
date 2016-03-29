package views;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Pedro Gordo
 *
 */
class LastTextImpl implements ILastText
{

	private String successText;
	private String failText;
	private String askForNextGameText;

	/**
	 * @param successText
	 * @param failText
	 * @param askForNextGameText
	 */
	@Inject
	public LastTextImpl(@Named("successText") String successText,
			@Named("failText") String failText,
			@Named("askForNextGameText") String askForNextGameText)
	{
		super();
		this.successText = successText;
		this.failText = failText;
		this.askForNextGameText = askForNextGameText;
	}

	@Override
	public void show(boolean success)
	{
		System.out.println();
		if (success)
		{
			System.out.println(this.successText);
		}
		else
		{
			System.out.println(this.failText);
		}
		System.out.print(this.askForNextGameText);
	}

}
