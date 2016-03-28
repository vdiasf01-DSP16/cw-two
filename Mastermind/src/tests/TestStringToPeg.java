/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import controllers.IPegGenerator;
import controllers.IStringToPeg;
import controllers.StringToPegImpl;
import models.IPeg;
import models.PegGenerationError;
import models.PegImpl;

/**
 * @author Pedro Gordo
 *
 */
public class TestStringToPeg
{

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
	private IPegGenerator pegGeneratorMock = Mockito.mock(IPegGenerator.class);

	/**
	 * The initial test setup.
	 */
	@Before
	public void setUp()
	{
		try
		{
			when(pegGeneratorMock.getPeg("G")).thenReturn(greenPeg);
			when(pegGeneratorMock.getPeg("B")).thenReturn(bluePeg);
			when(pegGeneratorMock.getPeg("Y")).thenReturn(yellowPeg);
			when(pegGeneratorMock.getPeg("R")).thenReturn(redPeg);
		}
		catch (PegGenerationError e)
		{
			e.printStackTrace();
		}

		// Instantiate StringToPeg with known list of pegs.
		stringToPeg = new StringToPegImpl(pegGeneratorMock);
	}

	/**
	 * Check if when passing in an invalid list of peg, an empty list is
	 * returned.
	 * 
	 * @throws PegGenerationError
	 */
	@Test(expected = PegGenerationError.class)
	public void testNoValidPegs() throws PegGenerationError
	{
		Map<Integer, IPeg> foundPegs = stringToPeg.getPegs("QWET");
		System.out.println(foundPegs.toString());
		assertTrue(foundPegs.isEmpty());
	}

	/**
	 * Testing if with non existing colours we get an exception thrown.
	 * 
	 * @throws PegGenerationError
	 */
	@Test(expected = PegGenerationError.class)
	public void testOneValidPeg() throws PegGenerationError
	{
		stringToPeg.getPegs("QGET");
	}

	/**
	 * Testing if all valid pegs are returned it.
	 */
	@Test
	public void testAllValidPeg()
	{
		Map<Integer, IPeg> foundPegs = null;
		try
		{
			foundPegs = stringToPeg.getPegs("RGBY");
		}
		catch (PegGenerationError e)
		{
			e.printStackTrace();
		}
		assertTrue(foundPegs.get(0).equals(redPeg));
		assertTrue(foundPegs.get(1).equals(greenPeg));
		assertTrue(foundPegs.get(2).equals(bluePeg));
		assertTrue(foundPegs.get(3).equals(yellowPeg));
	}

	/**
	 * Testing if any expected length is returned.
	 * 
	 * @throws PegGenerationError
	 */
	@Test
	public void testAnyLengthValidPegs() throws PegGenerationError
	{
		String input = "RGBYYYY";
		Map<Integer, IPeg> foundPegs = stringToPeg.getPegs(input);
		assertEquals(input.length(), foundPegs.size());
	}
}
