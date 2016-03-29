package models;

/**
 * Peg implementation.
 * 
 * @author Pedro Gordo
 *
 */
public class PegImpl implements IPeg
{
	/**
	 * The Peg colour.
	 */
	private final String colour;

	/**
	 * The Peg colour Name.
	 */
	private final String colourName;

	/**
	 * @param colour
	 *            the colour code (just one letter)
	 * @param colourName
	 *            the entire colour name
	 */
	public PegImpl(String colour, String colourName)
	{
		this.colour = colour;
		this.colourName = colourName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColour()
	{
		return this.colour;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColourName()
	{
		return this.colourName;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof IPeg))
			return false;
		if (obj == this)
			return true;

		IPeg otherPeg = (IPeg) obj;

		boolean colourCodeMatch = this.getColour().equals(otherPeg.getColour());
		boolean colourNameMatch = this.getColourName()
				.equals(otherPeg.getColourName());
		return colourCodeMatch && colourNameMatch;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
