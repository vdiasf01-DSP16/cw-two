/**
 * 
 */
package controllers;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import models.IPeg;

/**
 * @author pdeara01
 *
 */
public class CodeGeneratorImpl implements ICodeGenerator {

	private final IPegGenerator pegGenerator;
	private final int CODE_LENGTH;
	private Map<Integer, IPeg> generatedCodePegs;
	
	@Inject
	public CodeGeneratorImpl(int codeLength, IPegGenerator pegGenerator) {
		super();
		this.CODE_LENGTH = codeLength;
		this.pegGenerator = pegGenerator;
	}

	/* (non-Javadoc)
	 * @see controllers.ICodeGenerator#generateNewCode()
	 */
	@Override
	public void generateNewCode() {
		generatedCodePegs = new HashMap<>();
		
		for (int i = 0; i < CODE_LENGTH; i++) {
			IPeg peg = pegGenerator.getAPeg();
			if (peg != null) {
				generatedCodePegs.put(i, peg);
			}
		}
	}

	/* (non-Javadoc)
	 * @see controllers.ICodeGenerator#getCode()
	 */
	@Override
	public Map<Integer, IPeg> getCode() {
		return generatedCodePegs;
	}
}
