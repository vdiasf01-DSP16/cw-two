/**
 * 
 */
package controllers;

import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
class CodeGeneratorImpl implements ICodeGenerator
{

	private IPegGenerator pegGenerator;
	private final int CODE_LENGTH;

	/**
	 * CodeGenerator constructor.
	 * 
	 * @param codeLength
	 * @param pegGenerator 
	 */
	@Inject
	public CodeGeneratorImpl(@Named("codeLength") int codeLength, IPegGenerator pegGenerator)
	{
		super();
		this.CODE_LENGTH = codeLength;
		this.pegGenerator = pegGenerator;
	}

	@Override
	public List<IPeg> generateNewCode()
	{
		List<IPeg> generatedCodePegs = new LinkedList<>();

		for (int i = 0; i < this.CODE_LENGTH; i++)
		{
			IPeg peg = null;
			peg = this.pegGenerator.createRandomPeg();
			generatedCodePegs.add(peg);
		}

		return generatedCodePegs;
	}
}
