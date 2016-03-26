package guiceModules;

import com.google.inject.AbstractModule;

import views.IStartText;
import views.ITextBeforeGuess;
import views.StartTextImpl;
import views.TextBeforeGuessImpl;

public class ViewModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IStartText.class).to(StartTextImpl.class);
		bind(ITextBeforeGuess.class).to(TextBeforeGuessImpl.class);
	}

}
