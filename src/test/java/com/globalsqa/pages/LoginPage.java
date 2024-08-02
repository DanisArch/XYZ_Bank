package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "strong[class='mainHeading']")
    public WebElement logoBank;

    @FindBy(css = "div:nth-child(1) > button[ng-click='customer()']")
    public WebElement customerLoginButton;

    @FindBy(css = "div:nth-child(3) > button[ng-click='manager()']")
    public  WebElement BankManagerLoginButton;

    @Step("Найти логотип банка на главной странице")
    public String findLogo() {
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).logoBank));
        return logoBank.getText();
    }
    //Логи нужно/желательно вести не в самом тесте, а выносить их в метод. Для этого у Алюра есть специальный
    // метод, который помогает вести логи (разобраться с этим вопросом
    @Step("Проверяет наличие кнопки для авторизации пользователя банка на главной странице")
    public boolean checkCustomerLoginButton () {
 //       context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).customerLoginButton));
        boolean answr;
        if (customerLoginButton.isDisplayed()) {
            Allure.step("Кнопка для авторизации пользователя банка активна");
            answr=true;
        } else {
            Allure.step("Кнопка для авторизации пользователя банка  не активна");
            answr=false;
        }
        return answr; //customerLoginButton.isDisplayed();
    }

    @Step("Проверяет наличие кнопки для авторизации менеджера банка на главной странице")
    public boolean checkBankManagerLoginButton () {
        return BankManagerLoginButton.isDisplayed();
    }

    @Step("Войти в приложение банка с правами пользователя")
    public CustomerPage loginAsCustomer() {
        customerLoginButton.click();
        return new CustomerPage(context);
    }

    @Step("Войти в приложение банка с правами менеджера")
    public ManagerPage loginAsBankManager() {
     //   context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).BankManagerLoginButton));
        BankManagerLoginButton.click();
        return new ManagerPage(context);
    }

}
