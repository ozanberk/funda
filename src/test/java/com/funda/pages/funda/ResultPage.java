package com.funda.pages.funda;

import com.funda.core.driver.FundaWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ResultPage extends FundaPageBase {

    @FindBy(className = "search-output-result-count")
    private WebElement resultCount;

    @FindBy(name = "filter_location")
    private WebElement resultBox;

    @FindBy(className = "button-applied-filter")
    private WebElement priceFilter;

    @FindBy(className = "filter-count-number")
    private WebElement filterCount;

    @FindBy(id = "Straal")
    private WebElement rangeKm;

    public ResultPage(FundaWebDriver driver){
        super(driver, "");
    }

    public String getResult(){
         return resultCount.getText();
    }

    public String getResultText(){
        return resultBox.getAttribute("value");
    }

    public String getPriceFilter(){
        return priceFilter.getText();
    }

    public String getRangeByKm(String km){
        Select range = new Select(rangeKm);
        return range.getFirstSelectedOption().getText();
    }
}
