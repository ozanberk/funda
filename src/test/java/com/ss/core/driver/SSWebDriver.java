package com.ss.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SSWebDriver extends EventFiringWebDriver {
    private WebDriver webDriver;

    public SSWebDriver(WebDriver webdriver) {
        super(webdriver);
        this.webDriver = webdriver;
    }
}
