package com.funda.core.browsers;

import com.funda.core.driver.FundaWebDriver;
import org.apache.log4j.Logger;


public enum Browser {
    CHROME(ChromeBrowser.class, "CHROME");

    private Class<? extends BrowserAbstract> browserClass;
    private String name;

    static final Logger LOGGER = Logger.getLogger(Browser.class.getName());

    Browser(Class<? extends BrowserAbstract> browserClass, String name) {
        this.name = name;
        this.browserClass = browserClass;
    }

    public static Browser lookup(String browserName) {
        for (Browser name : Browser.values()) {
            if (name.getName().equalsIgnoreCase(browserName)) {
                return name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public FundaWebDriver getInstance() {
        try {
            return browserClass.newInstance().getInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("Could not initialize the browser", e);
        }
        return null;
    }

    public Class<? extends BrowserAbstract> getBrowserClass() {
        return browserClass;
    }
}
