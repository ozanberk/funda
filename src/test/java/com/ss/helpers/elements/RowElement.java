package com.ss.helpers.elements;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RowElement<M extends RowElement> extends WebComponent {

    @FindBy(tagName = "td")
    List<WebElement> columns;

    public WebElement getCell(int column) {
        return columns.get(column - 1);
    }

    public List<WebElement> getCells(){
        return columns;
    }
}
