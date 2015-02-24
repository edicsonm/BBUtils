package au.com.billigbuddy.utils;

public class BBUtils {

	public static String capitalize(String value){
		return String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1);
    }
	
	public static String nullOrEmptyWithDefaulValue(String value){
		if(value == null) return "Information not available";
		else if(value.length() == 0) return "Information not available";
		else return value;
    }

}
