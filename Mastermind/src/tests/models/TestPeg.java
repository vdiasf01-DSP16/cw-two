package tests.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Peg class
 * 
 * @author pdeara01
 *
 */
public class TestPeg {

	private final char COLOUR = 'R';
	private final String COLOUR_NAME = "Red";
	private IPeg peg;

	/**
	 * Initialise peg object.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		IColour red = new ColourImpl(COLOUR, COLOUR_NAME);
		peg = new PegImpl(red);
	}

	/**
	 * Test peg colour.
	 */
	@Test
	public void testColour() {
		assertEquals(COLOUR, peg.getColour());
	}

	/**
	 * Test peg colour name.
	 */
	@Test
	public void testColourName() {
		assertEquals(COLOUR_NAME, peg.getColourName());
	}

}
