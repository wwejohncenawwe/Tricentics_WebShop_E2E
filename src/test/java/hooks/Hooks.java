package hooks;

import java.time.Duration;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void setup(io.cucumber.java.Scenario scenario) {
		System.setProperty("testName", scenario.getName().replaceAll(" ", "_"));
		launchBrowser();
		maximizeWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loadUrl();
	}
		
	
	@After
	public void teardown() {
		captureScreenshot(driver,"TC "+System.currentTimeMillis());
		if(driver!=null) {
			quitBrowser();
			driver = null;
		}
	}



}
