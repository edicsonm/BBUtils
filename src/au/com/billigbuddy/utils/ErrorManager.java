package au.com.billigbuddy.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class ErrorManager {

	private static ErrorManager instance = null;
	private static ConfigurationSystem configurationSystem = null;
	
	public static synchronized ErrorManager getInstance() {
		if (instance == null) {
			instance = new ErrorManager();
		}
		return instance;
	}
	
	private ErrorManager() {} 
	
	public static void manageErrorPaymentPage(String... attributes){
		try {
			Calendar cal = Calendar.getInstance();
			File file = new File(ConfigurationSystem.getKey("urlSaveErrorFilesPaymentPage") + attributes[0] +"-"+ cal.getTime());
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for (int i = 1; i < attributes.length; i++) {
				writer.println(attributes[i]);
			}
			writer.close();
			
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(Error);
//			bw.write(message);
//			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void manageErrorProcessor(String... attributes){
		try {
			Calendar cal = Calendar.getInstance();
			File file = new File(ConfigurationSystem.getKey("urlSaveErrorFilesProcessor") + attributes[0] +"-"+ cal.getTime());
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for (int i = 1; i < attributes.length; i++) {
				writer.println(attributes[i]);
			}
			writer.close();
			
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(Error);
//			bw.write(message);
//			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void manageErrorFraudDetection(String... attributes){
		try {
			Calendar cal = Calendar.getInstance();
			File file = new File(ConfigurationSystem.getKey("urlSaveErrorFilesFraudDetection") + attributes[0] +"-"+ cal.getTime());
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for (int i = 1; i < attributes.length; i++) {
				writer.println(attributes[i]);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void manageErrorSaveInformationTransaction(String... attributes){
		try {
			Calendar cal = Calendar.getInstance();
			File file = new File(ConfigurationSystem.getKey("urlSaveErrorFilesSaveInformationTransaction") + attributes[0] +"-"+ cal.getTime());
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for (int i = 1; i < attributes.length; i++) {
				writer.println(attributes[i]);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		manageErrorPaymentPage("Error1","message2","Exception3");
	}

}
