/**
 * 
 */
package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import controllers.IPegGenerator;
import controllers.IStringToPeg;
import controllers.StringToPegImpl;
import models.IPeg;
import models.PegImpl;

/**
 * @author pdeara01
 *
 */
public class TestStringToPeg {

	/**
	 * List of known pegs.
	 */
	private IPeg greenPeg = new PegImpl("G", "Green");
	private IPeg bluePeg = new PegImpl("B", "Blue");
	private IPeg yellowPeg = new PegImpl("Y", "Yellow");
	private IPeg redPeg = new PegImpl("R", "Red");

	/**
	 * The StringToPegs handler
	 */
	private IStringToPeg stringToPeg;
	
	/**
	 * The peg generator mock.
	 */
	@Mock
	private IPegGenerator pegGeneratorMock;

	/**
	 * The initial test setup.
	 */
	@Before
	public void setUp()  {
		when(pegGeneratorMock.getPeg("G")).thenReturn(greenPeg);
		when(pegGeneratorMock.getPeg("B")).thenReturn(bluePeg);
		when(pegGeneratorMock.getPeg("Y")).thenReturn(yellowPeg);
		when(pegGeneratorMock.getPeg("R")).thenReturn(redPeg);

		// Instantiate StringToPeg with known list of pegs.
		stringToPeg = new StringToPegImpl(pegGeneratorMock);
	}

	/**
	 * Check if when passing in an invalid list of peg, 
	 * an empty list is returned.
	 */
	@Test
	public void testNoValidPegs() {
		List<IPeg> foundPegs = stringToPeg.getPegs("QWET");
		assertTrue(foundPegs.isEmpty());
	}
	
	/**
	 * Testing if one peg if valid, it returns it in the same
	 * index it was initially given.
	 */
	@Test
	public void testOneValidPeg() {
		List<IPeg> foundPegs = stringToPeg.getPegs("QGET");
		assertTrue(foundPegs.get(1).equals(greenPeg));
	}

	/**
	 * Testing if all valid pegs are returned it.
	 */
	@Test
	public void testAllValidPeg() {
		List<IPeg> foundPegs = stringToPeg.getPegs("RGBY");
		assertTrue(foundPegs.get(0).equals(redPeg));
		assertTrue(foundPegs.get(1).equals(greenPeg));
		assertTrue(foundPegs.get(2).equals(bluePeg));
		assertTrue(foundPegs.get(3).equals(yellowPeg));
	}

	/**
	 * Testing if any expected length is returned.
	 */
	@Test
	public void testAnyLengthValidPegs() {
		List<IPeg> foundPegs = stringToPeg.getPegs("RGBYYYY");
		assertTrue(foundPegs.get(0).equals(redPeg));
		assertTrue(foundPegs.get(1).equals(greenPeg));
		assertTrue(foundPegs.get(2).equals(bluePeg));
		assertTrue(foundPegs.get(3).equals(yellowPeg));
		assertTrue(foundPegs.get(4).equals(yellowPeg));
		assertTrue(foundPegs.get(5).equals(yellowPeg));
		assertTrue(foundPegs.get(6).equals(yellowPeg));
	}
}
