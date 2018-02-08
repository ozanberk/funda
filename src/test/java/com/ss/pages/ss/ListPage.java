package com.ss.pages.ss;

import com.ss.core.driver.SSWebDriver;
import com.ss.helpers.elements.TableElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ListPage extends SSPageBase {

    @FindBy(css = "[style='width:120px;']")
    private WebElement filter;

    @FindBy(linkText = "Расширенный поиск")
    private WebElement advancedSearch;

    @FindBy(css = "[class='msga2 pp0']")
    private WebElement checkBox23;

    @FindBy(linkText = "Добавить выбранные в закладки")
    private WebElement addToBasketButton;

    @FindBy(id = "alert_ok")
    private WebElement ok;

    @FindBy(id = "sel_cnt_obj")
    private WebElement numberOfProcutOnTheBasket;

    @FindBy(xpath = "html/body/div[3]/div/table/tbody/tr/td/div[1]/table/tbody/tr/td/table[2]/tbody")
    private TableElement<ListRow> listRowElements;

    public ListPage(SSWebDriver driver){
        super(driver);
    }

    public void sortByPrice(String filterType) throws InterruptedException {
        Select dropdown = new Select(filter);
        dropdown.selectByVisibleText(filterType);
    }

    public int getSizeOfTable(){
        return listRowElements.getTableSize();
    }

    public void selectProduct(int num){
        listRowElements.getRow(2).selectItem();
        listRowElements.getRow(3).selectItem();
        listRowElements.getRow(4).selectItem();
    }

    public void addToBasket(){
        waitUntilClickable(addToBasketButton).click();
    }

    public void closeAlert(){
        waitUntilClickable(ok).click();
    }

    public String ItemCountOnTheBasket(){
     return waitUntilVisibleWebElement(numberOfProcutOnTheBasket).getText();
    }

    public int generateRandom(int tableSize){
        Random random = new Random();
        int num = random.nextInt(tableSize - 2) + 1;
        return num;
    }
}
