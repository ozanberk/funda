package com.funda.core.configuration;

public class ConfigurationLoadFailedException extends RuntimeException {

    public ConfigurationLoadFailedException(){
        super("Failed to load configuration");
    }

    public ConfigurationLoadFailedException(String message) {
        super(message);
    }

    public ConfigurationLoadFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
