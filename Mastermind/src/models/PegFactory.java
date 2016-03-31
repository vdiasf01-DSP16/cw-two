package models;

/**
 * @author Pedro Gordo
 *
 */
public class PegFactory
{
	/**
	 * Creates a Peg with the provided values.
	 * 
	 * @param colour
	 * @param colourName
	 * @return the peg created
	 */
	public static IPeg create(String colour, String colourName)
	{
		return new PegImpl(colour, colourName);
	}
}
