package com.amazon.mdi.screen;

import com.amazon.mdi.utils.captcha_resolve.CaptchaSolver;

import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;

import java.io.IOException;

public class CaptchaScreen extends BaseScreen {

    private final By captchaField = By.id("captchacharacters");
    private final By captchaImage = By.tagName("img");
    private final By tryDifferentImage = By.tagName("a");
    private final By textError = By.xpath("//h4[text()='Enter the characters you see below']");
    private void clickTryDifferentImageLink(){
        waitUtils.waitUntilElementUntilIsClickable(tryDifferentImage).click();
    }
    private void enterCaptchaText(String captchaText){
        waitUtils.waitUntilElementIsPresence(captchaField).sendKeys(captchaText);
    }

    public void solveCaptcha() throws IOException, TesseractException {
        boolean flag  = true;
        if(elementIsExisted(textError) == flag){
            getElementScreenShot(waitUtils.waitUntilElementUntilIsVisible(captchaImage));
            String captchaText = CaptchaSolver.getTextFromCaptchaImage();
            enterCaptchaText(captchaText);
            clickTryDifferentImageLink();
        }
    }
}
