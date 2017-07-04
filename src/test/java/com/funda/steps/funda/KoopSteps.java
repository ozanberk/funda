package com.funda.steps.funda;

import com.funda.helpers.StepContext;
import com.funda.pages.funda.ResultPage;
import com.funda.pages.funda.SearchComponent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;


public class KoopSteps extends StepContext {
    private SearchComponent searchComponent;
    private ResultPage resultPage;

    public KoopSteps(){
        searchComponent = new SearchComponent(driver);
        resultPage = new ResultPage(driver);
    }

    @Given("^I delete all the cookies$")
    public void iDeleteAllTheCookies() throws Throwable {
        searchComponent.deleteAllCookies();
    }

    @Given("^I visit funda homepage$")
    public void iVisitFundaHomepage() throws Throwable {
        searchComponent.navigate("");
    }

    @Then("^I should search home in \"([^\"]*)\"$")
    public void iShouldSearchHomeIn(String location) throws Throwable {
        searchComponent.setSearchTextBox(location);
    }

    @Then("^I select range max \"([^\"]*)\" km$")
    public void iSelectRangeMaxKm(String km) throws Throwable {
        searchComponent.setRangeFromLocation(km);
    }

    @Then("^I select first price as \"([^\"]*)\"")
    public void selectFirstPrice(String price) throws Throwable {
        searchComponent.setStarterPrice(price);
    }

    @Then("^I select last price as \"([^\"]*)\"")
    public void selectLastPrice(String price) throws Throwable {
        searchComponent.setLastPrice(price);
    }

    @Then("^I should click submit$")
    public void iShouldClickSubmit() throws Throwable {
        searchComponent.click();
    }

    @And("^I should see \"([^\"]*)\" message$")
    public void iShouldSeeMessage(String message) throws Throwable {
        String uiResult = resultPage.getResult();
        Assert.assertTrue(uiResult.contains(message));
    }

    @And("^I should see \"([^\"]*)\" in the search box$")
    public void iShouldSeeInTheSearchBox(String location) throws Throwable {
        String uiResult = resultPage.getResultText();
        Assert.assertTrue(uiResult.contains(location));
    }

    @Then("^I wait$")
    public void iWait() throws Throwable {
        int a = 1;
    }

    @Then("^I should see previous search \"([^\"]*)\"$")
    public void iShouldSeePreviousSearch(String lastSearchValue) throws Throwable {
        String uiResult = searchComponent.getLastSearch();
        Assert.assertTrue(uiResult.contains(lastSearchValue));
    }

    @Then("^I should see \"([^\"]*)\" filter$")
    public void iShouldSeeFilter(String arg0) throws Throwable {
        resultPage.getPriceFilter();
    }

    @And("^I should see selected range as \"([^\"]*)\" km$")
    public void iShouldSeeSelectedRangeAsKm(String km) throws Throwable {
        String uiKm = resultPage.getRangeByKm(km);
        Assert.assertTrue(uiKm.contains(km));
    }
}