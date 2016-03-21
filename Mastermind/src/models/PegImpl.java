package models;

/**
 * Peg implementation.
 * 
 * @author pdeara01
 *
 */
public class PegImpl implements IPeg {
	
	/**
	 * The Peg colour.
	 */
	private final String colour;

	/**
	 * The Peg colour Name.
	 */
	private final String colourName;

	/**
	 * Constructor
	 */
	public PegImpl(String colour, String colourName) {
		this.colour = colour;
		this.colourName = colourName;

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColour() {
		return colour;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColourName() {
		return colourName;
	}

}
