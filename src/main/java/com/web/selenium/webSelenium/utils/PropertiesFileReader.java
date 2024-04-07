package com.web.selenium.webSelenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	private Properties prop;
	
	public void reader(String filePath) {
		setProp(new Properties());
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(filePath);
			getProp().load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            // close objects
            try {
                if (stream != null) {
                	stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
}
