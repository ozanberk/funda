package com.funda.helpers;

import com.funda.core.driver.DriverProvider;
import com.funda.core.driver.FundaWebDriver;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;


public abstract class StepContext {

    public static FundaWebDriver driver;

    private static final Logger LOGGER = Logger.getLogger(StepContext.class.getName());
    private static boolean initialized = false;

    protected StepContext(){
        if (!initialized) {
            LOGGER.info("Context initializing...");
            driver = DriverProvider.getActiveDriver();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                LOGGER.info("Context shut down...");
                driver.quit();
                driver = null;
            }));

            initialized = true;
        }
    }


    public void tearDown(Scenario scenario) {
        /*if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                LOGGER.error(somePlatformsDontSupportScreenshots.getMessage());
            }
        }*/
    }

}
