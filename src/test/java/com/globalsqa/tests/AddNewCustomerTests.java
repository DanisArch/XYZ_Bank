package com.globalsqa.tests;


import com.globalsqa.context.NewCustomerInfo;
import com.globalsqa.pages.CustomerPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddNewCustomerTests extends BaseTest {

    @Test
    @DisplayName("Создание нового клиента")
    @Description("Этот тест проверяет возможность менеджера создать нового пользователя XYZ Bank")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager")
    @Issue("AUTH-222")
    @TmsLink("TMS-2222")
    public void AddNewCustomerTest() {
        NewCustomerInfo newCustomer = new NewCustomerInfo("David", "Aguero", "AI001E");
        CustomerPage.loginButton.click();
  /*      driver.

        assertTrue(new LoginPage(context)
                .loginAsStandardUser()
                .getFooterText()
                .contains(""));*/
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

        //    assertEquals("",
        //            new LoginPage(context).incorrectLoginAs("",""));
    }

}