package com.globalsqa.tests;

import com.globalsqa.pages.CustomerPage;
import com.globalsqa.pages.LoginPage;
import com.globalsqa.utils.ConfigurationReader;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerPageTests extends BaseTest {

    @Test
    @DisplayName("Тест проверяет наличие пользователя в списке всех пользователей")
    @Description("Этот тест проверяет является ли данный человек клиентом нашего банка")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer")
    @Issue("AUTH-444")
    @TmsLink("TMS-4444")
    public void findCustomerByNameTest() throws InterruptedException {
        context.driver.get(ConfigurationReader.get("base_url"));
        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new LoginPage(context).loginAsCustomer();
        List<String> allCustomer= new CustomerPage(context).findAllCustomer();
        for (int i=0; i<allCustomer.size(); i++) {
            if (allCustomer.isEmpty()) {
                System.out.println("У банка нет клиентов");
            }else {
                String lastName = "Ron Weasly";
                if (allCustomer.get(i).toString().equals(lastName)) {
                    Assertions.assertEquals(allCustomer.get(i).toString(),"Ron Weasly");
                    System.out.print(" Клиент: " + allCustomer.get(i).toString() + " с индексом - " + i +
                                    " является пользователем банка.");
                }

            }
        }
    }
}
