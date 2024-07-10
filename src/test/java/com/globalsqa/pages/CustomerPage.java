package com.globalsqa.pages;


import com.globalsqa.context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CustomerPage extends BasePage {
    public CustomerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#userSelect")
    public WebElement userSelect;

    @FindBy(css = "option[ng-repeat='cust in Customers']")
    public List<WebElement> listCustomerNames;

    @FindBy(css = "button[type='submit']")
    public static WebElement loginButton;

    public void selectionCustomer() throws InterruptedException {

        userSelect.click();
        Thread.sleep(3000);
    }

    public List<String> findAllCustomer () throws InterruptedException {
//        selectionCustomer();
        userSelect.click();
//        List<WebElement> allCustomersList = context.driver.findElements(By.cssSelector("#userSelect > " +
//                "option:nth-child(n)")); //Запасной локатор для поиска
        List<String> allCustomersListString = new ArrayList<>();
        for (WebElement lastName :listCustomerNames) {
            allCustomersListString.add(lastName.getText());
        }
        return allCustomersListString;
    }

}

