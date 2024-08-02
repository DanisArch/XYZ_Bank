package com.globalsqa.pages;

import com.globalsqa.context.NewCustomerInfo;
import com.globalsqa.context.TestContext;
import com.globalsqa.utils.ConfigurationReader;
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

    @Step("Заполнить поля с данными нового пользователя банка из списка тестовых пользователей")
    public String addNewCustomer() {
        new LoginPage(context).loginAsBankManager().addNewCustomer();
        userFirstName.sendKeys(ConfigurationReader.get("fName"));
        userLastName.sendKeys(ConfigurationReader.get("lName"));
        postCode.sendKeys(ConfigurationReader.get("pCode"));
        addNewCustomerButton.click();
        context.alert = context.driver.switchTo().alert();
        String messageAlert = context.alert.getText();
        context.alert.accept();
        return messageAlert;
    }

    @Step("Заполнить поля с данными нового пользователя банка из метода")
    public String addNewCustomerFromMethod() {
        new LoginPage(context).loginAsBankManager().addNewCustomer();
        new NewCustomerInfo("David", "Aguero", "AI001E");
        addNewCustomerButton.click();
        context.alert = context.driver.switchTo().alert();
        String messageAlert = context.alert.getText();
        context.alert.accept();
        return messageAlert;
    }

    @Step("Не заполненое поле с именем нового пользователя банка")
    public String missedNameOfCustomer() {
        new LoginPage(context).loginAsBankManager().addNewCustomer();
        userLastName.sendKeys(ConfigurationReader.get("lName"));
        postCode.sendKeys(ConfigurationReader.get("pCode"));
        addNewCustomerButton.click();
        context.alert = context.driver.switchTo().alert();
        String messageAlert = context.alert.getText();
        context.alert.accept();
        return messageAlert;
    }

}


