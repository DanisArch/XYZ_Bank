package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManagerPage extends BasePage {
    public ManagerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement addNewCustomerButton;

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement openCustomerAccountButton;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement showAllCustomersButton;

    @Step("Добавить ожидание для появления кнопки добавления нового пользрвателя")
    public boolean waitAddNewCustomerButton () {
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new ManagerPage(context).addNewCustomerButton));
        return addNewCustomerButton.isDisplayed();
    }
    @Step("Добавить ожидание для появления кнопки открытия счета")
    public boolean waitOpenCustomerAccountButton () {
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new ManagerPage(context).openCustomerAccountButton));
        return openCustomerAccountButton.isDisplayed();
    }

    @Step("Добавить ожидание для появления кнопки открытия всех пользователей")
    public boolean waitShowAllCustomersButton () {
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new ManagerPage(context).showAllCustomersButton));
        return showAllCustomersButton.isDisplayed();
    }

    @Step("Добавить нового пользователя банка")
    public AddNewCustomerPage addNewCustomer () {
        return new AddNewCustomerPage(context);
    }

    @Step("Добавить новый счет для пользователя банка")
    public OpenNewAccountPage openNewAccount () {
        return new OpenNewAccountPage(context);
    }

    @Step("Список всех пользователей банка")
    public AllBankCustomersPage allBankCustomers () {
        return new AllBankCustomersPage(context);
    }
}


