package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
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

    @Step("Открыть список всех клиентов")
    public CustomerPage selectionCustomer() {
        new LoginPage(context).loginAsCustomer();   //Добавил в начало заход как пользователь
        return new CustomerPage(context);
    }

    @Step("Составить список всех клиентов")
    public List<String> findAllCustomers() {
        selectionCustomer();
        new CustomerPage(context).userSelect.click();
        List<String> allCustomers = new ArrayList<>();
        for (WebElement fullName : listCustomerNames) {
            allCustomers.add(fullName.getText());
        }
        return allCustomers;
    }

    @Step("Определить, есть ли у банка хотя бы один клиент")
    public boolean haveBankCustomer() {
        if (!findAllCustomers().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Step("Составить список всех клиентов (повторное использование")
    public List<String> findAllCustomersForComparison() {
        new CustomerPage(context).userSelect.click();
        List<String> allCustomers = new ArrayList<>();
        for (WebElement fullName : listCustomerNames) {
            allCustomers.add(fullName.getText());
        }
        return allCustomers;
    }

    @Step("Определить, есть ли нужный нам пользователь в нашем списке клиентов")
    public String findCustomerByName(String lastName) {
        List<String> allCustomers = new CustomerPage(context).findAllCustomersForComparison();

//    findAllCustomer().contains(lastName);
//    List<String> allCustomers = ;
           for (int i = 0; i < allCustomers.size(); i++) {
//        lastName = "Ron Weasly";
        if (allCustomers.get(i).toString().equals(lastName))  //findAllCustomersForComparison().contains(lastName)
            break;
    }
    return lastName;
    }
}


/*
System.out.print(" Клиент: " + allCustomer.get(i).toString() + " с индексом - " + i +
            " является пользователем банка.");
            */
