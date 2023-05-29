package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtilityClass {
	
	private Properties property;
	/**
	 * This method is used to intialize properties file
	 * @param filepath
	 */
	public void PropertyConfig(String filepath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch The value from the properties file based on the key
	 * @param key
	 * @return
	 */
	public String FetchProperty(String key)
	{
		return property.getProperty(key);
	}
	
	public void SetDataToProperties(String key,String value,String filepath,String message) {
		property.put(key, value);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(filepath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			property.store(fos, message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
