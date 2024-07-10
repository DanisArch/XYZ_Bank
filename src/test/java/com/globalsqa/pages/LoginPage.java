package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import com.globalsqa.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button.btn.home")
    public WebElement homePageButton;

    @FindBy(css = "div:nth-child(1) > button[ng-click='customer()']")
    public WebElement customerLoginButton;

    @FindBy(css = "div:nth-child(3) > button[ng-click='manager()']")
    public  WebElement BankManagerLoginButton;

    public CustomerPage loginAsCustomer(){
        customerLoginButton.click();
        return new CustomerPage(context);
    }

    public ManagerPage loginAsBankManager(){
        return new ManagerPage(context);
    }

}
