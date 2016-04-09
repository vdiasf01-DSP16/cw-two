package controllers;

import static models.PegFactory.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controllers.exception.InvalidGuessSizeInput;
import controllers.exception.NonExistingColourException;
import models.IPeg;

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
	private final IPeg PEG_1 = create("G", "Green"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg PEG_2 = create("B", "Blue"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg PEG_3 = create("Y", "Yellow"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg PEG_4 = create("R", "Red"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The result set pegs.
	 */
	private final IPeg BLACK_PEG = create("B", "Black"); //$NON-NLS-1$ //$NON-NLS-2$
	private final IPeg WHITE_PEG = create("W", "White"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Any other peg not in the expected secret peg code.
	 */
	private final IPeg wrongColourPeg = create("P", "Pink"); //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * The secret code to be guessed.
	 */
	private List<IPeg> secretCode;

	/**
	 * The GuessChecker handler to test with.
	 */
	private IGuessChecker guessChecker;
	private IPegGenerator pegGeneratorMock = Mockito.mock(IPegGenerator.class);

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
//		IPegGenerator pegGeneratorMock = Mockito.mock(IPegGenerator.class);

		when(this.pegGeneratorMock.createPeg("G")) //$NON-NLS-1$
				.thenReturn(create("G", "Green")); //$NON-NLS-1$ //$NON-NLS-2$
		when(this.pegGeneratorMock.createPeg("B")).thenReturn(create("B", "Blue")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		when(this.pegGeneratorMock.createPeg("Y")) //$NON-NLS-1$
				.thenReturn(create("Y", "Yellow")); //$NON-NLS-1$ //$NON-NLS-2$
		when(this.pegGeneratorMock.createPeg("R")).thenReturn(create("R", "Red")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		when(this.pegGeneratorMock.createPeg("P")).thenReturn(create("P", "Pink")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		when(this.pegGeneratorMock.getBlackPeg()).thenReturn(create("B", "Black")); //$NON-NLS-1$ //$NON-NLS-2$
		when(this.pegGeneratorMock.getWhitePeg()).thenReturn(create("W", "White")); //$NON-NLS-1$ //$NON-NLS-2$

		// The secret code to be guessed.
		this.secretCode = new ArrayList<>();
		this.secretCode.add(this.pegGeneratorMock.createPeg("G")); // PEG_1 //$NON-NLS-1$
		this.secretCode.add(this.pegGeneratorMock.createPeg("B")); // PEG_2 //$NON-NLS-1$
		this.secretCode.add(this.pegGeneratorMock.createPeg("Y")); // PEG_3 //$NON-NLS-1$
		this.secretCode.add(this.pegGeneratorMock.createPeg("R")); // PEG_4 //$NON-NLS-1$
		this.guessChecker = new GuessCheckerImpl(this.pegGeneratorMock, null);
	}

	/**
	 * Testing BBBB.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBBBB() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_1.getColour() + this.PEG_2.getColour() + this.PEG_3.getColour()
				+ this.PEG_4.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing BBWW.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBBWW() throws InvalidGuessSizeInput, NonExistingColourException
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

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing WWWW.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testWWWW() throws InvalidGuessSizeInput, NonExistingColourException
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

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing BBB.
	 * 
	 * @throws NonExistingColourException 
	 * @throws InvalidGuessSizeInput 
	 */
	@Test
	public void testBBB() throws NonExistingColourException, InvalidGuessSizeInput
	{
		// The guess peg list.
		String input = this.PEG_1.getColour() + this.PEG_2.getColour() + this.PEG_3.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing BBW.
	 * 
	 * @throws NonExistingColourException 
	 * @throws InvalidGuessSizeInput 
	 */
	@Test
	public void testBBW() throws NonExistingColourException, InvalidGuessSizeInput
	{
		// The guess peg list.
		String input = this.PEG_1.getColour() + this.PEG_2.getColour() + this.PEG_4.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing BWW.
	 * 
	 * @throws NonExistingColourException 
	 * @throws InvalidGuessSizeInput 
	 */
	@Test
	public void testBWW() throws NonExistingColourException, InvalidGuessSizeInput
	{
		// The guess peg list.
		String input = this.PEG_1.getColour() + this.PEG_3.getColour() + this.PEG_4.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing WWW.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testWWW() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_2.getColour() + this.PEG_1.getColour() + this.PEG_4.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);
		
		List<IPeg> actual = this.guessChecker.getResult(this.secretCode, input);

		verifyResultSet(resultList, actual);
	}

	/**
	 * Testing BB.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBB() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_1.getColour() + this.PEG_2.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing BW.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testBW() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_2.getColour() + this.wrongColourPeg.getColour()
				+ this.PEG_3.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing WW.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testWW() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_2.getColour() + this.wrongColourPeg.getColour()
				+ this.PEG_4.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing B.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testB() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_1.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing B2.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testB2() throws InvalidGuessSizeInput, NonExistingColourException
	{
		List<IPeg> secretCode1 = new LinkedList<>();
		// The secret code to be guessed.
		secretCode1.add(this.pegGeneratorMock.createPeg("G")); //$NON-NLS-1$
		secretCode1.add(this.pegGeneratorMock.createPeg("B")); //$NON-NLS-1$
		secretCode1.add(this.pegGeneratorMock.createPeg("Y")); //$NON-NLS-1$
		secretCode1.add(this.pegGeneratorMock.createPeg("G")); //$NON-NLS-1$

		// The guess peg list.
		String input = this.PEG_1.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.BLACK_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(secretCode1, input));
	}

	/**
	 * Testing W.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testW() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.PEG_2.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(this.WHITE_PEG);

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Test if the input list has the same size of a result in which we have 4
	 * pegs (black or white, doesn't matter).
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testNoPegs() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		
		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Test that the guess checker throws an exception when the input is of a
	 * different size than the secret code.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessSizeInput.class)
	public void testInvalidInput() throws InvalidGuessSizeInput, NonExistingColourException
	{
		// The guess peg list.
		String input = this.wrongColourPeg.getColour() + this.wrongColourPeg.getColour()
				+ this.wrongColourPeg.getColour();

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		verifyResultSet(resultList, this.guessChecker.getResult(this.secretCode, input));
	}

	/**
	 * Testing if we get an exception if the input is of a different size than
	 * the secret code.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessSizeInput.class)
	public void testAnyLengthValidPegs() throws InvalidGuessSizeInput, NonExistingColourException
	{
		String input = "RGBYYYY"; //$NON-NLS-1$
		List<IPeg> foundPegs = this.guessChecker.getResult(this.secretCode, input);
		assertEquals(input.length(), foundPegs.size());
	}

	/**
	 * Testing if with non existing colours we get an exception thrown.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessSizeInput.class)
	public void testOneValidPeg() throws InvalidGuessSizeInput, NonExistingColourException
	{
		this.guessChecker.getResult(this.secretCode, "QGET"); //$NON-NLS-1$
	}

	/**
	 * Check if when passing in an invalid list of peg, an empty list is
	 * returned.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = InvalidGuessSizeInput.class)
	public void testNoValidPegs() throws InvalidGuessSizeInput, NonExistingColourException
	{
		List<IPeg> foundPegs = this.guessChecker.getResult(this.secretCode, "QWET"); //$NON-NLS-1$
		System.out.println(foundPegs.toString());
		assertTrue(foundPegs.isEmpty());
	}

	/**
	 * Verify that the expected list of result pegs match found.
	 * 
	 * @param expectedList IPeg
	 * @param foundList IPeg
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
}