/**
 * 
 */
package controllers;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

/**
 * @author pdeara01
 *
 */
public class ColourLoaderImpl implements IColourLoader {

	@Inject
	public ColourLoaderImpl(String path) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, String> getColours() {
		// TODO Auto-generated method stub
		return new HashMap<>();
	}

}
