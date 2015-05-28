package au.com.billigbuddy.utils.VO;

import java.io.Serializable;
import java.util.HashMap;

public class ScheduledJobVO implements Serializable{

	private static final long serialVersionUID = -1506290989886457725L;
	
	private String name;
	private String description;
	private String cronPattern;
	private String storageType;
	private Class<?> listener;
	private HashMap<String, String> message = new HashMap<String, String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCronPattern() {
		return cronPattern;
	}
	public void setCronPattern(String cronPattern) {
		this.cronPattern = cronPattern;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public Class<?> getListener() {
		return listener;
	}
	public void setListener(Class<?> listener) {
		this.listener = listener;
	}
	public HashMap<String, String> getMessage() {
		return message;
	}
	public void setMessage(HashMap<String, String> message) {
		this.message = message;
	}
	
	
}
