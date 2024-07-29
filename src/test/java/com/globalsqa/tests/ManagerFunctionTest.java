package com.globalsqa.tests;

import com.globalsqa.pages.LoginPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;


import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerFunctionTest extends BaseTest {

    @Test
    @DisplayName("Проверка наличия кнопки для добавления нового пользователя в кабинете менеджера")
    @Description("Этот тест проверяет наличие кнопки для добавления нового пользователя в кабинете менеджера")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager")
    @Issue("AUTH-555")
    @TmsLink("TMS-5555-1")
    public void AvailabilityAddNewCustomerButtonTest() throws NoSuchElementException {

        assertTrue(new LoginPage(context)
                .loginAsBankManager()
                .waitAddNewCustomerButton());
    }

    @Test
    @DisplayName("Проверка наличия кнопки открытия счета для нового пользователя в кабинете менеджера")
    @Description("Этот тест проверяет наличие кнопки для открытия счета для нового пользователя в кабинете менеджера")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager")
    @Issue("AUTH-555")
    @TmsLink("TMS-5555-2")
    public void AvailabilityOpenCustomerAccountButtonTest() throws NoSuchElementException {

        assertTrue(new LoginPage(context)
                .loginAsBankManager()
                .waitOpenCustomerAccountButton());
    }

    @Test
    @DisplayName("Проверка наличия кнопки просмотра всех пользователей банка в кабинете менеджера")
    @Description("Этот тест проверяет наличие кнопки просмотра всех пользователей банка в кабинете менеджера")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager")
    @Issue("AUTH-555")
    @TmsLink("TMS-5555-3")
    public void AvailabilityShowAllCustomersButtonTest() throws NoSuchElementException {

        assertTrue(new LoginPage(context)
                .loginAsBankManager()
                .waitShowAllCustomersButton());
    }
}
