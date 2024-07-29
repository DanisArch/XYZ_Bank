package com.globalsqa.tests;

import com.globalsqa.pages.LoginPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBankNameTests extends BaseTest {

    @Test
    @DisplayName("Проверка логотипа банка")
    @Description("Этот тест проверяет правильность отображения названия банка \"XYZ Bank\"")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("AUTH-111")
    @TmsLink("TMS-1111-1")
    public void checkBankNameTest() {

        assertEquals("XYZ Bank", new LoginPage(context)
                .findLogo());
    }

    @Test
    @DisplayName("Проверка наличия правильного имени банка в Title")
    @Description("Этот тест проверяет правильность отображения названия банка \"XYZ Bank\" в шапке сайта")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("AUTH-111")
    @TmsLink("TMS-1111-2")
    public void checkBankNameTitleTest() throws InterruptedException {

        assertEquals("XYZ Bank", context.driver.getTitle());
    }
}
