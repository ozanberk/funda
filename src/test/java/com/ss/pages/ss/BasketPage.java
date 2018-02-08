package com.ss.pages.ss;

import com.ss.core.driver.SSWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends SSPageBase {

    @FindBy(className = "filter_second_line_dv")
    private WebElement basketCount;

    public BasketPage(SSWebDriver driver){
        super(driver);
    }

    public String countOfBasket(){
        return waitUntilVisibleWebElement(basketCount).getText();
    }
}
