package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
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


