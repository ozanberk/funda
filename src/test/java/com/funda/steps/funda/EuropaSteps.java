package com.funda.steps.funda;

import com.funda.helpers.StepContext;
import com.funda.pages.funda.EuropaPage;
import com.funda.pages.funda.ResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EuropaSteps extends StepContext {
    private EuropaPage europaPage;
    private ResultPage resultPage;

    public EuropaSteps(){
        europaPage = new EuropaPage(driver);
        resultPage = new ResultPage(driver);
    }

    @When("^I should select house in country \"([^\"]*)\"$")
    public void iShouldSelectHouseInCountry(String countryName) throws Throwable {
       europaPage.setCountry(countryName);
    }


    @Then("^I click \"([^\"]*)\" tab in europa page$")
    public void iClickTabInEuropaPage(String option) throws Throwable {
        if(option.equals("koop")){
            europaPage.buyAHome();
        }
        else if(option.equals("huur")){
            europaPage.rentAHome();
        }
        else{
            europaPage.clickBoth();
        }
    }


    @And("^I select \"([^\"]*)\" th price as first and \"([^\"]*)\" th as a last price$")
    public void iSelectThPriceAsFirstAndThAsALastPrice(int firstPrice, int lastPrice) throws Throwable {
        europaPage.setSaleStartPrice(firstPrice);
        europaPage.setSaleLastPrice(lastPrice);
    }

    @Then("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        europaPage.submit();
    }

    @And("^I should see \"([^\"]*)\" text$")
    public void iShouldSeeText(String message) throws Throwable {
        String assertionMessage = europaPage.getEuropean();
        Assert.assertTrue(assertionMessage.contains(message));
    }

    @And("^I should see \"([^\"]*)\" message in Europa page$")
    public void iShouldSeeMessageInEuropaPage(String countryName) throws Throwable {
        String uiResponse = europaPage.getSearchResponse();
        Assert.assertTrue(uiResponse.equals(countryName));
    }

    @And("^I should set \"([^\"]*)\" th price as first and \"([^\"]*)\" th as a last price$")
    public void iShouldSetThPriceAsFirstAndThAsALastPrice(int firstPrice, int lastPrice) throws Throwable {
        europaPage.setRentPrice(firstPrice, lastPrice);
    }

    @And("^I should see \"([^\"]*)\" message in search result$")
    public void iShouldSeeMessageInSearchResult(String message) throws Throwable {
        String result = europaPage.getNoResponse();
        Assert.assertTrue(result.contains(message));
    }

    @And("^I should check first price box is not enable$")
    public void iShouldCheckFirstPriceBoxIsNotEnable() throws Throwable {
        europaPage.firstPriceDisableCheck();
    }

    @And("^I should search my last search$")
    public void iShouldSearchMyLastSearch() throws Throwable {
        europaPage.lastSearch();
    }
}
