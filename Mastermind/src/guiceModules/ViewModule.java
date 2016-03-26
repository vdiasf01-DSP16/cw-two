package guiceModules;

import com.google.inject.AbstractModule;

import views.IStartText;
import views.StartTextImpl;

public class ViewModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IStartText.class).to(StartTextImpl.class);
	}

}
