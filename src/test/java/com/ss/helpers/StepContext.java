package com.ss.helpers;

import com.ss.core.driver.DriverProvider;
import com.ss.core.driver.SSWebDriver;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;

import java.io.IOException;


public abstract class StepContext {
    public static SSWebDriver driver;

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


    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ScreenshotManager.saveFailScenarioScreenshot(driver, scenario);
        }
    }

}
