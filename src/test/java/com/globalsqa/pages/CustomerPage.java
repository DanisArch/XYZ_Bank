package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CustomerPage extends BasePage {

//    List<String> allCustomers=null;

    public CustomerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#userSelect")
    public WebElement userSelect;

    @FindBy(css = "option[ng-repeat='cust in Customers']")
    public List<WebElement> listCustomerNames;

    @FindBy(css = "button[type='submit']")
    public static WebElement loginButton;

    @Step("Открыть страницу со всеми клиентами")
    public CustomerPage selectionCustomer() {
        new LoginPage(context).loginAsCustomer();
        return new CustomerPage(context);
    }

    @Step("Составить список всех клиентов")
    public List<String> findAllCustomers() {
        selectionCustomer();
       userSelect.click();
        List<String> allCustomersLocal = new ArrayList<>();
        for (WebElement fullName : listCustomerNames) {
            allCustomersLocal.add(fullName.getText());
        }
//        allCustomers.addAll(allCustomersLocal);
        return allCustomersLocal;
    }

    @Step("Определить, есть ли у банка хотя бы один клиент")
    public boolean haveBankCustomer() {
        if (!findAllCustomers().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Step("Составить список всех клиентов (повторное использование)")
    public List<String> findAllCustomersForComparison() {
        userSelect.click();
        List<String> allCustomers = new ArrayList<>();
        for (WebElement fullName : listCustomerNames) {
            allCustomers.add(fullName.getText());
        }
        return allCustomers;
    }

    @Step("Определить, есть ли нужный нам пользователь в нашем списке клиентов")
    public String findCustomerByName(String lastName) {
        List<String> allCustomers = new CustomerPage(context).findAllCustomersForComparison();
           for (int i = 0; i < allCustomers.size(); i++) {
        if (allCustomers.get(i).toString().equals(lastName))  // or findAllCustomersForComparison().contains(lastName)
            break;
    }
    return lastName;
    }
}



