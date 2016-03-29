package views;

import java.util.List;

import models.IPeg;

/**
 * @author Pedro Gordo
 *
 */
public interface IPrintSecretCode
{
	/**
	 * Show secret code
	 * 
	 * @param secretCode
	 */
	public void show(List<IPeg> secretCode);
}
