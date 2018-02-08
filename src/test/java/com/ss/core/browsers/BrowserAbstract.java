package com.ss.core.browsers;

import com.ss.core.driver.SSWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class BrowserAbstract {

    protected DesiredCapabilities caps = new DesiredCapabilities();

    public SSWebDriver getInstance() {
        setOptions();
        setBrowserLogging(Level.SEVERE);
        SSWebDriver webdriver = create();
        setTimeputs(webdriver);
        //webdriver.manage().window().setSize(new Dimension(1920,1080));

        return webdriver;
    }

    public abstract void setOptions();

    public abstract SSWebDriver create();

    protected void setBrowserLogging(Level logLevel) {
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, logLevel);
        caps.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
    }

    protected void setTimeputs(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
