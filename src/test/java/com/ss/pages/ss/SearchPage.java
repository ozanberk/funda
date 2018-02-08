package com.ss.pages.ss;

import com.ss.core.driver.SSWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchPage extends SSPageBase {

    @FindBy(id = "ptxt")
    private WebElement searchTextBox;

    @FindBy(id = "sbtn")
    private WebElement submit;

    @FindBy(css = "[name='topt[8][min]']")
    private WebElement minTextBox;

    @FindBy(css = "[name='topt[8][max]']")
    private WebElement maxTextBox;

    public SearchPage(SSWebDriver driver){
        super(driver);
    }

    public void searchProduct(String value) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        waitUntilVisibleWebElement(searchTextBox).sendKeys(value);
        searchTextBox.sendKeys(Keys.DOWN);
        searchTextBox.sendKeys(Keys.ENTER);
    }

    public void advancedSearch(String min, String max){
        waitUntilVisibleWebElement(minTextBox).sendKeys(min);
        waitUntilVisibleWebElement(maxTextBox).sendKeys(max);
        waitUntilClickable(submit).click();
    }
}
