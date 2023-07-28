package com.amazon.mdi.screen;

import org.openqa.selenium.By;

public class SignIn extends BaseScreen{

    private final By emailField = By.id("ap_email");
    private final By continueButton = By.id("continue");

    private final By emailNotFoundMessage = By.tagName("span");

    public String emailNotFoundErrorMessage(){
        return getElementText(emailNotFoundMessage);
    }
    public SignIn enterEmailAddress(String emailAddress){
        waitUtils.waitUntilElementIsPresence(emailField).sendKeys(emailAddress);
        return this;
    }

    public SignIn clickOnContinueButton(){
        waitUtils.waitUntilElementUntilIsClickable(continueButton).click();
        return this;
    }
}
