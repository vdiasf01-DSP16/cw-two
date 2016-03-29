package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import controllers.IPegCreator;
import controllers.PegCreatorImpl;
import controllers.exception.InvalidGuessInput;
import controllers.exception.NonExistingColourException;

/**
 * Testing the IPegCreator implementation.
 * 
 * @author Pedro Gordo
 *
 */
public class TestPegFactory
{

	/**
	 * The IPegCreator object handler for test.
	 */
	private IPegCreator pegCreator;

	private Map<String, String> colourList;

	/**
	 * Sets up a colour list that will be used as a dictionary to generate pegs.
	 */
	@Before
	public void setUp()
	{
		this.colourList = new HashMap<>();
		this.colourList.put("B", "Blue"); //$NON-NLS-1$ //$NON-NLS-2$
		this.pegCreator = new PegCreatorImpl(this.colourList);
	}

	/**
	 * Test that we get exception when we can't generate a peg.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = NonExistingColourException.class)
	public void testExceptionWithNonExistingColour() throws InvalidGuessInput, NonExistingColourException
	{
		this.pegCreator.createPeg("Not known colour"); //$NON-NLS-1$
	}

	/**
	 * Test Peg found is of a known colour.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testKnownColourGetPeg() throws InvalidGuessInput, NonExistingColourException
	{
		String expected = "Blue"; //$NON-NLS-1$
		String actual = null;
		actual = this.pegCreator.createPeg("B").getColourName(); //$NON-NLS-1$
		assertEquals(expected, actual);
	}
	
	/**
	 * Test that we get a non null peg.
	 */
	@Test
	public void testGetAPeg()
	{
		assertNotNull(this.pegCreator.createRandomPeg());
	}
}
