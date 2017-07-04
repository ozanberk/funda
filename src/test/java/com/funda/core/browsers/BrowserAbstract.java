package com.funda.core.browsers;

import com.funda.core.driver.FundaWebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class BrowserAbstract {

    protected DesiredCapabilities caps = new DesiredCapabilities();

    public FundaWebDriver getInstance() {
        setOptions();
        setBrowserLogging(Level.SEVERE);
        FundaWebDriver webdriver = create();
        setTimeputs(webdriver);
        //webdriver.manage().window().setSize(new Dimension(1920,1080));

        return webdriver;
    }

    public abstract void setOptions();

    public abstract FundaWebDriver create();

    protected void setBrowserLogging(Level logLevel) {
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, logLevel);
        caps.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
    }

    protected void setTimeputs(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
