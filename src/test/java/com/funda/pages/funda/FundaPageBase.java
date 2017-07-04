package com.funda.pages.funda;

import com.funda.core.configuration.Configuration;
import com.funda.core.driver.FundaWebDriver;
import com.funda.helpers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

abstract class FundaPageBase extends PageBase {

    @FindBy(linkText = "Huur")
    private WebElement huurTab;

    @FindBy(linkText = "Nieuwbouw")
    private WebElement nieuwbouwTab;

    @FindBy(linkText = "Recreatie")
    private WebElement recreatieTab;

    @FindBy(linkText = "Europa")
    private WebElement europaTab;

    @FindBy(className = "link-alternative")
    private WebElement lastSearchAgain;

    public void navigate(String path){
        driver.get(String.join("/", Configuration.getHomePage(), path));
    }
    
    FundaPageBase(FundaWebDriver driver, String path) {
        super(driver);
    }

    public void deleteAllCookies() throws InterruptedException {
        driver.manage().deleteAllCookies();
    }

    public void selectHuur(){
        huurTab.click();
    }

    public void setNieuwbouwTab(){
        nieuwbouwTab.click();
    }

    public void setRecreatieTab(){
        recreatieTab.click();
    }

    public void setEuropaTab(){
        europaTab.click();
    }

    public void selectTab(String tabName){
        List<WebElement> tabs = driver.findElements(By.className("search-block__navigation-item"));
        for (WebElement tab:tabs) {
            if(tab.getText().equals(tabName)){
                tab.click();
                break;
            }
            else {
                System.out.println("Expected location not in the districts list");
            }
        }
    }

    public void lastSearch(){
        lastSearchAgain.click();
    }

}
