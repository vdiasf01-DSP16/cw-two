package tests;

import static org.junit.Assert.assertEquals;

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
public class TestGuessChecker {

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

	@Before
	public void setUp() {
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
	 */
	@Test
	public void testBBBB() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_1);
		input.add(PEG_2);
		input.add(PEG_3);
		input.add(PEG_4);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing BBB.
	 */
	@Test
	public void testBBB() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_1);
		input.add(PEG_2);
		input.add(PEG_3);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing BB.
	 */
	@Test
	public void testBB() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_1);
		input.add(PEG_2);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing B.
	 */
	@Test
	public void testB() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);
		input.add(PEG_4);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing BBWW.
	 */
	@Test
	public void testBBWW() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_2);
		input.add(PEG_1);
		input.add(PEG_3);
		input.add(PEG_4);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(BLACK_PEG);
		resultList.add(BLACK_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing WWWW.
	 */
	@Test
	public void testWWWW() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_2);
		input.add(PEG_1);
		input.add(PEG_4);
		input.add(PEG_3);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing WWW.
	 */
	@Test
	public void testWWW() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_2);
		input.add(PEG_1);
		input.add(PEG_4);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing WW.
	 */
	@Test
	public void testWW() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_2);
		input.add(NOT_USED_PEG);
		input.add(PEG_4);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Testing W.
	 */
	@Test
	public void testW() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(PEG_2);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();
		resultList.add(WHITE_PEG);

		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Test if the input list has the same size of a result in which we have 4
	 * pegs (black or white, doesn't matter).
	 */
	@Test
	public void testNoPegs() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, guessChecker.getResultSet(input).size());
		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Test that the guess checker throws an exception when the input is of a
	 * different size than the secret code.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput() {
		// The guess peg list.
		List<IPeg> input = new LinkedList<>();
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);
		input.add(NOT_USED_PEG);

		// The expected result list
		List<IPeg> resultList = new LinkedList<>();

		assertEquals(0, guessChecker.getResultSet(input).size());
		verifyResultSet(resultList, guessChecker.getResultSet(input));
	}

	/**
	 * Verify that the expected list of result pegs match found.
	 * 
	 * @param expectedList
	 *            IPeg
	 * @param foundList
	 *            IPeg
	 */
	private void verifyResultSet(List<IPeg> expectedList, List<IPeg> foundList) {
		// List must have same size.
		assertEquals(expectedList.size(), foundList.size());

		// Check each one in order
		for (int index = 0; index < expectedList.size(); index++) {
			assertEquals(expectedList.get(index).getColour(), foundList.get(index).getColour());
			assertEquals(expectedList.get(index).getColourName(), foundList.get(index).getColourName());
		}
	}
}