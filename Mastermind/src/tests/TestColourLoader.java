package tests;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import controllers.ColourLoaderImpl;
import controllers.IColourLoader;

/**
 * Testing the Colour Loader.
 * 
 * @author Pedro Gordo
 *
 */
public class TestColourLoader
{

	/**
	 * The path to the colour list test file.
	 */
	private final String PATH = "/Mastermind/src/tests/pegColours";

	/**
	 * The loader object to test.
	 */
	private IColourLoader loader;

	/**
	 * The map of all expected colours loaded from test file.
	 */
	private Map<String, String> expected;

	/**
	 * Load initial state for testing.
	 */
	@Before
	public void setUp()
	{
		// Initialises the loaded with this implementation and loads colours
		// from file.
		loader = new ColourLoaderImpl(PATH);

		expected = new LinkedHashMap<>();
		expected.put("B", "blue");
		expected.put("G", "green");
		expected.put("O", "orange");
		expected.put("P", "purple");
		expected.put("R", "red");
		expected.put("Y", "yellow");
	}

	/**
	 * Check if the loaded colours from file is not empty.
	 */
	@Test
	public void testIsNotEmpty()
	{
		Map<String, String> loadedColours = loader.getColours();
		assertFalse(loadedColours.isEmpty());
	}

	/**
	 * Check if the loaded colours from file match the same size expected list.
	 */
	@Test
	public void testIsSameSize()
	{
		Map<String, String> loadedColours = loader.getColours();
		assertTrue(expected.size() == loadedColours.size());
	}

	/**
	 * Check if the loaded colours from file match all elements of the expected
	 * list.
	 */
	@Test
	public void testSameElements()
	{
		Map<String, String> actual = loader.getColours();
		assertEquals(expected, actual);
	}
}
