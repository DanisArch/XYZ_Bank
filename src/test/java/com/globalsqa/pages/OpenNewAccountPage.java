package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewAccountPage extends BasePage {

    public OpenNewAccountPage(TestContext context) {
        super(context);
    }
/* Ниже скопированные данные (черновик)
    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement addNewCustonerButton;

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement openCustonerAcountButton;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement showAllCustomersButton;

    @Step("Добавить нового пользователя банка")
    public AddNewCustomerPage addNewCustomer () {
        return new AddNewCustomerPage(context);
    }*/

}