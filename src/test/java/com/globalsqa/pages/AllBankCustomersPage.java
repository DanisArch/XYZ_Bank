package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllBankCustomersPage extends BasePage {

    public AllBankCustomersPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "input[ng-model='searchCustomer']")
    public WebElement searchCustomerField;

    @FindBy(css = "tr:nth-child(n) > td:nth-child(1)")
    public List<WebElement> listFirstNameCustomers;

    @FindBy(css = "tr:nth-child(n) > td:nth-child(2)")
    public List<WebElement> listLastNameCustomers;

    @FindBy(css = "tr:nth-child(n) > td:nth-child(3)")
    public List<WebElement> listPostCodeCustomers;

    @FindBy(css = "tr:nth-child(n) > td:nth-child(4)")
    public List<WebElement> accountNumberCustomers;

    @FindBy(css = "button[ng-click='deleteCust(cust)']")
    public List<WebElement> deleteCustomers;

    @Step("Найти фамилию пользователя по имени")
    private String getLastNameByFirstName(String firstName) {
        String  lastName = String.format("tr:nth-child(n) > td:nth-child(1)[text()='%s']/../td[2]", firstName);
        //Locator
        return context.driver.findElement(By.xpath(lastName)).getText();
    }
}
