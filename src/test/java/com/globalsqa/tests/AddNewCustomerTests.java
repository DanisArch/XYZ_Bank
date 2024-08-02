package com.globalsqa.tests;

import com.globalsqa.pages.AddNewCustomerPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddNewCustomerTests extends BaseTest {

    @Test
    @DisplayName("Создание нового клиента банка")
    @Description("Этот тест проверяет возможность менеджера создать нового пользователя XYZ Bank")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust")
    @Issue("AUTH-222")
    @TmsLink("TMS-2222")
    public void AddNewCustomerTest() {

        String expectedTextPattern = "Customer added successfully with customer id :\\d+";
        assertTrue(Pattern.matches(expectedTextPattern ,
                new AddNewCustomerPage(context)
                .addNewCustomer()));
    }

    @Test
    @DisplayName("Тест авторизации c отсутствующим именем")
    @Description("Этот тест проверяет логирование в систему без имени пользователя")
    @Severity(MINOR)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust")
    @Issue("AUTH-555")
    @TmsLink("TMS-5555")
    public void emptyNameOfCustomerTest() {

        //    assertEquals("",
        //            new LoginPage(context).incorrectLoginAs("",""));
    }

}


//Please fill in this field.
//Please check the details. Customer may be duplicate.