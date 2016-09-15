package com.sda.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyReader {
	private final static Logger LOGGER = Logger.getLogger(PropertyReader.class.getName()); 
	
	public static void loadPropertyValues(){
		Properties properties = new Properties();
		String propertyFile = "config.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();  
		InputStream stream = loader.getResourceAsStream(propertyFile);
		try {
			properties.load(stream);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "There were problems loading property file.", e);
		}

		System.setProperties(properties);		

	}
}
