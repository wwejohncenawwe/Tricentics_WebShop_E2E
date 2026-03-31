package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("WebShop Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}