package com.funda.pages.funda;

import com.funda.core.driver.FundaWebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EuropaPage extends FundaPageBase {

    @FindBy(id = "Country")
    private WebElement countrySelection;

    @FindBy(className = "cbb box-search cbb-done")
    private WebElement europeanText;

    @FindBy(id = "toggleRent")
    private WebElement rentHome;

    @FindBy(id = "toggleSale")
    private WebElement buyHome;

    @FindBy(id = "toggleBoth")
    private WebElement both;

    @FindBy(id = "RentFrom")
    private WebElement rentStartPrice;

    @FindBy(id = "RentTo")
    private WebElement rentLastPrice;

    @FindBy(id = "SaleFrom")
    private WebElement saleStartPrice;

    @FindBy(id = "SaleTo")
    private WebElement saleLastPrice;

    @FindBy(css = "[type='Submit']")
    private WebElement submitButton;

    @FindBy(css = "[title='Land wijzigen...']")
    private WebElement searchResult;

    @FindBy(className = "no-results")
    private WebElement noResultMessage;

    public EuropaPage(FundaWebDriver driver){
        super(driver, "");
    }

    public String getEuropean(){
        return europeanText.getText();
    }

    public void setCountry(String countryName){
        Select country = new Select(countrySelection);
        country.selectByValue(countryName);
    }

    public void rentAHome(){
        rentHome.click();
    }

    public void buyAHome(){
        buyHome.click();
    }

    public void clickBoth(){
        both.click();
    }

    public void setRentStartPrice(int index){
        Select price = new Select(rentStartPrice);
        price.selectByIndex(index);
    }

    public void setRentLastPrice(int index){
        Select price = new Select(rentLastPrice);
        price.selectByIndex(index);
    }

    public void setSaleStartPrice(int index){
        Select price = new Select(saleStartPrice);
        price.selectByIndex(index);
    }

    public void setSaleLastPrice(int index){
        Select price = new Select(saleLastPrice);
        price.selectByIndex(index);
    }

    public void submit(){
        submitButton.click();
    }

    public String getSearchResponse(){
        return searchResult.getText();
    }

    public String getNoResponse(){
        return noResultMessage.getText();
    }

    public void setRentPrice(int firstPrice, int lastPrice){
        setRentStartPrice(firstPrice);
        setRentLastPrice(lastPrice);
    }

    public void firstPriceDisableCheck(){
        boolean rentPrice = rentStartPrice.getCssValue("display").equals("none");
        boolean salePrice = saleStartPrice.getCssValue("display").equals("none");
        Assert.assertTrue(rentPrice);
        Assert.assertTrue(salePrice);
    }
}
