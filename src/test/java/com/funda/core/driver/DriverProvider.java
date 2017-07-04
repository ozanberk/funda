package com.funda.core.driver;

import com.funda.core.browsers.Browser;
import com.funda.core.configuration.Configuration;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DriverProvider {

    private static final List<FundaWebDriver> drivers = new ArrayList<>();
    private static int ACTIVE_BROWSER_INDEX = 0;
    private static final Logger LOGGER = Logger.getLogger(DriverProvider.class.getName());

    private DriverProvider() {}

    private static void newInstance() {
        drivers.add(Browser.lookup(Configuration.getBrowser()).getInstance());
    }

    private static FundaWebDriver getBrowserDriver(int index) {
        for (; drivers.size() <= index;) {
            newInstance();
        }

        return drivers.get(index);
    }

    public static FundaWebDriver getActiveDriver() {
        return getBrowserDriver(ACTIVE_BROWSER_INDEX);
    }

    public static FundaWebDriver switchActiveWindow(int index) {
        ACTIVE_BROWSER_INDEX = index;
        return getActiveDriver();
    }

    public static void close() {
        for (FundaWebDriver webDriver : drivers) {
            if (webDriver != null) {
                try {
                    webDriver.quit();
                }catch (UnsatisfiedLinkError | NoClassDefFoundError e){
                    LOGGER.error("Closing Browser", e);
                }
            }
        }
        drivers.clear();
        ACTIVE_BROWSER_INDEX = 0;
    }
}