package tests;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Colour Loader.
 * 
 * @author pdeara01
 *
 */
public class TestColourLoader {

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
	private Map<String, String> expectedColours;

	/**
	 * Load initial state for testing.
	 */
	@Before
	public void setUp() {
		// Initialises the loaded with this implementation and loads colours from file.
		loader = new ColourLoaderImpl(PATH);

		expectedColours = new LinkedHashMap<>();
		expectedColours.put("B", "blue");
		expectedColours.put("G", "green");
		expectedColours.put("O", "orange");
		expectedColours.put("P", "purple");
		expectedColours.put("R", "red");
		expectedColours.put("Y", "yellow");
	}

	/**
	 * Check if the loaded colours from file is not null.
	 */
	@Test
	public void testIsNotNull() {
		Map<String, String> loadedColours = loader.getColours();
		assertNotNull(loadedColours);
	}

	/**
	 * Check if the loaded colours from file is not empty.
	 */
	@Test
	public void testIsNotEmpty() {
		Map<String, String> loadedColours = loader.getColours();
		assertFalse(loadedColours.isEmpty());
	}

	/**
	 * Check if the loaded colours from file match the same size expected list.
	 */
	@Test
	public void testIsSameSize() {
		Map<String, String> loadedColours = loader.getColours();
		assertEquals(expectedColours.size() == loadedColours.size());
	}

	/**
	 * Check if the loaded colours from file match all elements of the expected
	 * list.
	 */
	@Test
	public void testSameElements() {
		Map<String, String> loadedColours = loader.getColours();
		for (String colour : loadedColours.keySet()) {
			assertEquals(expectedColours.get(colour), loadedColours.get(colour));
		}
	}
}
