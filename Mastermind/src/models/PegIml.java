package models;

/**
 * Peg implementation.
 * 
 * @author pdeara01
 *
 */
public class PegIml implements IPeg {
	
	/**
	 * The Peg colour.
	 */
	private final char colour;

	/**
	 * The Peg colour Name.
	 */
	private final String colourName;

	/**
	 * Constructor
	 */
	public PegIml(char colour, String colourName) {
		this.colour = colour;
		this.colourName = colourName;

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public char getColour() {
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
