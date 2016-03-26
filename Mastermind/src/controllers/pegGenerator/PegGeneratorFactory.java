package controllers.pegGenerator;

import java.util.Map;

public interface PegGeneratorFactory {
	public IPegGenerator create(Map<String, String> colourList);
}
