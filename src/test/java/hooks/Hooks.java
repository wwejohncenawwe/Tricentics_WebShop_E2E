package hooks;

import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utilities.ExtentManager;

public class Hooks extends BaseClass {

	public static ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;
	
	@Before
	public void setup(io.cucumber.java.Scenario scenario) {
		System.setProperty("testName", scenario.getName().replaceAll(" ", "_"));
		launchBrowser();
		maximizeWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loadUrl();
		test = extent.createTest(scenario.getName());
	}
		
	
	@After
	public void teardown(io.cucumber.java.Scenario scenario) {
		captureScreenshot(driver,"TC "+System.currentTimeMillis());
		if (scenario.isFailed()) {
            test.fail("Test Failed: " + scenario.getName());
            	captureScreenshot(driver, scenario.getName());//ScreenshotUtil.capture(driver, scenario.getName());

	        try {
	            test.fail("Test Failed",
	                MediaEntityBuilder.createScreenCaptureFromPath(scenario.getName()).build());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        } else {
            test.pass("Test Passed: " + scenario.getName());
        }
		if(driver!=null) {
			quitBrowser();
			driver = null;
		}
	}
	
	 @AfterAll
	    public static void tearDown() {
	        extent.flush();
	    }



}
