package classes;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import factories.DisplayFactory;
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
	}

}
