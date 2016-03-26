package classes;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.IFlowController;
import factories.DisplayFactory;
import factories.FlowControllerFactory;
import factories.StartTextFactory;
import views.IStartText;

public class GameImpl extends GameAbstractImpl {

	@Inject
	public GameImpl(@Named("easy") boolean easy) {
		super(easy);
	}

	@Override
	public void runGames() {

		// Start text
		DisplayFactory startTextFactory = new StartTextFactory();
		IStartText startText = startTextFactory.factoryMethod();
		startText.show();

		// // Controls the iterations of user tries
		// boolean keepPlaying = true;
		// do {

		FlowControllerFactory flowControllerFactory = new FlowControllerFactory();
		IFlowController flowController = flowControllerFactory.factoryMethod();
		boolean keepGuessing = false;
		do {
			//TODO add guess play to guess history
			System.out.println("new iteration");
			keepGuessing = flowController.isGameFinished();
		} while (keepGuessing);

		// }while (keepPlaying);

	}

}
