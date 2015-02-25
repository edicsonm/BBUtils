package au.com.billigbuddy.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.MissingResourceException;


public class BBUtils {
	
	public static ConfigurationApplication configurationApplication = ConfigurationApplication.getInstance();
	
	public static String capitalize(String value){
		return String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1);
    }
	
	public static String nullOrEmptyWithDefaulValue(String value){
		if(value == null) return "Information not available";
		else if(value.length() == 0) return "Information not available";
		else return value;
    }

	public static boolean isNullOrEmpty(String value){
		if(value == null )return true;
		if(value.length() == 0 )return true;
		if(value.trim().length() == 0 )return true;
		if(value.equalsIgnoreCase(""))return true;
		else return false;
	}
	
	public static String currencyToStripe(String amount, String currency) {
		int decimalValue = Integer.parseInt(configurationApplication.getKey("currency."+currency));
		return new DecimalFormat("#0").format(Double.parseDouble(amount) * decimalValue);
	}
	
	public static String stripeToCurrency(String amount, String currency) {
		try {
			int decimalValue = Integer.parseInt(configurationApplication.getKey("currency."+currency));
			return String.valueOf(Double.parseDouble(amount) / decimalValue);
		} catch (MissingResourceException e) {
			e.printStackTrace();
		} 
		return configurationApplication.getKey("currency.imposibleFormatAmount");
	}
	
	public static String currencyToStripe(String amount, Currency currency){
		int decimalValue = Integer.parseInt(configurationApplication.getKey("currency."+currency));
		return new DecimalFormat("#0").format(Double.parseDouble(amount) * decimalValue);
	}
	
	public static String stripeToCurrency(String amount, Currency currency){
		int decimalValue = Integer.parseInt(configurationApplication.getKey("currency."+currency));
		return String.valueOf(Double.parseDouble(amount) / decimalValue);
	}
	
	public static String booleanToString(boolean val){
		if(val)return "0";
		return "1";
	}
	
}
