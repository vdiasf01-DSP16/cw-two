package classes;

import controllers.ICodeGenerator;
import controllers.IFlowController;
import factories.CodeGeneratorFactory;
import factories.FlowControllerFactory;
import factories.StartTextFactory;
import factories.TextBeforeGuessFactory;
import views.IStartText;
import views.ITextBeforeGuess;

public class GameImpl extends GameAbstractImpl {

	/**
	 * Constructor.
	 *  
	 * @param easy
	 */
	public GameImpl(boolean easy) {
		super(easy);
	}
	
	@Override
	public void runGames() {

		// Start text
		StartTextFactory startTextFactory = new StartTextFactory();
		IStartText startText = startTextFactory.factoryMethod();
		startText.show();
		
		CodeGeneratorFactory codeGeneratorFactory = new CodeGeneratorFactory();
		ICodeGenerator codeGenerator = codeGeneratorFactory.factoryMethod();
		codeGenerator.generateNewCode();
		
		FlowControllerFactory flowControllerFactory = new FlowControllerFactory();
		IFlowController flowController = flowControllerFactory.factoryMethod();
		
		TextBeforeGuessFactory textBeforeGuessFactory = new TextBeforeGuessFactory();
		boolean keepGuessing = false;
		do {
			ITextBeforeGuess textBeforeGuess = textBeforeGuessFactory.factoryMethod();
			textBeforeGuess.show(showCode, codeGenerator.getCodeString());
			//TODO add guess play to guess history
			
			
			keepGuessing = flowController.isGameFinished();
		} while (keepGuessing);
	}

}
