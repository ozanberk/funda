package com.ss.pages.ss;

import com.ss.core.configuration.Configuration;
import com.ss.core.driver.SSWebDriver;
import com.ss.helpers.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract class SSPageBase extends PageBase {

    @FindBy(linkText = "Поиск")
    private WebElement search;

    @FindBy(linkText = "Закладки")
    private WebElement basket;

    @FindBy(linkText = "LV")
    private WebElement lv;

    @FindBy(linkText = "RU")
    private WebElement ru;

    @FindBy(className = "menu_lang")
    private WebElement language;

    @FindBy(id = "mnu_fav_id")
    private WebElement itemCount;

    public void navigate(){
        driver.get(String.join("/", Configuration.getHomePage()));
    }
    
    SSPageBase(SSWebDriver driver) {
        super(driver);
    }

    public void search(){
        waitUntilClickable(search).click();
    }

    public String suggestedLanguage(){
        return language.getText();
    }

    public void changeLanguageToTheRussian(){
        ru.click();
    }

    public void changeLanguageToTheLatvia(){
        lv.click();
    }

    public void basket() {
        waitUntilClickable(basket).click();
    }

    public String ItemCount(){
        return itemCount.getText();
    }
}
