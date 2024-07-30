package com.globalsqa.tests;

import com.globalsqa.pages.LoginPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import jdk.jfr.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Тест проверяет наличие кнопки для авторизации пользователя")
    @Description("Этот тест проверяет наличие кнопки для авторизации пользователя и правильность текста, который " +
            "написан на кнопке")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("AUTH-222")
    @TmsLink("TMS-2222-1")
    @Label("UI Testing")
    public void checkCustomerLoginButtonTest() {

        assertTrue(new LoginPage(context)
                .checkCustomerLoginButton());

        Assertions.assertEquals("Customer Login",new LoginPage(context)
                .customerLoginButton.getText());
    }

    @Test
    @DisplayName("Тест проверяет наличие кнопки для авторизации менеджера")
    @Description("Этот тест проверяет наличие кнопки для авторизации менеджера и правильность текста, который " +
            "написан на кнопке")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("AUTH-222")
    @TmsLink("TMS-2222-1")
    @Label("UI Testing")
    public void checkBankManagerLoginButtonTest() {

        assertTrue(new LoginPage(context)
                .checkBankManagerLoginButton());

        Assertions.assertEquals("Bank Manager Login", new LoginPage(context)
                .BankManagerLoginButton.getText());
    }
}
