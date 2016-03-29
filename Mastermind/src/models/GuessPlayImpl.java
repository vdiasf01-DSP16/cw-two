/**
 * 
 */
package models;

import java.util.List;

/**
 * @author Pedro Gordo
 *
 */
class GuessPlayImpl implements IGuessPlay {
	
	/**
	 * The guess set list of pegs played.
	 */
	private final List<IPeg> guessSet;
	
	/**
	 * The result set of pegs for the guess played.
	 */
	private final List<IPeg> resultSet;

	/**
	 * Constructor.
	 * 
	 * @param guessSet List
	 * @param resultSet List
	 */
	public GuessPlayImpl(List<IPeg> guessSet, List<IPeg> resultSet ) {
		this.resultSet = resultSet;
		this.guessSet = guessSet;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPeg> getGuessSet() {
		return this.guessSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPeg> getResultSet() {
		return this.resultSet;
	}
}
