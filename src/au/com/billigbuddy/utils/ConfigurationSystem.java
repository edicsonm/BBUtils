package au.com.billigbuddy.utils;

import java.util.ResourceBundle;

public class ConfigurationSystem {
	
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("au.com.billigbuddy.utils.properties.ConfigurationSystem");
	private static ConfigurationSystem instance;
	
	public static ConfigurationSystem getInstance() {
		if (instance == null) {
			instance = new ConfigurationSystem();
		}
		return instance;
	}
	
	public static String getKey(String key){
		return resourceBundle.getString(key);
	}
	
}
