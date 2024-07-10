package com.globalsqa.tests;


import com.globalsqa.pages.AddNewCustomerPage;
import com.globalsqa.pages.CustomerPage;
import com.globalsqa.pages.LoginPage;
import com.globalsqa.pages.ManagerPage;
import com.globalsqa.utils.ConfigurationReader;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddNewCustomer extends BaseTest {

    @Test
    @DisplayName("Создание нового клиента")
    @Description("Этот тест проверяет возможность менеджера создать нового пользователя XYZ Bank")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager")
    @Issue("AUTH-222")
    @TmsLink("TMS-2222")
    public void AddNewCustomerTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        NewCustomerInfo newCustomer = new NewCustomerInfo("David","Aguero","AI001E");
        CustomerPage.loginButton.click();
  /*      driver.

        assertTrue(new LoginPage(context)
                .loginAsStandardUser()
                .getFooterText()
                .contains("Sauce Labs"));*/
    }

    @Test
    @DisplayName("Тест авторизации c отсутствующим именем")
    @Description("Этот тест проверяет логирование в систему без имени пользователя")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "Магазин товаров", url = "https://www.saucedemo.com/")
    @Issue("AUTH-555")
    @TmsLink("TMS-555")
    public void emptyLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));

    //    assertEquals("Epic sadface: Username is required",
    //            new LoginPage(context).incorrectLoginAs("",""));
    }

    @Test
    public void blockedUserLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
//        assertEquals(
//                "Epic sadface: Sorry, this user has been locked out.",
//                new LoginPage(context).incorrectLoginAs("locked_out_user","secret_sauce")
//        );
    }
}