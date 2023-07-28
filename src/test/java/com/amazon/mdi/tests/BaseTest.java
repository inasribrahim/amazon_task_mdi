package com.amazon.mdi.tests;

import com.amazon.mdi.browser.Browser;
import com.amazon.mdi.driver.Driver;
import com.amazon.mdi.utils.read_properties.ReadProperties;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    protected static Browser browser = new Browser();
    public static String getBrowserName() throws IOException {
        return ReadProperties.setAmazonConfig().getProperty("browserName");
    }

    @BeforeTest(alwaysRun = true)
    protected void setUp() throws IOException {
        Driver.initDriver(getBrowserName());
        Driver.setBrowserMaximize();
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        Driver.closeDriver();
    }
}
