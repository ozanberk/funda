package com.funda.pages.funda;

import com.funda.core.driver.FundaWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchComponent extends FundaPageBase{

    @FindBy(name = "filter_location")
    private WebElement searchTextBox;

    @FindBy(name = "filter_Afstand")
    private WebElement rangeFromLocation;

    @FindBy(name = "filter_FundaKoopPrijsVan")
    private WebElement starterPrice;

    @FindBy(name = "filter_FundaKoopPrijsTot")
    private WebElement lastPrice;

    @FindBy(className = "button-primary-alternative")
    private WebElement submit;

    @FindBy(className = "link-alternative")
    private  WebElement lastSearch;

    public SearchComponent(FundaWebDriver driver) {
        super(driver, "");
    }

    public void setSearchTextBox(String location){
        searchTextBox.sendKeys(location);
        searchTextBox.sendKeys(Keys.DOWN);
        searchTextBox.sendKeys(Keys.DOWN);
        searchTextBox.sendKeys(Keys.ENTER);
    }

    public void setRangeFromLocation(String kmRange){
        Select range = new Select(rangeFromLocation);
        range.selectByValue(kmRange);
    }

    public void setStarterPrice(String price){
        Select firstPrice = new Select(starterPrice);
        firstPrice.selectByValue(price);
    }

    public void setLastPrice(String price){
        Select endPrice = new Select(lastPrice);
        endPrice.selectByValue(price);
    }

    public String getLastSearch(){
        return lastSearch.getText();
    }

    public void click(){
        submit.click();
    }

    public void selectDistrict(String location){
        List<WebElement> districts = driver.findElements(By.className("link-alternative"));
        for (WebElement district:districts) {
            if(district.getText().equals(location)){
                district.click();
                break;
            }
            else {
                System.out.println("Expected location not in the districts list");
            }
        }
    }

}

