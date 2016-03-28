package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import controllers.IPegGenerator;
import controllers.PegGeneratorImpl;
import models.IPeg;

/**
 * Testing the IPegGenerator implementation.
 * 
 * @author Pedro Gordo
 *
 */
public class TestPegGenerator
{

	/**
	 * The IPegGenerator object handler for test.
	 */
	private IPegGenerator pegGen;

	private Map<String, String> colourList;

	/**
	 * Sets up a colour list that will be used as a dictionary to generate pegs.
	 */
	@Before
	public void setUp()
	{
		colourList = new HashMap<>();
		colourList.put("B", "Blue");
		pegGen = new PegGeneratorImpl(colourList);
	}

	/**
	 * Test that we get exception when we can't generate a peg.
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetPegIsNull() throws Exception
	{
		IPeg foundPeg = pegGen.getPeg("Not known colour");
		assertNull(foundPeg);
	}

	/**
	 * Test Peg found is of a known colour.
	 * 
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testKnownColourGetPeg() throws IllegalArgumentException
	{
		String expected = "Blue";
		String actual = null;
		actual = pegGen.getPeg("B").getColourName();
		assertEquals(expected, actual);
	}
}
