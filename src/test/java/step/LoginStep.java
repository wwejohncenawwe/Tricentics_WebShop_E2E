package step;

import org.junit.Assert;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;

public class LoginStep extends BaseClass {

	PageObjectManager page = new PageObjectManager();

	@Given("User click on login link")
	public void user_click_on_login_link() {
		button(page.getHomePage().getLogin_link());
		logger.info("Login link clicked");
	}

	@Then("User navigate to demowebshop login page")
	public void user_navigate_to_demowebshop_login_page() {
		String login_head = page.getLoginPage().getLogin_header().getText();
		Assert.assertEquals("User navigated to login page","Welcome, Please Sign In!",login_head );
		logger.info("Navigated to login page");
	}

	@When("User enters the valid  {string},{string}")
	public void user_enters_the_valid(String email, String pword) {
		logger.debug("Entering valid email and password");
		type(page.getLoginPage().getLogin_emilid(),email);
		type(page.getLoginPage().getLogin_password(),pword);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		button(page.getLoginPage().getLogin_btn());
		logger.info("Login button clicked");
	}

	@Then("User should verify login status {string}")
	public void user_should_verify_login_status(String string2) {
		if(page.getLoginPage().getLogin_account_email().isDisplayed()) {
			String login_success = page.getLoginPage().getLogin_account_email().getText();
			Assert.assertEquals(string2, login_success);
			logger.info("Login successfully");
			captureScreenshot(driver,"Login Success");
		}else {
			logger.error("Login failed " + string2 + " not displayed");
			Assert.assertTrue(false);
		}
	}


	@When("User enters pword {string}")
	public void user_enters_pword(String pword) {
		logger.debug("Entering password");
		type(page.getLoginPage().getLogin_password(),pword);
	}

	@Then("User should verify the without email error message status {string}")
	public void user_should_verify_the_without_email_error_message_status(String status) {
		if(page.getLoginPage().getWithout_loginemail().isDisplayed()) {
			String without_email_error = page.getLoginPage().getWithout_loginemail().getText();
			Assert.assertEquals(status, without_email_error);
			logger.info("Login without email validated");
			captureScreenshot(driver,"Login without Email");
		}else {
			logger.error("Login without email failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters email {string}")
	public void user_enters_email(String email) {
		logger.debug("Entering email");
		type(page.getLoginPage().getLogin_emilid(),email);
	}

	@Then("User should verify without pword error message status {string}")
	public void user_should_verify_without_pword_error_message_status(String status) {
		if(page.getLoginPage().getWithout_loginemail().isDisplayed()) {
			String without_pword_error = page.getLoginPage().getWithout_loginemail().getText();
			Assert.assertEquals(status, without_pword_error);
			logger.info("Login without password validated");
			captureScreenshot(driver,"Login without Password");
		}else {
			logger.error("Login without password failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters the invalid pword  {string},{string}")
	public void user_enters_the_invalid_pword(String email, String pword) {
		logger.debug("Entering invalid password");
		type(page.getLoginPage().getLogin_emilid(),email);
		type(page.getLoginPage().getLogin_password(),pword);
	}
	@Then("User should verify invalid pword error message status {string}")
	public void user_should_verify_invalid_pword_error_message_status(String status) {
		if(page.getLoginPage().getInvalid_pwordlogin().isDisplayed()) {
			String invalid_pword_error = page.getLoginPage().getInvalid_pwordlogin().getText();
			Assert.assertEquals(status, invalid_pword_error);
			logger.info("Login invalid password validated");
			captureScreenshot(driver,"Login Invalid Password");
		}else {
			logger.error("Login invalid password failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters the invalid email  {string},{string}")
	public void user_enters_the_invalid_email(String email, String pword) {
		logger.debug("Entering invalid email");
		type(page.getLoginPage().getLogin_emilid(),email);
		type(page.getLoginPage().getLogin_password(),pword);
	}

	@Then("User should verify the invalid email error message status {string}")
	public void user_should_verify_the_invalid_email_error_message_status(String status) {
		if(page.getLoginPage().getInvalid_emaillogin().isDisplayed()) {
			String invalid_email_error = page.getLoginPage().getInvalid_emaillogin().getText();
			Assert.assertEquals(status, invalid_email_error);
			logger.info("Login invalid email validated");
			captureScreenshot(driver,"Login Invalid Email");
		}else {
			logger.error("Login invalid email failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters the invalid email format {string},{string}")
	public void user_enters_the_invalid_email_format(String email, String pword) {
		logger.debug("Entering invalid email format");
		type(page.getLoginPage().getLogin_emilid(),email);
		type(page.getLoginPage().getLogin_password(),pword);
	}

	@Then("User should verify wrong email format error message status {string}")
	public void user_should_verify_wrong_email_format_error_message_status(String status) {
		if(page.getLoginPage().getInvalid_email_length().isDisplayed()) {
			String invalid_email_format = page.getLoginPage().getInvalid_email_length().getText();
			Assert.assertEquals(status, invalid_email_format);
			logger.info("Login invalid email format validated");
			captureScreenshot(driver,"Login Inavlid Email Format");
		}else {
			logger.error("Login invalid email format failed");
			Assert.assertTrue(false);
		}
	}

}
