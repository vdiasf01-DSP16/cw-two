/**
 * 
 */
package controllers.exception;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Pedro Gordo
 *
 */
public class InvalidGuessSizeInput extends Exception
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param errorMessage
	 */
	@Inject
	public InvalidGuessSizeInput(@Named("errorForInvalidGuessSize") String errorMessage)
	{
		super(errorMessage);
	}
	
}
