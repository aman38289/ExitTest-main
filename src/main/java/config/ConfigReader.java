
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {

        try {

            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getBrowser() {
            return properties.getProperty("browser");
        }

        public String getBaseUrl() {
            return properties.getProperty("base_url");
        }
        
        public String getStatusOfHeadless() {
        	return properties.getProperty("headless");
        }

    }



