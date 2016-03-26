package classes;

import com.google.inject.Guice;

import guiceModules.GameModule;
import guiceModules.PropertiesModule;

/**
 * Factory of games.
 * 
 * @author pdeara01
 *
 */
public class Factory {

	/**
	 * The instance of the current game being played.
	 * 
	 * @param c The Game class name
	 * @param b The boolean reveal code
	 * @return The Game instance
	 */
    public static Game getInstance(Class c, Boolean b){
    	
        return Guice.createInjector(new PropertiesModule(), new GameModule()).getInstance(Game.class);
    }
}
