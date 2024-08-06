package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    private static Properties prop = new Properties();
    static {
        try(InputStream input = Utilities.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (input==null){
                System.out.println("-----------Sorry unable to file config file-----------");

            }

            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }



}
