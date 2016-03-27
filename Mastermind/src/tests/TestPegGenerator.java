package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import controllers.IPegGenerator;
import controllers.PegGeneratorImpl;
import models.IPeg;
import models.PegGenerationError;

/**
 * Testing the IPegGenerator implementation.
 * 
 * @author pdeara01
 *
 */
public class TestPegGenerator {

	/**
	 * The IPegGenerator object handler for test.
	 */
	public IPegGenerator pegGen;

	public Map<String, String> colourList;

	@Before
	public void setUp() {
		colourList = new HashMap<>();
		colourList.put("B", "Blue");
		pegGen = new PegGeneratorImpl(colourList);
	}

	/**
	 * Test that we get exception when we can't generate a peg.
	 * 
	 * @throws Exception
	 */
	@Test(expected = PegGenerationError.class)
	public void testGetPegIsNull() throws Exception {
		IPeg foundPeg = pegGen.getPeg("Not known colour");
		assertNull(foundPeg);
	}

	/**
	 * Test Peg found is of a known colour.
	 */
	@Test
	public void testKnownColourGetPeg() {
		String expected = "Blue";
		String actual = null;
		try {
			actual = pegGen.getPeg("B").getColourName();
		} catch (PegGenerationError e) {
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
}
