package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
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
	@Test(expected = IOException.class)
	public void testGetPegIsNull() throws Exception
	{
		IPeg foundPeg = pegGen.getPeg("Not known colour");
		assertNull(foundPeg);
	}

	/**
	 * Test Peg found is of a known colour.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testKnownColourGetPeg() throws IOException
	{
		String expected = "Blue";
		String actual = null;
		actual = pegGen.getPeg("B").getColourName();
		assertEquals(expected, actual);
	}
}
