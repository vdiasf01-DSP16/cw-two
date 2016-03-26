package views;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class StartTextImpl implements IStartText {
	private final String startText;

	@Inject
	public StartTextImpl(@Named("startText") String startText, 
			@Named("codeLength") int codeLength,
			@Named("numberOfPlays") int numberOfPlays) 
	{
		this.startText = String.format(startText, codeLength, numberOfPlays);
	}

	@Override
	public void show() {
		System.out.println(startText);		
	}
}
