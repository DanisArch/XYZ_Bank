package com.globalsqa.tests;

import com.globalsqa.context.TestContext;
import com.globalsqa.utils.ConfigurationReader;
import com.globalsqa.utils.DriverFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {

    TestContext context;

    @BeforeEach
    public void beforeEach(){
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js =  (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("base_url"));
    }

    @AfterEach
    public void afterEach(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) context.driver;
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Скриншот ошибки", new ByteArrayInputStream(screenshot));
        if(context.driver !=null){
            context.driver.quit();
        }
    }
}
