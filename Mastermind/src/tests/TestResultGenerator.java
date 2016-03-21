/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import controllers.IPegGenerator;
import models.IPeg;
import models.PegImpl;

/**
 * Test the class that will evaluate guesses.
 * 
 * @author pdeara01
 *
 */
public class TestResultGenerator {

	/**
	 * The Generated code.
	 */
	private final List<IPeg> generatedCode;
	
	/**
	 * The White colour name
	 */
	private final String WHITE_COLOUR_NAME = "White";

	/**
	 * The White colour
	 */
	private final String WHITE_COLOUR = "W";

	/**
	 * The Black colour
	 */
	private final String BLACK_COLOUR = "B";

	/**
	 * The Black colour name
	 */
	private final String BLACK_COLOUR_NAME = "Black";

	/**
	 * The result generator handler to test with.
	 */
	private IResultGenerator resultGenerator;

	private IPeg greenPeg = new PegImpl("G", "Green");
	private IPeg bluePeg = new PegImpl("B", "Blue");
	private IPeg yellowPeg = new PegImpl("Y", "Yellow");
	private IPeg redPeg = new PegImpl("R", "Red");

	@Mock
	private IPegGenerator pegGeneratorMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		when(pegGeneratorMock.getPeg("G")).thenReturn(greenPeg);
		when(pegGeneratorMock.getPeg("B")).thenReturn(bluePeg);
		when(pegGeneratorMock.getPeg("Y")).thenReturn(yellowPeg);
		when(pegGeneratorMock.getPeg("R")).thenReturn(redPeg);
		generatedCode = new ArrayList<IPeg>();
		generatedCode.add(greenPeg);
		generatedCode.add(bluePeg);
		generatedCode.add(yellowPeg);
		generatedCode.add(redPeg);

		// TODO use Guice
		resultGenerator = new ResultGeneratorImpl(pegGeneratorMock);
		resultGenerator.setGeneratedCode(generatedCode);
	}
	
	@Test
	public void testTwoWhitePegs() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("J", "Joker"));
		guess.add(new PegImpl("Y", "Yellow"));
		guess.add(new PegImpl("J", "Joker"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		List<IPeg> expectedResult = new LinkedList<IPeg>();
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		verify(expectedResult,resultSet);
	}

	@Test
	public void testTwoBlackPegs() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("B", "Blue"));
		guess.add(new PegImpl("J", "Joker"));
		guess.add(new PegImpl("J", "Joker"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		List<IPeg> expectedResult = new LinkedList<IPeg>();
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		verify(expectedResult,resultSet);
	}

	@Test
	public void testTwoWhiteTwoBlackPegs() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("B", "Blue"));
		guess.add(new PegImpl("R", "Red"));
		guess.add(new PegImpl("Y", "Yellow"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		List<IPeg> expectedResult = new LinkedList<IPeg>();
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		verify(expectedResult,resultSet);
	}

	@Test
	public void testAllBlackPegs() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("B", "Blue"));
		guess.add(new PegImpl("Y", "Yellow"));
		guess.add(new PegImpl("R", "Red"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		List<IPeg> expectedResult = new LinkedList<IPeg>();
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		expectedResult.add(new PegImpl(BLACK_COLOUR, BLACK_COLOUR_NAME));
		verify(expectedResult,resultSet);
	}

	@Test
	public void testAllWhitePegs() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("B", "Blue"));
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("R", "Red"));
		guess.add(new PegImpl("Y", "Yellow"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		List<IPeg> expectedResult = new LinkedList<IPeg>();
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		expectedResult.add(new PegImpl(WHITE_COLOUR, WHITE_COLOUR_NAME));
		verify(expectedResult,resultSet);
	}

	@Test
	public void testNonExistentPegs() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("H", "Hahah"));
		guess.add(new PegImpl("J", "Joker"));
		guess.add(new PegImpl("Y", "Yes"));
		guess.add(new PegImpl("N", "No"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		
		assertTrue(resultSet.isEmpty());
	}

	@Test
	public void testWrongGuessSize() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("H", "Hahah"));
		guess.add(new PegImpl("J", "Joker"));
		guess.add(new PegImpl("Y", "Yes"));

		List<IPeg> resultSet = resultGenerator.getResult(guess);
		
		assertTrue(resultSet.isEmpty());
	}

	@Test
	public void testOneInvalidPeg() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("B", "Blue"));
		guess.add(new PegImpl("Y", "Yes"));
		guess.add(new PegImpl("R", "Red"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		
		assertTrue(resultSet.isEmpty());
	}

	@Test
	public void testOneExtraInvalidPeg() {
		List<IPeg> guess = new ArrayList<IPeg>();
		guess.add(new PegImpl("G", "Green"));
		guess.add(new PegImpl("B", "Blue"));
		guess.add(new PegImpl("Y", "Yes"));
		guess.add(new PegImpl("R", "Red"));
		guess.add(new PegImpl("Y", "Yellow"));
		
		List<IPeg> resultSet = resultGenerator.getResult(guess);
		
		assertTrue(resultSet.isEmpty());
	}
	
	/**
	 * Verifying that the expected peg list matched the found one.
	 * 
	 * @param expected List IPeg
	 * @param found List IPeg
	 */
	private void verify(List<IPeg> expected, List<IPeg> found) {
		assertNotNull(found);
		assertTrue(expected.size() == found.size());
		int index = 0;
		for( IPeg expectedPeg : expected ) {
			assertEquals(expectedPeg.getColourName(), found.get(index).getColourName());
			index++;
		}
	}

}
