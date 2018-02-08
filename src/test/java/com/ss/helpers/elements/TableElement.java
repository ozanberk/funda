package com.ss.helpers.elements;

import com.github.webdriverextensions.WebComponent;
import com.ss.helpers.elements.RowElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TableElement<T extends RowElement> extends WebComponent {

    @FindBy(tagName = "tr")
    List<T> rows;

    public T getRow(int row) {
        return rows.get(row - 1);
    }

    public List<T> getRows() {
        return rows;
    }

    public int getTableSize() {
        return rows.size();
    }
}
