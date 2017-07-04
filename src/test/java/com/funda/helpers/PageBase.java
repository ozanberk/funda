package com.funda.helpers;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import com.funda.core.driver.FundaWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected FundaWebDriver driver;

    protected PageBase(FundaWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(driver), this);
    }
}
