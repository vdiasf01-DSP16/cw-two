/**
 * 
 */
package controllers.exception;

/**
 * @author Pedro Gordo
 *
 */
public class NonExistingColourException extends Exception
{

	/**
	 * @param errorForNonExistingColour
	 */
	public NonExistingColourException(String errorForNonExistingColour)
	{
		super(errorForNonExistingColour);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
