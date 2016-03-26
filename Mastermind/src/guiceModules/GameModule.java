package guiceModules;

import com.google.inject.AbstractModule;

import classes.Game;
import classes.GameImpl;

public class GameModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Game.class).to(GameImpl.class);
	}

}
