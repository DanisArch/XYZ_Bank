package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    TestContext context;

    public BasePage(TestContext context){
        this.context = context;
        PageFactory.initElements(context.driver, this);
    }
//Где должны находится элементы, которые присутствуют на всех страницах сайта? Чтоб не дублировать
    @FindBy(css = "button.btn.home")
    public WebElement homePageButton;

    @Step("Вернутся на стартовую страницу сайта")
    public LoginPage backHomePage(){
        return new LoginPage(context);
    }

}
