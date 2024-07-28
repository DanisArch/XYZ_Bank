package com.globalsqa.pages;

import com.globalsqa.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransitionsPage extends BasePage{

    public TransitionsPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button[ng-click='back()']")
    public WebElement backButton;

// table class="table table-bordered table-striped"
}
