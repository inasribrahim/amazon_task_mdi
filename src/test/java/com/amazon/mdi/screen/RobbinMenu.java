package com.amazon.mdi.screen;

import com.amazon.mdi.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RobbinMenu extends BaseScreen {

    TodaysDealsScreen todaysDealsScreen;
    public void clickOnTodayDetailsLink(){
        WebElement todayDetailsLink = DriverManager.getWebDriver().findElement(By.xpath("//a[starts-with(text(), 'Today')]"));
        clickOnElementUsingJS(todayDetailsLink);
    }


    public RobbinMenu(){
        todaysDealsScreen = new TodaysDealsScreen();
    }

    public TodaysDealsScreen getTodaysDealsScreen(){
        return todaysDealsScreen;
    }

}
