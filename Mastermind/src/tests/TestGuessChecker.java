package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controllers.GuessCheckerImpl;
import controllers.IGuessChecker;
import controllers.IPegCreator;
import controllers.exception.InvalidGuessInput;
import controllers.exception.NonExistingColourException;
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
	private final IPeg wrongColourPeg = new PegImpl("P", "Pink");

	/**
	 * The secret code to be guessed.
	 */
	private List<IPeg> secretCode;

	/**
	 * The GuessChecker handler to test with.
	 */
	private IGuessChecker guessChecker;

	/**
	 * Sets up the secret code to which the guess will be matched against and
	 * create mock for PegGenerator.
	 * 
	 * @throws NonExistingColourException
	 * 
	 */
	@Before
	public void setUp() throws NonExistingColourException
	{
		IPegCreator pegGeneratorMock = Mockito.mock(IPegCreator.class);

		when(pegGeneratorMock.createPeg("G"))
				.thenReturn(new PegImpl("G", "Green"));
		when(pegGeneratorMock.createPeg("B")).thenReturn(new PegImpl("B", "Blue"));
		when(pegGeneratorMock.createPeg("Y"))
				.thenReturn(new PegImpl("Y", "Yellow"));
		when(pegGeneratorMock.createPeg("R")).thenReturn(new PegImpl("R", "Red"));
		when(pegGeneratorMock.createPeg("P")).thenReturn(new PegImpl("P", "Pink"));

		// The secret code to be guessed.
		secretCode = new LinkedList<IPeg>();
		secretCode.add(pegGeneratorMock.createPeg("G")); // PEG_1
		secretCode.add(pegGeneratorMock.createPeg("B")); // PEG_2
		secretCode.add(pegGeneratorMock.createPeg("Y")); // PEG_3
		secretCode.add(pegGeneratorMock.createPeg("R")); // PEG_4
		guessChecker = new GuessCheckerImpl(secretCode, pegGeneratorMock);
	}

	/**
	 * Testing BBBB.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBBBB() throws InvalidGuessInput, NonExistingColourException
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
	 * 
	 * @throws NonExistingColourException 
	 * @throws InvalidGuessInput 
	 */
	@Test
	public void testBBB() throws NonExistingColourException, InvalidGuessInput
	{
		// The expected result list
		List<IPeg> expected = new LinkedList<>();
		expected.add(BLACK_PEG);
		expected.add(BLACK_PEG);
		expected.add(BLACK_PEG);

		// The guess peg list.
		String input = PEG_1.getColour() + PEG_2.getColour() + PEG_3.getColour()
				+ wrongColourPeg.getColour();
		List<IPeg> actual = guessChecker.getResult(input);

		assertEquals(expected, actual);
	}

	/**
	 * Testing BB.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBB() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = PEG_1.getColour() + PEG_2.getColour()
				+ wrongColourPeg.getColour() + wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing B.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testB() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = wrongColourPeg.getColour() + wrongColourPeg.getColour()
				+ wrongColourPeg.getColour() + PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing BBWW.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBBWW() throws InvalidGuessInput, NonExistingColourException
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
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testWWWW() throws InvalidGuessInput, NonExistingColourException
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
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testWWW() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + PEG_1.getColour() + PEG_4.getColour()
				+ wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing WW.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testWW() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + wrongColourPeg.getColour()
				+ PEG_4.getColour() + wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Testing W.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testW() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = PEG_2.getColour() + wrongColourPeg.getColour()
				+ wrongColourPeg.getColour() + wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Test if the input list has the same size of a result in which we have 4
	 * pegs (black or white, doesn't matter).
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testNoPegs() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = wrongColourPeg.getColour() + wrongColourPeg.getColour()
				+ wrongColourPeg.getColour() + wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, guessChecker.getResult(input).size());
		verifyResultSet(resultList, guessChecker.getResult(input));
	}

	/**
	 * Test that the guess checker throws an exception when the input is of a
	 * different size than the secret code.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessInput.class)
	public void testInvalidInput() throws InvalidGuessInput, NonExistingColourException
	{
		// The guess peg list.
		String input = wrongColourPeg.getColour() + wrongColourPeg.getColour()
				+ wrongColourPeg.getColour();

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
	 * Testing if we get an exception if the input is of a different size than
	 * the secret code.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessInput.class)
	public void testAnyLengthValidPegs() throws InvalidGuessInput, NonExistingColourException
	{
		String input = "RGBYYYY";
		List<IPeg> foundPegs = guessChecker.getResult(input);
		assertEquals(input.length(), foundPegs.size());
	}

	/**
	 * Testing if with non existing colours we get an exception thrown.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessInput.class)
	public void testOneValidPeg() throws InvalidGuessInput, NonExistingColourException
	{
		guessChecker.getResult("QGET");
	}

	/**
	 * Check if when passing in an invalid list of peg, an empty list is
	 * returned.
	 * 
	 * @throws InvalidGuessInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessInput.class)
	public void testNoValidPegs() throws InvalidGuessInput, NonExistingColourException
	{
		List<IPeg> foundPegs = guessChecker.getResult("QWET");
		System.out.println(foundPegs.toString());
		assertTrue(foundPegs.isEmpty());
	}
}