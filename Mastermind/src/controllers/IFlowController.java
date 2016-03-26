/**
 * 
 */
package controllers;

import models.IGuessHistory;

/**
 * @author pdeara01
 *
 */
public interface IFlowController {
	public IGuessHistory getGuessHistory();
	public boolean isGameFinished();
}
