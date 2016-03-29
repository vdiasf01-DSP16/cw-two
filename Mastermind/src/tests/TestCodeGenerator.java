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
import controllers.IPegFactory;
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
	private IPeg greenPeg = new PegImpl("G", "Green");

	/**
	 * The peg generator mock.
	 */
	@Mock
	private IPegFactory pegGeneratorMock = Mockito.mock(IPegFactory.class);

	/**
	 * The initial test setup.
	 * @throws NonExistingColourException 
	 */
	@Before
	public void setUp() throws NonExistingColourException
	{
		when(pegGeneratorMock.getAPeg()).thenReturn(greenPeg);
		codeGenerator = new CodeGeneratorImpl(CODE_LENGTH, pegGeneratorMock);
	}

	/**
	 * Makes sure that after the generateNewCode() is called, the code is not
	 * empty.
	 */
	@Test
	public void testIsNotNull()
	{
		codeGenerator.generateNewCode();
		assertNotNull(codeGenerator.getCode());
	}

	/**
	 * Asserts that the generated code length is the same as the configurated
	 * value.
	 */
	@Test
	public void testGeneratedCodeSize()
	{
		codeGenerator.generateNewCode();
		int actual = codeGenerator.getCode().size();
		assertEquals(CODE_LENGTH, actual);
	}
}
