package com.globalsqa.pages.plane;

import com.globalsqa.context.TestContext;
import com.globalsqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaneMainPage extends BasePage {
    public PlaneMainPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#btn btn-primary btn-lg")   //ng-click="customer()"
    public WebElement customerLogin;

    @FindBy(css = "#user-name")                 //ng-click="manager()"
    public WebElement BankManagerLogin;
}