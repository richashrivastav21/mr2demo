package com.mr2demo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/*
 * This class has methods all the properties available in application.properties file
 */
public class Config {
	
	private static final Logger LOG = Logger.getLogger(Config.class);

	public static String getBrowsername() {
		String base = System.getProperty("user.dir");
		String filePath = base + "/src/main/resources/application.properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value = prop.getProperty("browser_name");
			LOG.info(value+" browser loaded from property file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}
	
	public static String getAppUrl() {
		String base = System.getProperty("user.dir");
		String filePath = base + "/src/main/resources/application.properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value = prop.getProperty("app.url");
			LOG.info(value+" application url loaded from property file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}
}
