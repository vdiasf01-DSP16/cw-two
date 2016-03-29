package controllers;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.exception.InvalidGuessSizeInput;
import controllers.exception.NonExistingColourException;
import models.IPeg;
import views.CaptureUserGuessFactory;
import views.ICaptureUserGuess;
import views.IStartText;
import views.ITextBeforeGuess;
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
		 * Initialise factories
		 */
		ICodeGenerator codeGenerator = CodeGeneratorFactory.create();
		IStartText startText = StartTextFactory.factoryMethod();
		ICaptureUserGuess captureUserGuess = CaptureUserGuessFactory
				.factoryMethod();
		IGuessChecker guessChecker = GuessCheckerFactory.create();

		/*
		 * Start the game run
		 */
		startText.show();
		List<IPeg> secretCode = codeGenerator.generateNewCode();
		IFlowController flowController = FlowControllerFactory.factoryMethod();

		ITextBeforeGuess textBeforeGuess = TextBeforeGuessFactory.create();

		/*
		 * This variable is used to know if the number of tries has finished or
		 * if the secret code was guessed
		 */
		boolean keepGuessing = false;
		do
		{
			boolean userInputIsValid = false;
			do
			{
				try
				{
					textBeforeGuess.show(secretCode);
					String userGuess = captureUserGuess.captureGuess();
					guessChecker.getResult(secretCode, userGuess);
					userInputIsValid = true;
				}
				catch (NonExistingColourException | InvalidGuessSizeInput e)
				{
					System.out.println(e.getMessage());
				}
			} while (userInputIsValid == false);

			keepGuessing = flowController.isGameFinished();
		} while (keepGuessing);
	}

}
