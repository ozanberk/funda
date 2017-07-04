package com.funda.pages.funda;

import com.funda.core.driver.FundaWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HuurPage extends FundaPageBase {

    @FindBy(name = "filter_FundaHuurPrijsVan")
    private WebElement starterHuurPrice;

    @FindBy(name = "filter_FundaHuurPrijsTot")
    private WebElement lastHuurPrice;

    @FindBy(id = "Afstand")
    private WebElement rangeAsKm;

    public  HuurPage(FundaWebDriver driver){
        super(driver, "");
    }

    public void setStarterHuurPrice(String price){
        Select firstPrice = new Select(starterHuurPrice);
        firstPrice.selectByValue(price);
    }

    public void setLastHuurPrice(String price){
        Select endPrice = new Select(lastHuurPrice);
        endPrice.selectByValue(price);
    }

    public void setRangeFromLocation(String kmRange){
        Select range = new Select(rangeAsKm);
        range.selectByValue(kmRange);
    }
}
