package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import com.globalsqa.utils.ConfigurationReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


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
        new LoginPage(context);
//        context.driver.get(ConfigurationReader.get("base_url"));
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).logoBank));
        return logoBank.getText();
    }

    @Step("Войти в приложение банка с правами пользователя")
    public CustomerPage loginAsCustomer() throws InterruptedException {
        context.driver.get(ConfigurationReader.get("base_url"));
//        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).customerLoginButton));
        customerLoginButton.click();
        return new CustomerPage(context);
    }

    @Step("Войти в приложение банка с правами менеджера")
    public ManagerPage loginAsBankManager(){
        context.driver.get(ConfigurationReader.get("base_url"));
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).BankManagerLoginButton));
        BankManagerLoginButton.click();
        return new ManagerPage(context);
    }

}
