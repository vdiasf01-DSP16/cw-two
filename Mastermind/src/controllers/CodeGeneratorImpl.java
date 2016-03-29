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

	private IPegFactory pegFactory;
	private final int CODE_LENGTH;
	private Map<Integer, IPeg> generatedCodePegs;

	/**
	 * CodeGenerator constructor.
	 * 
	 * @param codeLength
	 * @param pegFactory 
	 */
	@Inject
	public CodeGeneratorImpl(@Named("codeLength") int codeLength,
			@Assisted IPegFactory pegFactory)
	{
		super();
		this.CODE_LENGTH = codeLength;
		this.pegFactory = pegFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ICodeGenerator#generateNewCode()
	 */
	@Override
	public void generateNewCode()
	{
		generatedCodePegs = new HashMap<>();

		for (int i = 0; i < CODE_LENGTH; i++)
		{
			IPeg peg = null;
			peg = pegFactory.getAPeg();
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

	/*
	 * (non-Javadoc)
	 * 
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
}
