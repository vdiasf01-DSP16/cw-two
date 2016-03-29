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
		colourList = new HashMap<>();
		colourList.put("B", "Blue");
		pegCreator = new PegCreatorImpl(colourList);
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
		pegCreator.createPeg("Not known colour");
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
		String expected = "Blue";
		String actual = null;
		actual = pegCreator.createPeg("B").getColourName();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test that we get a non null peg.
	 */
	@Test
	public void testGetAPeg()
	{
		assertNotNull(pegCreator.createRandomPeg());
	}
}
