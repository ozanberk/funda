package com.ss.pages.ss;

import com.ss.core.driver.SSWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSPage extends SSPageBase {

    @FindBy(linkText = "Электротехника")
    private WebElement electronics;

    public SSPage(SSWebDriver driver){
        super(driver);
    }

    public void navigateToElectronics(){
        waitUntilClickable(electronics).click();
    }
}
