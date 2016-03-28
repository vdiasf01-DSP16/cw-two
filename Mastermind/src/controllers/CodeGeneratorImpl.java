/**
 * 
 */
package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
public class CodeGeneratorImpl implements ICodeGenerator
{

	private IPegGenerator pegGenerator;
	private final int CODE_LENGTH;
	private Map<Integer, IPeg> generatedCodePegs;

	/**
	 * CodeGenerator constructor.
	 * 
	 * @param codeLength
	 */
	@Inject
	public CodeGeneratorImpl(@Named("codeLength") int codeLength)
	{
		super();
		this.CODE_LENGTH = codeLength;
	}

	/* (non-Javadoc)
	 * @see controllers.ICodeGenerator#generateNewCode()
	 */
	@Override
	public void generateNewCode()
	{
		generatedCodePegs = new HashMap<>();

		for (int i = 0; i < CODE_LENGTH; i++)
		{
			IPeg peg = pegGenerator.getAPeg();

			generatedCodePegs.put(i, peg);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ICodeGenerator#getCode()
	 */
	@Override
	public List<IPeg> getCode()
	{
		List<IPeg> finalList = new LinkedList<>();
		for (int index = 0; index < generatedCodePegs.size(); index++)
		{
			finalList.add(generatedCodePegs.get(index));
		}
		return finalList;
	}

	/* (non-Javadoc)
	 * @see controllers.ICodeGenerator#getCodeString()
	 */
	@Override
	public String getCodeString()
	{
		String codeString = "";

		for (IPeg peg : getCode())
		{
			codeString += peg.getColour();
		}

		return codeString;
	}

	@Override
	public void setPegGenerator(IPegGenerator pegGenerator)
	{
		this.pegGenerator = pegGenerator;
	}
}
