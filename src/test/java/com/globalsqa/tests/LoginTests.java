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

import java.time.Duration;

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
    @TmsLink("TMS-2222")
    public void checkCustomerLoginButtonTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement customerButton = new LoginPage(context).customerLoginButton;
        boolean actualValue = customerButton.isEnabled();
        assertTrue(actualValue); //Добавить сообщение о проверке
        //Логи нужно/желательно вести не в самом тесте, а выносить их в метод. Для этого у Алюра есть специальный
        // метод, который помогает вести логи (разобраться с этим вопросом
        /*
        if (actualValue)
            System.out.println("Button is enabled");
        else
            System.out.println("Button is disabled");
*/
        Assertions.assertEquals(new LoginPage(context).customerLoginButton.getText(), "Customer Login");
    }

    @Test
    @DisplayName("Тест проверяет наличие кнопки для авторизации менеджера")
    @Description("Этот тест проверяет наличие кнопки для авторизации менеджера и правильность текста, который " +
            "написан на кнопке")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("AUTH-333")
    @TmsLink("TMS-3333")
    public void checkBankManagerLoginButtonTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement managerButton = new LoginPage(context).BankManagerLoginButton;
        boolean actualValue = managerButton.isEnabled();
        assertTrue(actualValue);
        Assertions.assertEquals(new LoginPage(context).BankManagerLoginButton.getText(), "Bank Manager Login");
    }
}
