package com.web.selenium.webSelenium.config;

import java.util.Objects;

import com.web.selenium.webSelenium.utils.PropertiesFileReader;


public class GlobalConfigBuilder {
	
	private GlobalConfig config;
	private static GlobalConfigBuilder configBuilder;
	
	public static GlobalConfigBuilder getInstace(String path) {
		if (configBuilder == null) {
			configBuilder = new GlobalConfigBuilder(path);
        }
		return configBuilder;
	}
	public static GlobalConfigBuilder getInstace() {
		return getInstace("Chrome-local-config.properties");
	}
	
	private GlobalConfigBuilder(String path) {
        config = new GlobalConfig();
        if(path == null | Objects.equals(path, "")){
            path = GlobalConstants.CHROME_CONFIG;
        }else {
            path = GlobalConstants.RESOURCES_SLUG_CONFIG + path;
        }
        PropertiesFileReader reader = new PropertiesFileReader();
        reader.reader(path);
        
        for (final String name: reader.getProp().stringPropertyNames()) {
        	config.put(name, reader.getProp().getProperty(name));
        }
    }
	
	
	public GlobalConfig getConfig() {
		return config;
	}

	public void setConfig(GlobalConfig config) {
		this.config = config;
	}

}
