package com.globalsqa.tests;

import com.globalsqa.pages.LoginPage;
import com.globalsqa.pages.ManagerPage;
import com.globalsqa.utils.ConfigurationReader;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerFunctionTest extends BaseTest {

    @Test
        @DisplayName("Тест проверяет наличие трех основных функций в кабинете менеджера")
        @Description("Этот тест проверяет наличие трех кнопок в кабинете менеджера  для выполнения своих трех функций")
        @Severity(CRITICAL)
        @Owner("Denys Nazarov")
        @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager")
        @Issue("AUTH-555")
        @TmsLink("TMS-5555")
        public void testingTheThreeFunctionsOfAManager() throws InterruptedException {
      /*  WebElement addNewCustonerButton = new ManagerPage(context).addNewCustonerButton;
        boolean isDisplayed (By Webelement addNewCustonerButton) {
                try {
                    return context.driver.findElement(new ManagerPage(context).addNewCustonerButton)).isDisplayed();
                } catch (NoSuchElementException e) {
                    return false;
                }
            }
            Assert.assertTrue(isDisplayed(new ManagerPage(context).addNewCustonerButton));*/
//        context.driver.get(ConfigurationReader.get("base_url"));
//        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        new LoginPage(context).loginAsBankManager();
        Thread.sleep(3000);
        assertTrue(new ManagerPage(context).addNewCustonerButton.isEnabled());
        Thread.sleep(3000);
        }
}
