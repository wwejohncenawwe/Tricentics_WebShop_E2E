package step;

import org.junit.Assert;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjectmanager.PageObjectManager;

public class HomeStep extends BaseClass{

	PageObjectManager page = new PageObjectManager();

	@Given("User navigate to demowebshop")
	public void user_navigate_to_demowebshop() {
		String title =	getTitle();
		Assert.assertEquals(title,"Demo Web Shop");
		logger.info("User navigated to demowebshop");
	}

	@Then("User should verify the demowebshop logo in the homepage")
	public void user_should_verify_the_demowebshop_logo_in_the_homepage() {
		boolean logo = page.getHomePage().getHomepage_logo().isDisplayed();
		Assert.assertTrue(logo);
		logger.info("User verified the demowebshop logo successfully");
		captureScreenshot(driver,"Homepage Logo");
	}


}
