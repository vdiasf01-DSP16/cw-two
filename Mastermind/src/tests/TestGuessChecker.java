package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controllers.GuessCheckerImpl;
import controllers.IGuessChecker;
import models.IPeg;
import models.PegImpl;

/**
 * TYesting the Guess Checker implementation.
 * 
 * @author vdiasf01
 *
 */
public class TestGuessChecker
{

	/**
	 * Pegs to test with.
	 */
	private final IPeg PEG_1 = new PegImpl("G", "Green");
	private final IPeg PEG_2 = new PegImpl("B", "Blue");
	private final IPeg PEG_3 = new PegImpl("Y", "Yellow");
	private final IPeg PEG_4 = new PegImpl("R", "Red");

	/**
	 * The result set pegs.
	 */
	private final IPeg BLACK_PEG = new PegImpl("B", "Black");
	private final IPeg WHITE_PEG = new PegImpl("W", "White");

	/**
	 * Any other peg not in the expected secret peg code.
	 */
	private final IPeg NOT_USED_PEG = new PegImpl("T", "Tanso");

	/**
	 * The secret code to be guessed.
	 */
	private List<IPeg> secretCode;

	/**
	 * The GuessChecker handler to test with.
	 */
	private IGuessChecker guessChecker;

	/**
	 * Sets up the secret code to which the guess will be matched against.
	 */
	@Before
	public void setUp()
	{
		// The secret code to be guessed.
		secretCode = new LinkedList<IPeg>();
		secretCode.add(new PegImpl("G", "Green")); // PEG_1
		secretCode.add(new PegImpl("B", "Blue")); // PEG_2
		secretCode.add(new PegImpl("Y", "Yellow")); // PEG_3
		secretCode.add(new PegImpl("R", "Red")); // PEG_4
		guessChecker = new GuessCheckerImpl(secretCode);
	}

	/**
	 * Testing BBBB.
	 * @throws IOException 
	 */
	@Test
	public void testBBBB() throws IOException
	{
		String input = PEG_1.getColour() + PEG_2.getColour() + PEG_3.getColour()
				+ PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing BBB.
	 * @throws IOException 
	 */
	@Test
	public void testBBB() throws IOException
	{
		// The guess peg list.
		String input = PEG_1.getColour() + PEG_2.getColour() + PEG_3.getColour()
				+ NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing BB.
	 * @throws IOException 
	 */
	@Test
	public void testBB() throws IOException
	{
		// The guess peg list.
		String input = PEG_1.getColour() + PEG_2.getColour()
				+ NOT_USED_PEG.getColour() + NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing B.
	 * @throws IOException 
	 */
	@Test
	public void testB() throws IOException
	{
		// The guess peg list.
		String input = NOT_USED_PEG.getColour() + NOT_USED_PEG.getColour()
				+ NOT_USED_PEG.getColour() + PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing BBWW.
	 * @throws IOException 
	 */
	@Test
	public void testBBWW() throws IOException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + PEG_1.getColour() + PEG_3.getColour()
				+ PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing WWWW.
	 * @throws IOException 
	 */
	@Test
	public void testWWWW() throws IOException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + PEG_1.getColour() + PEG_4.getColour()
				+ PEG_3.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing WWW.
	 * @throws IOException 
	 */
	@Test
	public void testWWW() throws IOException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + PEG_1.getColour() + PEG_4.getColour()
				+ NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing WW.
	 * @throws IOException 
	 */
	@Test
	public void testWW() throws IOException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + NOT_USED_PEG.getColour()
				+ PEG_4.getColour() + NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing W.
	 * @throws IOException 
	 */
	@Test
	public void testW() throws IOException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + NOT_USED_PEG.getColour()
				+ NOT_USED_PEG.getColour() + NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Test if the input list has the same size of a result in which we have 4
	 * pegs (black or white, doesn't matter).
	 * @throws IOException 
	 */
	@Test
	public void testNoPegs() throws IOException
	{
		// The guess peg list.
		String input = NOT_USED_PEG.getColour() + NOT_USED_PEG.getColour()
				+ NOT_USED_PEG.getColour() + NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, guessChecker.getResult(input).size());
		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Test that the guess checker throws an exception when the input is of a
	 * different size than the secret code.
	 * @throws IOException 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput() throws IOException
	{
		// The guess peg list.
		String input = NOT_USED_PEG.getColour() + NOT_USED_PEG.getColour()
				+ NOT_USED_PEG.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, guessChecker.getResult(input).size());
		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Verify that the expected list of result pegs match found.
	 * 
	 * @param expectedList
	 *            IPeg
	 * @param foundList
	 *            IPeg
	 */
	private void verifyResultSet(List<IPeg> expectedList, List<IPeg> foundList)
	{
		// List must have same size.
		assertEquals(expectedList.size(), foundList.size());

		// Check each one in order
		for (int index = 0; index < expectedList.size(); index++)
		{
			assertEquals(expectedList.get(index).getColour(),
					foundList.get(index).getColour());
			assertEquals(expectedList.get(index).getColourName(),
					foundList.get(index).getColourName());
		}
	}

	/**
	 * Testing if any expected length is returned. TODO review this test
	 * 
	 * @throws IOException
	 */
	@Test
	public void testAnyLengthValidPegs() throws IOException
	{
		String input = "RGBYYYY";
		List<IPeg> foundPegs = guessChecker.getResult(input);
		assertEquals(input.length(), foundPegs.size());
	}

	/**
	 * Testing if all valid pegs are returned it.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testAllValidPeg() throws IOException
	{
		List<IPeg> foundPegs = guessChecker.getResult("RGBY");
		assertTrue(foundPegs.get(0).equals(PEG_1));
		assertTrue(foundPegs.get(1).equals(PEG_2));
		assertTrue(foundPegs.get(2).equals(PEG_3));
		assertTrue(foundPegs.get(3).equals(PEG_4));
	}

	/**
	 * Testing if with non existing colours we get an exception thrown.
	 * 
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testOneValidPeg() throws IOException
	{
		guessChecker.getResult("QGET");
	}

	/**
	 * Check if when passing in an invalid list of peg, an empty list is
	 * returned.
	 * 
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testNoValidPegs() throws IOException
	{
		List<IPeg> foundPegs = guessChecker.getResult("QWET");
		System.out.println(foundPegs.toString());
		assertTrue(foundPegs.isEmpty());
	}
}