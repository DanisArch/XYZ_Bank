package com.globalsqa.pages.plane;

import com.globalsqa.context.TestContext;
import com.globalsqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaneLoginPage extends BasePage {
    public PlaneLoginPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button.btn.home")
    public WebElement homePageButton;

    @FindBy(css = "div:nth-child(1) > button[ng-click='customer()']")
    public WebElement customerLoginButton;

    @FindBy(css = "div:nth-child(3) > button[ng-click='manager()']")
    public WebElement BankManagerLoginButton;
}
