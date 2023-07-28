package com.amazon.mdi.utils.extend_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.IOException;


public final class ExtendReport {
    private ExtendReport(){}
    public static ExtentReports extentReports;

    public static void setUpExtentReport(){
        if(isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("Report.html")
                    .viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[] {
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.AUTHOR,
                            ViewName.EXCEPTION,
                            ViewName.LOG,
                    })
                    .apply();
            extentReports.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Amazon");
            spark.config().enableOfflineMode(true);
        }
    }

    public static void createTest(String testCaseName) throws IOException {
        ExtentReportTestManager.setExtentReportTest(extentReports.createTest(testCaseName));
    }
    public static void flushExtentReport() throws IOException {
        if(isNotNull(extentReports)){
            extentReports.flush();
        }
    }

    private static boolean isNull(Object object) {
        return object == null;
    }
    private static boolean isNotNull(Object object) {
        return object != null;
    }
}
