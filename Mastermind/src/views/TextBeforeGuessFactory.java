/**
 * 
 */
package views;

/**
 * @author Pedro Gordo
 *
 */
public interface TextBeforeGuessFactory
{
	/**
	 * Creates an instance of ITextBeforeGuess.
	 * 
	 * @param secretCodeValue
	 * @return the instance created
	 */
	public ITextBeforeGuess create(String secretCodeValue);
}
