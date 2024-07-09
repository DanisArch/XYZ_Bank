package com.globalsqa.pages;


import com.globalsqa.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerPage extends BasePage {
    public CustomerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#userSelect")
    public WebElement userSelect;

    @FindBy(css = "option[ng-repeat='cust in Customers']")
    public List<WebElement> listCustomerNames;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    public void selectionCustomer(String name) {
    userSelect.click();
    }
}
