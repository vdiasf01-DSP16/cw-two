package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.IPeg;
import models.PegImpl;

public class TestGuessChecker {

	private final IPeg PEG_1 = new PegImpl("G", "Green");
	private final IPeg PEG_2 = new PegImpl("B", "Blue");
	private final IPeg PEG_3 = new PegImpl("Y", "Yellow");
	private final IPeg PEG_4 = new PegImpl("R", "Red");

	private final IPeg BLACK_PEG = new PegImpl("B", "Black");
	private final IPeg WHITE_PEG = new PegImpl("W", "White");

	private final IPeg NOT_USED_PEG = new PegImpl("T", "Tanso");

	private List<IPeg> secretCode;

	@Before
	public void setUp() {
		secretCode = new LinkedList<IPeg>();
		secretCode.add(new PegImpl("G", "Green")); // PEG_1
		secretCode.add(new PegImpl("B", "Blue")); // PEG_2
		secretCode.add(new PegImpl("Y", "Yellow")); // PEG_3
		secretCode.add(new PegImpl("R", "Red")); // PEG_4
	}

	@Test
	public void testBBBB() {
		List<IPeg> input = new ArrayList<>();
		input.add(PEG_1);
		input.add(PEG_2);
		input.add(PEG_3);
		input.add(PEG_4);

		List<IPeg> expected = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			expected.add(BLACK_PEG);
		}

		verifyResultSet(input, expected);
	}

	@Test
	public void testWWWW() {
		List<IPeg> input = new ArrayList<>();
		input.add(PEG_2);
		input.add(PEG_1);
		input.add(PEG_4);
		input.add(PEG_3);

		List<IPeg> expected = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			expected.add(WHITE_PEG);
		}

		verifyResultSet(input, expected);
	}

	/**
	 * Test if the input list has the same size of a result in which we have 4
	 * pegs (black or white, doesn't matter).
	 */
	@Test
	public void testNoPegs() {
		List<IPeg> input = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			input.add(NOT_USED_PEG);
		}

		IGuessChecker guessChecker = new GuessCheckerImpl(input);

		assertEquals(0, guessChecker.getResultSet().size());
	}

	/**
	 * Test that the guess checker throws an exception when the input is of a
	 * different size than the secret code.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput() {
		// secret code is size 4, but we give just 3 pegs
		List<IPeg> input = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			input.add(PEG_1);
		}

		IGuessChecker guessChecker = new GuessCheckerImpl(input);
	}

	/**
	 * Verify that the expected list of pegs (initialised as generated code),
	 * match the found list in guess checker.
	 * 
	 * @param expectedResultSet
	 */
	private void verifyResultSet(List<IPeg> userGuess, List<IPeg> expectedResultSet) {
		IGuessChecker guessChecker = new GuessCheckerImpl(userGuess);
		List<IPeg> foundPegList = guessChecker.getResultSet();

		assertEquals(expectedResultSet.size(), foundPegList.size());

		for (int index = 0; index < foundPegList.size(); index++) {
			IPeg foundPeg = foundPegList.get(index);
			IPeg expectedPeg = expectedResultSet.get(index);
			assertEquals(expectedPeg.getColour(), foundPeg.getColour());
		}
	}
}
