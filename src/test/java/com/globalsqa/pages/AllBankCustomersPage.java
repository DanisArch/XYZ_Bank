package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllBankCustomersPage extends BasePage {

    public AllBankCustomersPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button[ng-click='addCust()']") //найти правильный css
    public WebElement findCustonerField;
/*
    @Step("Найти пользователя банка из таблицы пользователей")
    public AddNewCustomerPage addNewCustomer () {
        return new AddNewCustomerPage(context);
    }*/
}
