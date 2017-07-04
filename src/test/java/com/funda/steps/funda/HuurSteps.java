package com.funda.steps.funda;

import com.funda.helpers.StepContext;
import com.funda.pages.funda.HuurPage;
import com.funda.pages.funda.ResultPage;
import com.funda.pages.funda.SearchComponent;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class HuurSteps extends StepContext {
    private SearchComponent searchComponent;
    private ResultPage resultPage;
    private HuurPage huurPage;


    public HuurSteps(){
        searchComponent = new SearchComponent(driver);
        resultPage = new ResultPage(driver);
        huurPage = new HuurPage(driver);
    }

    @And("^I select first price for rent \"([^\"]*)\"$")
    public void iSelectFirstPriceForRent(String price) throws Throwable {
        huurPage.setStarterHuurPrice(price);
    }

    @And("^I select last price for rent \"([^\"]*)\"$")
    public void iSelectLastPriceForRent(String price) throws Throwable {
        huurPage.setLastHuurPrice(price);
    }

    @Then("^I select range \"([^\"]*)\" km$")
    public void iSelectRangeKm(String km) throws Throwable {
        huurPage.setRangeFromLocation(km);
    }
}
