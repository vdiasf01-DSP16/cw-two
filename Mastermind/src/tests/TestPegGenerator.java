package tests;

import static org.junit.Assert.*;

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
	 * Test null on get peg for an unknown colour.
	 */
	@Test
	public void testGetPegIsNull() {
		IPeg foundPeg = pegGen.getPeg("Not known colour");
		assertNull(foundPeg);
	}
	
	/**
	 * Test not null on get a peg.
	 */
	@Test
	public void testGetAPeg() {
		IPeg foundPeg = pegGen.getAPeg();
		assertNotNull(foundPeg);
	}
	
	/**
	 * Test Peg found is of a known colour.
	 */
	@Test
	public void testKnownColourGetPeg() {
		String expected = "Blue";
		String actual = pegGen.getPeg("B").getColourName();
		assertEquals(expected, actual);
	}
}
