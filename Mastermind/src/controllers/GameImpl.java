package controllers;

import com.google.inject.Inject;
import com.google.inject.name.Named;

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
		codeGenerator.generateNewCode();
		guessChecker.setNewSecretCode(codeGenerator.getCode());
		IFlowController flowController = FlowControllerFactory.factoryMethod();

		ITextBeforeGuess textBeforeGuess = TextBeforeGuessFactory
				.create();

		/*
		 * This variable is used to know if the number of tries has finished or
		 * if the secret code was guessed
		 */
		boolean keepGuessing = false;
		do
		{
			textBeforeGuess.show(codeGenerator.getCodeString());
			String userGuess = captureUserGuess.captureGuess();
			
			keepGuessing = flowController.isGameFinished();
		} while (keepGuessing);
	}

}
