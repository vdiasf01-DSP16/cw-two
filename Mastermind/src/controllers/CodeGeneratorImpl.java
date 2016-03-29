/**
 * 
 */
package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
public class CodeGeneratorImpl implements ICodeGenerator
{

	private IPegCreator pegCreator;
	private final int CODE_LENGTH;
	private Map<Integer, IPeg> generatedCodePegs;

	/**
	 * CodeGenerator constructor.
	 * 
	 * @param codeLength
	 * @param pegCreator 
	 */
	@Inject
	public CodeGeneratorImpl(@Named("codeLength") int codeLength,
			@Assisted IPegCreator pegCreator)
	{
		super();
		this.CODE_LENGTH = codeLength;
		this.pegCreator = pegCreator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ICodeGenerator#generateNewCode()
	 */
	@Override
	public void generateNewCode()
	{
		this.generatedCodePegs = new HashMap<>();

		for (int i = 0; i < this.CODE_LENGTH; i++)
		{
			IPeg peg = null;
			peg = this.pegCreator.createRandomPeg();
			this.generatedCodePegs.put(new Integer(i), peg);
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
		for (int index = 0; index < this.generatedCodePegs.size(); index++)
		{
			finalList.add(this.generatedCodePegs.get(new Integer(index)));
		}
		return finalList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ICodeGenerator#getCodeString()
	 */
	@Override
	public String getCodeString()
	{
		String codeString = new String();

		for (IPeg peg : getCode())
		{
			codeString += peg.getColour();
		}

		return codeString;
	}
}
