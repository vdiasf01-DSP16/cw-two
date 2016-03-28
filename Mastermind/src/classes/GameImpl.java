package classes;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.ICodeGenerator;
import controllers.IColourLoader;
import controllers.IFlowController;
import controllers.IPegFactory;
import factories.CodeGeneratorFactory;
import factories.ColourLoaderFactory;
import factories.FlowControllerFactory;
import factories.PegGeneratorFactory;
import factories.StartTextFactory;
import views.IStartText;
import views.ITextBeforeGuess;
import views.TextBeforeGuessFactory;

/**
 * @author Keith Mannock
 *
 */
public class GameImpl extends GameAbstractImpl
{
	@Inject
	private PegGeneratorFactory pegGeneratorFactory;
	@Inject
	private StartTextFactory startTextFactory;
	@Inject
	private TextBeforeGuessFactory textBeforeGuessFactory;

	@Inject
	private GameImpl(@Named("easy") boolean easy)
	{
		super(easy);
	}

	@Override
	public void runGames()
	{

		// Start text
		IStartText startText = startTextFactory.factoryMethod();
		startText.show();

		// Load colours from file
		ColourLoaderFactory colourLoaderFactory = new ColourLoaderFactory();
		IColourLoader colourLoader = colourLoaderFactory.factoryMethod();

		// Create peg generator with loaded colours
		IPegFactory pegFactory = pegGeneratorFactory
				.create(colourLoader.getColours());

		CodeGeneratorFactory codeGeneratorFactory = new CodeGeneratorFactory();
		ICodeGenerator codeGenerator = codeGeneratorFactory
				.factoryMethod(pegFactory);
		codeGenerator.generateNewCode();

		FlowControllerFactory flowControllerFactory = new FlowControllerFactory();
		IFlowController flowController = flowControllerFactory.factoryMethod();

		ITextBeforeGuess textBeforeGuess = textBeforeGuessFactory
				.create(codeGenerator.getCodeString());

		/*
		 * This variable is used to know if the number of tries has finished or
		 * if the secret code was guessed
		 */
		boolean keepGuessing = false;
		do
		{
			textBeforeGuess.show();

			keepGuessing = flowController.isGameFinished();
			// TODO change condition for loop
		} while (keepGuessing);
	}

}
