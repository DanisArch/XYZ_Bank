package com.globalsqa.tests;

import com.globalsqa.pages.AddNewCustomerPage;
import com.globalsqa.pages.LoginPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountPageTests extends BaseTest {

    @Test
    @DisplayName("Тест пополнения счета клиента")
    @Description("Этот тест проверяет возможность клиенту Harry Potter сделать депозит на счет 1004 в USD")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account")
    @Issue("AUTH-666-1")
    @TmsLink("TMS-6666-1")
    public void depositCustomerTest() {

  //      String expectedTextPattern = "Deposit Successful";
        assertEquals("Deposit Successful" ,
                new LoginPage(context)
                        .loginAsCustomer()
                        .enterWithLastName("Harry Potter")
                        .makeDeposit("4000")
                        .makeDepositPotter());
    }

    @Test
    @DisplayName("Тест cнятия средств со счета клиента")
    @Description("Этот тест проверяет возможность клиенту Hermoine Granger снять деньги со счета 1003 в Rupee")
    @Severity(CRITICAL)
    @Owner("Denys Nazarov")
    @Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account")
    @Issue("AUTH-666-2")
    @TmsLink("TMS-6666-2")
    public void withdrawlCustomerTest() throws InterruptedException {
//Тест правильный, но из-за особенности работы сайта, при пополнении счета, с новым запуском браузера сумма
// пополнения не отображается
        assertEquals("Transaction successful" ,
                new LoginPage(context)
                        .loginAsCustomer()
                        .enterWithLastName("Hermoine Granger")
                        .makeWithdrawHermoineGranger("10","1003")
                        .makeWithdrawHermoineGrangerConfirm());
    }
}


