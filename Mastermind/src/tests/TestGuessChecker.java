package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
	private final IPeg PEG_1 = new PegImpl("G", "Green"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg PEG_2 = new PegImpl("B", "Blue"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg PEG_3 = new PegImpl("Y", "Yellow"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg PEG_4 = new PegImpl("R", "Red"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The result set pegs.
	 */
	private final IPeg BLACK_PEG = new PegImpl("B", "Black"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg WHITE_PEG = new PegImpl("W", "White"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Any other peg not in the expected secret peg code.
	 */
	private final IPeg wrongColourPeg = new PegImpl("P", "Pink"); //$NON-NLS-1$ //$NON-NLS-2$

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

		when(pegGeneratorMock.createPeg("G")) //$NON-NLS-1$
				.thenReturn(new PegImpl("G", "Green")); //$NON-NLS-1$ //$NON-NLS-2$
		when(pegGeneratorMock.createPeg("B")).thenReturn(new PegImpl("B", "Blue")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		when(pegGeneratorMock.createPeg("Y")) //$NON-NLS-1$
				.thenReturn(new PegImpl("Y", "Yellow")); //$NON-NLS-1$ //$NON-NLS-2$
		when(pegGeneratorMock.createPeg("R")).thenReturn(new PegImpl("R", "Red")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		when(pegGeneratorMock.createPeg("P")).thenReturn(new PegImpl("P", "Pink")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		// The secret code to be guessed.
		this.secretCode = new ArrayList<>();
		this.secretCode.add(pegGeneratorMock.createPeg("G")); // PEG_1 //$NON-NLS-1$
		this.secretCode.add(pegGeneratorMock.createPeg("B")); // PEG_2 //$NON-NLS-1$
		this.secretCode.add(pegGeneratorMock.createPeg("Y")); // PEG_3 //$NON-NLS-1$
		this.secretCode.add(pegGeneratorMock.createPeg("R")); // PEG_4 //$NON-NLS-1$
		this.guessChecker = new GuessCheckerImpl(this.secretCode, pegGeneratorMock);
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
		String input = this.PEG_1.getColour() + this.PEG_2.getColour() + this.PEG_3.getColour()
				+ this.PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		expected.add(this.BLACK_PEG);
		expected.add(this.BLACK_PEG);
		expected.add(this.BLACK_PEG);

		// The guess peg list.
		String input = this.PEG_1.getColour() + this.PEG_2.getColour() + this.PEG_3.getColour()
				+ this.wrongColourPeg.getColour();
		List<IPeg> actual = this.guessChecker.getResult(input);

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
		String input = this.PEG_1.getColour() + this.PEG_2.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.PEG_2.getColour() + this.PEG_1.getColour() + this.PEG_3.getColour()
				+ this.PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.PEG_2.getColour() + this.PEG_1.getColour() + this.PEG_4.getColour()
				+ this.PEG_3.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.PEG_2.getColour() + this.PEG_1.getColour() + this.PEG_4.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.PEG_2.getColour() + this.wrongColourPeg.getColour()
				+ this.PEG_4.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.PEG_2.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, this.guessChecker.getResult(input).size());
		verifyResultSet(resultList, this.guessChecker.getResult(input));
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
		String input = this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, this.guessChecker.getResult(input).size());
		verifyResultSet(resultList, this.guessChecker.getResult(input));
	}

	/**
	 * Verify that the expected list of result pegs match found.
	 * 
	 * @param expectedList
	 *            IPeg
	 * @param foundList
	 *            IPeg
	 */
	private static void verifyResultSet(List<IPeg> expectedList, List<IPeg> foundList)
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
		String input = "RGBYYYY"; //$NON-NLS-1$
		List<IPeg> foundPegs = this.guessChecker.getResult(input);
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
		this.guessChecker.getResult("QGET"); //$NON-NLS-1$
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
		List<IPeg> foundPegs = this.guessChecker.getResult("QWET"); //$NON-NLS-1$
		System.out.println(foundPegs.toString());
		assertTrue(foundPegs.isEmpty());
	}
}