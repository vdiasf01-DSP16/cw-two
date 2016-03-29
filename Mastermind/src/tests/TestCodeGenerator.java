/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import controllers.CodeGeneratorImpl;
import controllers.ICodeGenerator;
import controllers.IPegCreator;
import controllers.exception.NonExistingColourException;
import models.IPeg;
import models.PegImpl;

/**
 * Test the code generator controller.
 * 
 * @author Pedro Gordo
 */
public class TestCodeGenerator
{

	private static final int CODE_LENGTH = 4;
	private ICodeGenerator codeGenerator;

	/**
	 * List of known pegs.
	 */
	private IPeg greenPeg = new PegImpl("G", "Green"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The peg generator mock.
	 */
	@Mock
	private IPegCreator pegGeneratorMock = Mockito.mock(IPegCreator.class);

	/**
	 * The initial test setup.
	 * @throws NonExistingColourException 
	 */
	@Before
	public void setUp() throws NonExistingColourException
	{
		when(this.pegGeneratorMock.createRandomPeg()).thenReturn(this.greenPeg);
		this.codeGenerator = new CodeGeneratorImpl(CODE_LENGTH, this.pegGeneratorMock);
	}

	/**
	 * Makes sure that after the generateNewCode() is called, the code is not
	 * empty.
	 */
	@Test
	public void testIsNotNull()
	{
		this.codeGenerator.generateNewCode();
		assertNotNull(this.codeGenerator.getCode());
	}

	/**
	 * Asserts that the generated code length is the same as the configurated
	 * value.
	 */
	@Test
	public void testGeneratedCodeSize()
	{
		this.codeGenerator.generateNewCode();
		int actual = this.codeGenerator.getCode().size();
		assertEquals(CODE_LENGTH, actual);
	}
}
