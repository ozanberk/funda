package com.funda.core.configuration;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private static final String DEFAULT_CONFIG_FILE_NAME = "config_default.yml";
    private static final String LOCAL_CONFIG_FILE_NAME = "config.yml";
    private static final Logger LOGGER = Logger.getLogger(Configuration.class.getName());
    private static Map<String, String> defaultConfig;
    private static Map<String, String> testConfig = new HashMap<>();

    private Configuration() {
    }

    private static Map<String, String> readConfiguration() {
        if (defaultConfig == null) {
            Yaml yaml = new Yaml();

            try {
                defaultConfig = (Map<String, String>) yaml.load(new FileInputStream(new File(DEFAULT_CONFIG_FILE_NAME)));
            } catch (FileNotFoundException e) {
                throw new ConfigurationLoadFailedException(
                        String.format("CANNOT FIND DEFAULT CONFIG FILE : %s", DEFAULT_CONFIG_FILE_NAME), e);
            }

            File localConfigFile = new File(LOCAL_CONFIG_FILE_NAME);
            if (localConfigFile.exists()) {
                try {
                    defaultConfig.putAll((Map<String, String>) yaml.load(new FileInputStream(localConfigFile)));
                } catch (FileNotFoundException e) {
                    LOGGER.info("local config file not found", e);
                }
            } else {
                LOGGER.info("local config file does not exist");
            }
        }

        return defaultConfig;
    }

    private static String getPropertyFromFile(String propertyName) {
        return "null".equals(String.valueOf(readConfiguration().get(propertyName))) ? null
                : String.valueOf(readConfiguration().get(propertyName));
    }

    private static String getProp(String propertyName) {
        if (testConfig.get(propertyName) == null) {
            return System.getProperty(propertyName) != null ? System.getProperty(propertyName)
                    : getPropertyFromFile(propertyName);
        } else {
            return testConfig.get(propertyName);
        }
    }

    public static String getBrowser() {
        return getProp("browser");
    }

    public static String getHomePage() {
        return getProp("baseUrl");
    }

    /**
     * @return null if window is supposed to be maximised, Dimension if any other size is demanded
     */
    public static Dimension getBrowserSize() {
        String size = getProp("browserSize");

        if (StringUtils.isNotBlank(size) || "maximised".equals(size) || size.split("x").length == 2) {
            if ("maximised".equals(size)) {
                return null;
            } else {
                return new Dimension(Integer.valueOf(size.split("x")[0]),
                        Integer.valueOf(size.split("x")[1]));
            }
        } else {
            throw new WebDriverException("browser size: " + size + " is not a proper value");
        }
    }
}
