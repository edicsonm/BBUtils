package au.com.billigbuddy.utils;

import java.util.ResourceBundle;

public class ConfigurationApplication {
	
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("au.com.billigbuddy.utils.properties.ConfigurationApplication");
	private static ConfigurationApplication instance;
	
	public static ConfigurationApplication getInstance() {
		if (instance == null) {
			instance = new ConfigurationApplication();
		}
		return instance;
	}
	
	public static String getKey(String key){
		return resourceBundle.getString(key);
	}
	
}
