package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

// platformdan bağımsız olarak, bir ortamdan başka bir ortama veri akımını sağlayacak yeteneklere sahiptirler.

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {  //reponsibility of this class is finding configuration properties and reading it and loading it what we have in configuration.properties

    private static Properties properties;

    static {   //load the file first             // static blocks are automatically called as soon as class is loaded in memory

        System.out.println("sadfsd");
        try {
            // what file to read
            String filePath = "configuration.properties";                            // path of properties file as a string
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(filePath);
            // properties --> class that store properties in key / value format
            properties = new Properties();

            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);  //loading the properties class//input represents configuration.properties file

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {  //why static method? --> you dont need to create abject to call the method , you can just call directly from the class
                                                //ConfigurationReader.get.. ornegin

        return properties.getProperty(keyName);   //key ler configuration.properties class inda esitligin solunda bulunananlar
    }


}

//the less you touch your test case, your framework is better

//Since the static block is always executed first, it doesn't matter in which order it's placed within the class.
// Typically, you would want to have the static block listed before constructors for readability,
// but Java technically does not care. However, Java will process the static block codes in order.

//class FileInputStream extends InputStream