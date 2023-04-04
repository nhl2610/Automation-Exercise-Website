package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFile {

    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;

    static String projectPath = System.getProperty("user.dir") + "/";

    public static String getPropValue(String propertiesFilePathRoot, String key) {
        properties = new Properties();
        try {
            fileIn = new FileInputStream(projectPath + propertiesFilePathRoot);
            properties.load(fileIn);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        String value = null;
        try {
            value = properties.getProperty(key);
            return value;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        return value;
    }

    public static void setPropValue(String propertiesFilePathRoot, String key, String Value) {
        try {
            fileOut = new FileOutputStream(projectPath + propertiesFilePathRoot);
            properties.setProperty(key, Value);
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value in file properties success.");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }

}
