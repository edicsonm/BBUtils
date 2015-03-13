package au.com.billigbuddy.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	
	public static String getCurrentDate(int format){
		return getDateFormat(format).format(Calendar.getInstance().getTime()); 
	}
	
	/*Obtiene una fecha restandole o sumandole dias a partitr de dia de hoy*/
	public static String getCurrentDate(int format, int days){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, days);
		Date date = cal.getTime();
		return getDateFormat(format).format(date); 
	}
	
	public static SimpleDateFormat getDateFormat(int format){
		SimpleDateFormat simpleDateFormat = null;
		switch (format) {
		case 1:
			simpleDateFormat =  new SimpleDateFormat("MM-dd-yyyy");
			break;
		case 2:
			simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd");
			break;
		case 3:
			simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;
		case 4:
			simpleDateFormat =  new SimpleDateFormat("MM-dd");
			break;
		case 5:
			simpleDateFormat =  new SimpleDateFormat("dd-MM-yyyy");
			break;
		case 6:
			simpleDateFormat =  new SimpleDateFormat("MM/dd/yyyy");
			break;
		default:
			simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			break;
		}
		return simpleDateFormat;
	}
	
}
