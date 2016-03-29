package views;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
class PrintSecretCodeImpl implements IPrintSecretCode
{

	private String secretCodeText;

	@Inject
	public PrintSecretCodeImpl(@Named("secretCodeText") String secretCodeText)
	{
		super();
		this.secretCodeText = secretCodeText;
	}

	@Override
	public void show(List<IPeg> secretCode)
	{
		String secretCodeString = new String();

		for (IPeg peg : secretCode)
		{
			secretCodeString += peg.getColour();
		}

		System.out
				.println(String.format(this.secretCodeText, secretCodeString));
	}

}
