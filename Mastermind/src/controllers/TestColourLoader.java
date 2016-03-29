package controllers;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Colour Loader.
 * 
 * @author Pedro Gordo
 *
 */
public class TestColourLoader
{

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
		this.loader = new ColourLoaderImpl();

		this.expected = new LinkedHashMap<>();
		this.expected.put("B", "blue"); //$NON-NLS-1$ //$NON-NLS-2$
		this.expected.put("G", "green"); //$NON-NLS-1$ //$NON-NLS-2$
		this.expected.put("O", "orange"); //$NON-NLS-1$ //$NON-NLS-2$
		this.expected.put("P", "purple"); //$NON-NLS-1$ //$NON-NLS-2$
		this.expected.put("R", "red"); //$NON-NLS-1$ //$NON-NLS-2$
		this.expected.put("Y", "yellow"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Check if the loaded colours from file is not empty.
	 */
	@Test
	public void testIsNotEmpty()
	{
		Map<String, String> loadedColours = this.loader.getColours();
		assertFalse(loadedColours.isEmpty());
	}

	/**
	 * Check if the loaded colours from file match the same size expected list.
	 */
	@Test
	public void testIsSameSize()
	{
		Map<String, String> loadedColours = this.loader.getColours();
		assertTrue(this.expected.size() == loadedColours.size());
	}

	/**
	 * Check if the loaded colours from file match all elements of the expected
	 * list.
	 */
	@Test
	public void testSameElements()
	{
		Map<String, String> actual = this.loader.getColours();
		assertEquals(this.expected, actual);
	}
}
