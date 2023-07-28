package com.amazon.mdi.screen;


import com.amazon.mdi.driver.DriverManager;
import com.amazon.mdi.waits.WaitUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import java.util.List;
import java.io.File;


public class BaseScreen {

    Actions actions;
    WaitUtils waitUtils = new WaitUtils();

    JavascriptExecutor executor;
    protected String constructXpath(String xpath , String replacingStr){
        return String.format(xpath,replacingStr);
    }
    protected WebElement getWebElement(By by){
      return waitUtils.waitUntilElementUntilIsVisible(by);
    }

    public List<WebElement> getElements(By selector) {
        waitUtils.waitUntilElementUntilIsVisible(selector);
        return DriverManager.getWebDriver().findElements(selector);
    }
    public void scrollToElement(By selector) {
        WebElement element = getWebElement(selector);
        actions = new Actions(DriverManager.getWebDriver());
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void getElementScreenShot(WebElement element) throws IOException {
        File takeElementScreenShot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(takeElementScreenShot,new File("./captcha.png"));
    }
    public boolean elementIsExisted(By by) {
        return DriverManager.getWebDriver().findElements(by).size() != 0;
    }

    public String getElementText(By by){
        return waitUtils.waitUntilElementIsPresence(by).getText();
    }

    public String getCurrentUrl(){
        return DriverManager.getWebDriver().getCurrentUrl();
    }

    public void back() throws InterruptedException {
        DriverManager.getWebDriver().navigate().back();
        waitUtils.sleep(8000);
    }

    public void clickOnElementUsingJS(WebElement link){
        executor = (JavascriptExecutor) DriverManager.getWebDriver();
        executor.executeScript("arguments[0].click();", link);
    }
}
