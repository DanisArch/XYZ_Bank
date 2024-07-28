package com.globalsqa.tests;

import com.globalsqa.pages.CustomerPage;
import com.globalsqa.pages.LoginPage;
import com.globalsqa.utils.ConfigurationReader;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;

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
//        context.driver.get(ConfigurationReader.get("base_url"));
//        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new LoginPage(context).loginAsCustomer();
        List<String> allCustomer = new CustomerPage(context).findAllCustomer();
        if (allCustomer.isEmpty()) {
            Assertions.fail("У банка нет клиентов");
        }
        for (int i = 0; i < allCustomer.size(); i++) {         //Вынести всю логику в отдельный метод
                String lastName = "Ron Weasly";
                if (allCustomer.get(i).toString().equals(lastName)) {
                    Assertions.assertEquals(allCustomer.get(i).toString(), "Ron Weasly"); //Вынести сравнение в
                    // проперти файл и сравнивать его от туда
                    System.out.print(" Клиент: " + allCustomer.get(i).toString() + " с индексом - " + i +
                            " является пользователем банка.");

            }
        }
    }
}
