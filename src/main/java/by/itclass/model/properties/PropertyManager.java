package by.itclass.model.properties;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    public static Properties getProperties(String filename) {
        Properties properties = new Properties();
        try {
           InputStream in =  Thread.currentThread()
                                  .getContextClassLoader()
                                  .getResourceAsStream(filename);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            //Логирование
        }
        return properties;
    }
}
