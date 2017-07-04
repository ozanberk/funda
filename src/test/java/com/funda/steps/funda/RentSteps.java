package com.funda.steps.funda;

import com.funda.helpers.StepContext;
import com.funda.pages.funda.ResultPage;
import com.funda.pages.funda.SearchComponent;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RentSteps extends StepContext {
    private SearchComponent searchComponent;
    private ResultPage resultPage;

    public RentSteps() {
        searchComponent = new SearchComponent(driver);
        resultPage = new ResultPage(driver);
    }

    @Then("^I click \"([^\"]*)\" tab$")
    public void iClickFilter(String tabName) throws Throwable {
        searchComponent.selectHuur();
    }

    @When("^I should select house in \"([^\"]*)\"$")
    public void iShouldSelectHouseIn(String location) throws Throwable {
        searchComponent.selectDistrict(location);
    }

    @Then("^I should click \"([^\"]*)\" tab$")
    public void iShouldClickTab(String tabName) throws Throwable {
        searchComponent.selectTab(tabName);
    }
}
