package controllers;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.exception.GuessHistoryFull;
import controllers.exception.InvalidGuessSizeInput;
import controllers.exception.NonExistingColourException;
import models.GuessPlayFactory;
import models.IGuessPlay;
import models.IPeg;
import views.CaptureUserGuessFactory;
import views.ICaptureUserGuess;
import views.ILastText;
import views.IPrintHistory;
import views.IPrintSecretCode;
import views.IShowNumberOfTries;
import views.IStartText;
import views.ITextBeforeGuess;
import views.LastTextFactory;
import views.PrintHistoryFactory;
import views.PrintSecretCodeFactory;
import views.ShowNumberOfTriesFactory;
import views.StartTextFactory;
import views.TextBeforeGuessFactory;

/**
 * @author Keith Mannock
 *
 */
class GameImpl extends GameAbstractImpl
{
	@Inject
	private GameImpl(@Named("easy") boolean easy)
	{
		super(easy);
	}

	@Override
	public void runGames()
	{
		/*
		 * Get reusable objects from factories (they are still immutable though...)
		 */
		ICodeGenerator codeGenerator = CodeGeneratorFactory.create();
		IStartText startText = StartTextFactory.factoryMethod();
		ICaptureUserGuess captureUserGuess = CaptureUserGuessFactory
				.factoryMethod();
		IGuessChecker guessChecker = GuessCheckerFactory.create();
		IPrintSecretCode printSecretCode = PrintSecretCodeFactory.create();
		IPrintHistory printHistory = PrintHistoryFactory.create();
		IShowNumberOfTries showNumberOfTries = ShowNumberOfTriesFactory
				.create();
		ITextBeforeGuess textBeforeGuess = TextBeforeGuessFactory.create();
		ILastText lastText = LastTextFactory.create();

		/*
		 * Start the game run
		 */
		startText.show();

		boolean keepPlaying = true;
		do
		{
			// initialise these at each new game iteration
			List<IPeg> secretCode = codeGenerator.generateNewCode();
			IFlowController flowController = FlowControllerFactory
					.factoryMethod();

			do
			{
				if (this.showCode)
				{
					printSecretCode.show(secretCode);
				}

				if (flowController.getHistory().getPlayHistory()
						.isEmpty() == false)
				{
					printHistory.printProgressingHistory(flowController.getHistory());
				}

				showNumberOfTries.show(flowController.getNumberOfTriesLeft());

				List<IPeg> userGuess = null;
				List<IPeg> result = null;
				boolean userInputIsValid = false;
				do
				{
					textBeforeGuess.show();
					try
					{
						String userGuessInput = captureUserGuess.captureGuess();
						result = guessChecker.getResult(secretCode,
								userGuessInput);
						userInputIsValid = true;
						userGuess = guessChecker.parseUserInput(userGuessInput);
					}
					catch (NonExistingColourException | InvalidGuessSizeInput e)
					{
						// TODO after output is similar to sample, consider
						// uncomment this.
						// System.out.println(e.getMessage());
					}
				} while (userInputIsValid == false);

				IGuessPlay guessPlay = GuessPlayFactory.create(userGuess,
						result);
				try
				{
					flowController.addGuessPlay(guessPlay);
				}
				catch (GuessHistoryFull e)
				{
					e.printStackTrace();
					System.exit(1);
				}

			} while (flowController.isGameFinished() == false);

			boolean hasCorrectAnswer = flowController.hasCorrectAnswer();
			
			if (hasCorrectAnswer)
			{
				printHistory.printSuccessHistory(flowController.getHistory(), secretCode);
			}
			
			lastText.show(hasCorrectAnswer);

			keepPlaying = captureUserGuess.captureGuess().equals("Y"); //$NON-NLS-1$
		} while (keepPlaying);
	}

}
