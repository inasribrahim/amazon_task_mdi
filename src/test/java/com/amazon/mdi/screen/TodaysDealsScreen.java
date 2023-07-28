package com.amazon.mdi.screen;

import com.amazon.mdi.driver.DriverManager;
import org.openqa.selenium.By;

public class TodaysDealsScreen extends BaseScreen{
    private final By products = By.xpath("//a[@class=\"a-link-normal DealLink-module__dealLink_3v4tPYOP4qJj9bdiy0xAT a-color-base a-text-normal\"]");

    public TodaysDealsScreen clickOnCategoryName(String name) throws InterruptedException {
        String xpath = "//span[text()='"+name+"']";
        waitUtils.sleep(2000);
        DriverManager.getWebDriver().findElement(By.xpath(constructXpath(xpath,name))).click();
        return this;
    }

    public TodaysDealsScreen clickOnProduct(int index) throws InterruptedException {
        waitUtils.sleep(3000);
        getElements(products).get(index - 1).click();
        return this;
    }

}

