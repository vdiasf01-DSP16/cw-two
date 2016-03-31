package views;

/**
 * @author Pedro Gordo
 *
 */
public interface ICaptureUserGuess
{
	/**
	 * Captures the user guess from the prompt and passes it to the
	 * IGuessChecker controller.
	 * 
	 * @return the user guess entered in the prompt
	 */
	public String captureGuess();
}
