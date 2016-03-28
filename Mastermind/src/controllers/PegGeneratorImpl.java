/**
 * 
 */
package controllers;

import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
public class PegGeneratorImpl implements IPegGenerator
{

	/**
	 * Constructor for PegGenerator. It requires the loaded colours list.
	 * 
	 * @param colourList
	 */
	@Inject
	public PegGeneratorImpl(@Assisted Map<String, String> colourList)
	{
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.IPegGenerator#getPeg(java.lang.String)
	 */
	@Override
	public IPeg getPeg(String colour) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.IPegGenerator#getAPeg()
	 */
	@Override
	public IPeg getAPeg()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPeg> getPegList(String colors)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
