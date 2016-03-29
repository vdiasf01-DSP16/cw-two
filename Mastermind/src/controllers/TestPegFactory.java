package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controllers.exception.InvalidGuessSizeInput;
import controllers.exception.NonExistingColourException;

/**
 * Testing the IPegCreator implementation.
 * 
 * @author Pedro Gordo
 *
 */
public class TestPegFactory
{

	/**
	 * The IPegCreator object handler for test.
	 */
	private IPegCreator pegCreator;

	/**
	 * Sets up a colour list that will be used as a dictionary to generate pegs.
	 */
	@Before
	public void setUp()
	{
		IColourLoader colourLoader = Mockito.mock(IColourLoader.class);
		when(colourLoader.getColours().get("B")).thenReturn("Blue"); //$NON-NLS-1$ //$NON-NLS-2$
		this.pegCreator = new PegCreatorImpl(colourLoader);
	}

	/**
	 * Test that we get exception when we can't generate a peg.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test(expected = NonExistingColourException.class)
	public void testExceptionWithNonExistingColour() throws InvalidGuessSizeInput, NonExistingColourException
	{
		this.pegCreator.createPeg("Not known colour"); //$NON-NLS-1$
	}

	/**
	 * Test Peg found is of a known colour.
	 * 
	 * @throws InvalidGuessSizeInput
	 * @throws NonExistingColourException 
	 */
	@Test
	public void testKnownColourGetPeg() throws InvalidGuessSizeInput, NonExistingColourException
	{
		String expected = "Blue"; //$NON-NLS-1$
		String actual = null;
		actual = this.pegCreator.createPeg("B").getColourName(); //$NON-NLS-1$
		assertEquals(expected, actual);
	}
	
	/**
	 * Test that we get a non null peg.
	 */
	@Test
	public void testGetAPeg()
	{
		assertNotNull(this.pegCreator.createRandomPeg());
	}
}
