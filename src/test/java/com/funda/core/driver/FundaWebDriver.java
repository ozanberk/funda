package com.funda.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FundaWebDriver extends EventFiringWebDriver {
    private WebDriver webDriver;

    public FundaWebDriver(WebDriver webdriver) {
        super(webdriver);
        this.webDriver = webdriver;
    }

    public boolean isChrome() {
        return webDriver instanceof ChromeDriver;
    }

    public boolean isFirefox() {
        return webDriver instanceof FirefoxDriver;
    }
}
