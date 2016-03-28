package views;

/**
 * @author Pedro Gordo
 *
 */
public interface ITextBeforeGuess
{
	/**
	 * TODO remove arguments. These should be injected.
	 * @param easy
	 * @param secretCode
	 */
	public void show(boolean easy, String secretCode);
}
