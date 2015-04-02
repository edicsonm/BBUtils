package au.com.billigbuddy.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.MissingResourceException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.billingbuddy.vo.objects.UserMerchantVO;


public class BBUtils {
	
	public static ConfigurationApplication configurationApplication = ConfigurationApplication.getInstance();
	
	public static String printString(String value){
		if(value != null) return value;
		return "";
    }
	
	public static String capitalize(String value){
		if(value != null && value.length() > 0) return String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1);
		return "";
    }
	
	public static String toUpperCase(String value){
		if(value != null && value.length() > 0) return value.toUpperCase();
		return "";
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
		int decimalValue = Integer.parseInt(configurationApplication.getKey("currency."+currency.toUpperCase()));
		return new DecimalFormat("#0").format(Double.parseDouble(amount) * decimalValue);
	}
	
	public static String stripeToCurrency(String amount, String currency) {
		try {
			if(amount != null && Double.parseDouble(amount) > 0){
				int decimalValue = Integer.parseInt(configurationApplication.getKey("currency."+currency.toUpperCase()));
				return String.valueOf(Double.parseDouble(amount) / decimalValue);
			}else{
				return "0";
			}
		} catch (MissingResourceException | NullPointerException e) {
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
	
	public static String formatDate(int inputFormat, String date, int outputFormat){
		if(date != null && !date.isEmpty()){
			try {
				return (getDateFormat(outputFormat).format(getDateFormat(inputFormat).parse(date))).trim();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	
	public static String formatDateDefaultValue(int inputFormat, String date, int outputFormat, int days){
		if(date != null && !date.isEmpty()){
			try {
				return (getDateFormat(outputFormat).format(getDateFormat(inputFormat).parse(date))).trim();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, days);
			Date dateAux = cal.getTime();
			return getDateFormat(outputFormat).format(dateAux);
		}
		return date;
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
	
	public static String printCardNumber(String cardnumber){
		if(cardnumber == null || cardnumber.isEmpty()) return "";
		String pattern = "%1$-"+ (cardnumber.length() - 10 )+"s";
		String cadena = String.format(pattern,"").replaceAll(" ", "*");
		String MASKCARD = "$1-"+cadena+"-$2";
		Pattern PATTERNCARD =  Pattern.compile("([0-9]{6})[0-9]{0,9}([0-9]{4})");
		Matcher matcher = PATTERNCARD.matcher(cardnumber);
		String maskedMessage = matcher.replaceAll(MASKCARD);
		return maskedMessage;
	}
	
	public static String configureUserMerchants(ArrayList<UserMerchantVO> listUserMerchants){
		if(listUserMerchants == null || listUserMerchants.size() == 0) return null;
		String merchants = "";
		for (Iterator<UserMerchantVO> iterator = listUserMerchants.iterator(); iterator .hasNext();) {
			UserMerchantVO userMerchantVO = (UserMerchantVO) iterator.next();
			merchants += userMerchantVO.getMerchantId() + "," ;
		}
		return merchants.substring(0, merchants.length()-1);
	}
	
}
