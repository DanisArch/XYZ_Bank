package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomerPage extends BasePage{
    public AddNewCustomerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "input[ng-model='fName']")
    public WebElement userFirstName;

    @FindBy(css = "input[ng-model='lName']")
    public WebElement userLastName;

    @FindBy(css = "input[ng-model='postCd']")
    public WebElement postCode;

    @FindBy(css = "button[type='submit']")
    public WebElement addNewCustomerButton;

    @Step("Заполнить поля с данными нового пользователя банка")
    private void addNewCustomer(String fName, String lName,String pCode) {
        userFirstName.sendKeys(fName);
        userLastName.sendKeys(lName);
        postCode.sendKeys(pCode);
        addNewCustomerButton.click();
    }
}
