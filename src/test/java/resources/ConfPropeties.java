package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfPropeties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static{
            //указываем путь до файла с настройками
        try {
            fileInputStream = new FileInputStream("src/test/java/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        }  catch (IOException e) {
            System.err.println("Ошибка файла с настройками");
        }
        finally {
            if (fileInputStream!=null){
                try{fileInputStream.close();}
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getProperty (String key){
        return PROPERTIES.getProperty(key);
    }
}
