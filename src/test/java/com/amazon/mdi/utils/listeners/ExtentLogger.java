package com.amazon.mdi.utils.listeners;

import com.amazon.mdi.driver.DriverManager;
import com.amazon.mdi.utils.extend_report.ExtentReportTestManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public final class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){
        ExtentReportTestManager.getExtentReportText().pass(message);
    }
    public static void fail(String message){
        ExtentReportTestManager.getExtentReportText().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());    }
    public static void skip(String message){
        ExtentReportTestManager.getExtentReportText().skip(message);
    }

    public static String getBase64Image(){
        return ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
