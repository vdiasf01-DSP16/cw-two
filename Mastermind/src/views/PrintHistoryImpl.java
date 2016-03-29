package views;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import models.IGuessHistory;
import models.IGuessPlay;
import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
class PrintHistoryImpl implements IPrintHistory
{

	private int codeLength;
	private String hiddenPeg;
	private String firstLineOfHistory;
	private String emptyResult;
	private String middleOfGuessHistory;
	private int numberOfPlays;

	@Inject
	public PrintHistoryImpl(@Named("codeLength") int codeLength,
			@Named("hiddenPeg") String hiddenPeg,
			@Named("firstLineOfHistory") String firstLineOfHistory,
			@Named("emptyResult") String emptyResult,
			@Named("middleOfGuessHistory") String middleOfGuessHistory,
			@Named("numberOfPlays") int numberOfPlays)
	{
		super();
		this.codeLength = codeLength;
		this.hiddenPeg = hiddenPeg;
		this.firstLineOfHistory = firstLineOfHistory;
		this.emptyResult = emptyResult;
		this.middleOfGuessHistory = middleOfGuessHistory;
		this.numberOfPlays = numberOfPlays;
	}

	@Override
	public void print(IGuessHistory guessHistory)
	{
		System.out.println();

		// print first line of history (e.g. ".... Secret Code")
		String hidden = new String();
		for (int i = 0; i < this.codeLength; i++)
		{
			hidden += this.hiddenPeg;
		}
		System.out.println(String.format(this.firstLineOfHistory, hidden));

		// print played history
		List<IGuessPlay> guessPlayList = guessHistory.getPlayHistory();
		for (IGuessPlay guessPlay : guessPlayList)
		{
			String guess = new String();
			for (IPeg peg : guessPlay.getGuessSet())
			{
				guess += peg.getColour();
			}

			String result = new String();
			if (guessPlay.getResultSet().isEmpty())
			{
				result = this.emptyResult;
			}
			else
			{
				for (IPeg peg : guessPlay.getResultSet())
				{
					result += peg.getColour();
				}
			}

			System.out
					.println(guess + " " + this.middleOfGuessHistory + result); //$NON-NLS-1$
		}

		// print lines for missing tries
		for (int i = 0; i < this.numberOfPlays - guessPlayList.size(); i++)
		{
			System.out.println(hidden);
		}
		
		System.out.println();
	}

}
