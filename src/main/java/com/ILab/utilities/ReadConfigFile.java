package com.ILab.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

    private  final Properties properties;

    public ReadConfigFile(){
        properties = new Properties();
        try{
            properties.load(new FileInputStream("src/main/resources/configuration/config.properties"));
        }catch (Exception e){
            System.out.println("Error while loading properties " + e.getMessage());
        }
    }

    public String readProperty(String keyName) {
        //Logger.getLogger(getClass().getName()).log(Level.INFO, "Reading Property " + keyName);
        return properties.getProperty(keyName, "There is no key in the properties file");
    }
}
