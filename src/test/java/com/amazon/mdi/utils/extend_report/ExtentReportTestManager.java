package com.amazon.mdi.utils.extend_report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportTestManager {

    private ExtentReportTestManager(){}

    private static ThreadLocal<ExtentTest> extentReportTestThreadLocal = new ThreadLocal<ExtentTest>();

    public static ExtentTest getExtentReportText(){
        return extentReportTestThreadLocal.get();
    }

    public static void setExtentReportTest(ExtentTest extentReport){
        extentReportTestThreadLocal.set(extentReport);
    }

    public static void unLoad(){
        extentReportTestThreadLocal.remove();
    }

}
