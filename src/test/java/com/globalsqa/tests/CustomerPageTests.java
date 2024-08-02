package com.globalsqa.tests;

import com.globalsqa.pages.CustomerPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class CustomerPageTests extends BaseTest {

    @Test
    @DisplayName("Тест проверяет наличие пользователя в списке всех пользователей")
    @Description("Этот тест проверяет является ли данный человек клиентом нашего банка")
    @Severity(NORMAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer")
    @Issue("AUTH-444")
    @TmsLink("TMS-4444")
    public void findCustomerByNameTest() {

        if (new CustomerPage(context).haveBankCustomer()) {
            Assertions.assertEquals("Ron Weasly", new CustomerPage(context)
                    .findCustomerByName("Ron Weasly"));
        } else {
            Assertions.fail("У банка нет клиентов");
        }
    }
}


