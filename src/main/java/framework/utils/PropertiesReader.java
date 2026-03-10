package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader{

    public static String readKey(String key){

        try {
            FileInputStream fileinputstream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data.properties");
            Properties p = new Properties();
            p.load(fileinputstream);
            return p.getProperty(key);
        }

        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
