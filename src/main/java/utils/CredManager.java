package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class CredManager {
    private static Properties properties = new Properties();

    public static String getCred (String cred){
        try(InputStream inputStream = new FileInputStream("creds.properties")){
           properties.load(inputStream);
            return properties.getProperty(cred);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
