package com.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
    private static Properties properties;

    public void loadConfigFile() throws IOException {
        File file= new File("./ConfigurationDetails/applicationconfiguration.properties");
        FileInputStream fileInputStream= new FileInputStream(file);
        properties=new Properties();
        properties.load(fileInputStream);
    }

    public String getConfigProperty(String propertyName){
        return properties.getProperty(properties.getProperty(propertyName));
    }
}
