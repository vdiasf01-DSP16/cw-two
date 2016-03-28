package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import controllers.IPegFactory;
import controllers.PegFactoryImpl;
import controllers.exception.InvalidGuessInput;
import controllers.exception.NonExistingColourException;

/**
 * Testing the IPegFactory implementation.
 * 
 * @author Pedro Gordo
 *
 */
public class TestPegFactory
{

	/**
	 * The IPegFactory object handler for test.
	 */
	private IPegFactory pegFactory;

	private Map<String, String> colourList;

	/**
	 * Sets up a colour list that will be used as a dictionary to generate pegs.
	 */
	@Before
	public void setUp()
	{
		colourList = new HashMap<>();
		colourList.put("B", "Blue");
		pegFactory = new PegFactoryImpl(colourList);
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
		pegFactory.getPeg("Not known colour");
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
		actual = pegFactory.getPeg("B").getColourName();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test that we get a non null peg.
	 */
	@Test
	public void testGetAPeg()
	{
		assertNotNull(pegFactory.getAPeg());
	}
}
