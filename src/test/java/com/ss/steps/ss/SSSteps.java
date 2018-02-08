package com.ss.steps.ss;

import com.ss.helpers.StepContext;
import com.ss.pages.ss.BasketPage;
import com.ss.pages.ss.ListPage;
import com.ss.pages.ss.SSPage;
import com.ss.pages.ss.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class SSSteps extends StepContext {
    private SSPage ssPage;
    private SearchPage searchPage;
    private ListPage listPage;
    private BasketPage basketPage;

    public SSSteps(){
        ssPage = new SSPage(driver);
        searchPage = new SearchPage(driver);
        listPage = new ListPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Given("^I visit ss homepage$")
    public void iVisitSsHomepage() throws Throwable {
        ssPage.navigate();
    }

    @Then("^I change language to the russian$")
    public void iChangeLanguageToTheRussian() throws Throwable {
        if (ssPage.suggestedLanguage().equals("RU")){
            ssPage.changeLanguageToTheRussian();
        }
        else {
            System.out.println("Language is already Russian");
        }
    }

    @When("^I click an electronics button$")
    public void iClickAElectronicsButton() throws Throwable {
        ssPage.navigateToElectronics();
    }

    @Then("^I click a search button$")
    public void iClickASearchButton() throws Throwable {
        ssPage.search();
    }

    @And("^I search to \"([^\"]*)\"$")
    public void iSearchTo(String value) throws Throwable {
        searchPage.searchProduct("Computer");
    }

    @And("^I want to sort according to price \"([^\"]*)\"$")
    public void iWantToSortAccordingToPrice(String filterType) throws Throwable {
        listPage.sortByPrice(filterType);
    }

    @Then("^I want to specify range between \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iWantToSpecifyRangeBetweenTo(String min, String max) throws Throwable {
        searchPage.search();
        searchPage.advancedSearch(min, max);
    }

    @And("^I want to select (\\d+) item randomly$")
    public void iWantToSelectItemRandomly(int numberOfItem) throws Throwable {
        listPage.selectProduct(numberOfItem);
    }

    @Then("^I add to basket$")
    public void iAddToBasket() throws Throwable {
        listPage.addToBasket();
        //listPage.closeAlert();
        Assert.assertTrue(listPage.ItemCount().contains("3"));
        listPage.basket();
    }

    @And("^I assert the basket in case of any error$")
    public void iAssertTheBasketInCaseOfAnyError() throws Throwable {
        Assert.assertTrue(basketPage.countOfBasket().contains("3"));
    }
}
