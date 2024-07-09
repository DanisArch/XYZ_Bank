package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends BasePage {
    public ManagerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement addNewCustonerButton;

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement openCustonerAcountButton;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement showAllCustomersButton;
}
