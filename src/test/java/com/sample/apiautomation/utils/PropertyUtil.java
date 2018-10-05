package com.sample.apiautomation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    private static final Logger LOGGER = LogManager.getLogger(PropertyUtil.class);

    public PropertyUtil() {
        throw new AssertionError();
    }

    public static String getConfigProp(String key) {
        LOGGER.traceEntry();

        Properties prop = new Properties();
        final String CONFIG_PATH = "config.properties";
        String configValue = null;
        try (InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream(CONFIG_PATH)) {
            prop.load(input);

            configValue = prop.getProperty(key);
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
        } catch (Exception e) {
            LOGGER.error("Something went wrong! {}", e.getMessage());
        }
        return LOGGER.traceExit(configValue);
    }
}
