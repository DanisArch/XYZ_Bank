package com.globalsqa.tests;

import com.globalsqa.utils.ConfigurationReader;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBankName extends BaseTest {
@Test
@DisplayName("Проверка логотипа банка")
@Description("Этот тест проверяет правильность отображения названия банка \"XYZ Bank\"")
@Severity(CRITICAL)
@Owner("Denys Nazarov")
@Link(name = "XYZ Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
@Issue("AUTH-111")
@TmsLink("TMS-1111")
public void checkBankNameTest() throws InterruptedException {
    context.driver.get(ConfigurationReader.get("base_url"));
    context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    WebElement mainHeading = context.driver.findElement(By.className("mainHeading"));
    assertEquals("XYZ Bank", mainHeading.getText());
}
}
