package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    // the configuration file is stored in the root of the class path as a .properties file
    private static final String CONFIGURATION_FILE = "src\\main\\resources\\config.properties";

    private static final Properties properties;

    // use static initializer to read the configuration file when the class is loaded
    static {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(CONFIGURATION_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + CONFIGURATION_FILE, e);
        }
    }

    public static String getConfigurationValue(String key) {
        return properties.getProperty(key);
    }

    // private constructor to prevent initialization
    private Configuration() {
    }

}
