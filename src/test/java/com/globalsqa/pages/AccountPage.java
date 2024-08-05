package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountPage extends BasePage{

    public AccountPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "strong > span[class='fontBig ng-binding']")
    public WebElement welcomeUserName;

    @FindBy(css = "#accountSelect")
    public WebElement listAccountNummerCustomer;

    @FindBy(css = "div:nth-child(3) > strong:nth-child(1)")
    public WebElement selectedAccountNummerOfCustomer;

    @FindBy(css = "div:nth-child(3) > strong:nth-child(2)")
    public WebElement balanceOfCustomer;

    @FindBy(css = "div:nth-child(3) > strong:nth-child(3)")
    public WebElement currency;

    @FindBy(css = "button[ng-click='transactions()']")
    public WebElement transactionsButton;
//Раздел с депозитами
    @FindBy(css = "button[ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(css = "input[ng-model='amount']")
    public WebElement amountToBeDeposited;

    @FindBy(css = "button[class='btn btn-default']")
    public WebElement putMoneyOnDepositButton;
//Раздел с переводами
    @FindBy(css = "button[ng-click='withdrawl()']")
    public WebElement withdrawlButton;

    @FindBy(css = "input[ng-model='amount']")
    public WebElement amountToBeWithdrawn;

    @FindBy(css = "button[class='btn btn-default']")
    public WebElement withdrawMoneyButton;


    @FindBy(css = "button[ng-click='byebye()']")
    public WebElement logoutButton;

    @Step("Получить сообщение о подтверждении, что на счет 1004 USD - Harry Potter положил деньги")
    public String makeDepositPotter() {
    WebElement confirmText = context.driver.findElement(By.cssSelector("span[class='error ng-binding']"));
    return  confirmText.getText().toString();
    }

    @Step("Пополнить счет")
    public AccountPage makeDeposit(String amount) {
        depositButton.click();
        amountToBeDeposited.sendKeys(amount);
        putMoneyOnDepositButton.click();
        return new AccountPage(context);
    }

    @Step("Получить сообщение о подтверждении, что co счета 1003 Rupee - Hermoine Granger сняли деньги")
    public String makeWithdrawHermoineGrangerConfirm() {
        WebElement confirmText = context.driver.findElement(By.cssSelector("span[class='error ng-binding']"));
        return  confirmText.getText().toString();
    }

    @Step("Снять со счета Hermoine Granger деньги")
    public AccountPage makeWithdrawHermoineGranger(String amount, String account) throws InterruptedException {
        listAccountNummerCustomer.click();
        WebElement allAccountCustomers = context.driver.findElement(By.cssSelector("#accountSelect"));
        Select select = new Select(allAccountCustomers);
        select.selectByVisibleText(account);
        Thread.sleep(3000);
        makeWithdraw(amount);
        return new AccountPage(context);
    }

    @Step("Снять со счета деньги")
    public AccountPage makeWithdraw(String amount) {
        withdrawlButton.click();
        amountToBeWithdrawn.sendKeys(amount);
        withdrawMoneyButton.click();
        return new AccountPage(context);
    }
}

