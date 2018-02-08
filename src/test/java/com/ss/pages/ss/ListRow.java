package com.ss.pages.ss;

import com.ss.helpers.elements.RowElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListRow extends RowElement {

    @FindBy(css = "[class='msga2 pp0']")
    private WebElement checkBox;

    public void selectItem(){
        checkBox.click();
    }
}
