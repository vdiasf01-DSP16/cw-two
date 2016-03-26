package factories;

import java.util.Map;

import controllers.IPegGenerator;

public interface PegGeneratorFactory {
	public IPegGenerator create(Map<String, String> colourList);
}
