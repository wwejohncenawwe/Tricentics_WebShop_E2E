package step;

import org.junit.Assert;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;

public class RegisterStep extends BaseClass {

	PageObjectManager page = new PageObjectManager();

	@Given("User click on register link")
	public void user_click_on_register_link() {
		button(page.getHomePage().getRegister_link());
		logger.info("Register link clicked");
	}

	@Then("User navigate to demowebshop register page")
	public void user_navigate_to_demowebshop_register_page() {
		String header = page.getRegisterPage().getRegisterpage_header().getText();
		Assert.assertEquals("User navigated to register page","Register",header);
		logger.info("User navigated to register page");
	}

	@When("User enters valid data {string},{string},{string},{string},{string} for registration details")
	public void user_enters_valid_data_for_registration_details(String fname, String lname, String email, String pass, String cpass) {
		logger.debug("Entering valid firstname,lastname,email,password,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@When("User click on register button")
	public void user_click_on_register_button() {
		button(page.getRegisterPage().getRegister_btn());
		logger.info("Register button clicked");
	}

	@Then("User should verify success register status {string}")
	public void user_should_verify_success_register_status(String status1) {
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
			logger.info("Navigated to alert");
		}
		else if(page.getRegisterPage().getRegister_successmsg().isDisplayed()) {
			String reister_successmsg = page.getRegisterPage().getRegister_successmsg().getText();
			Assert.assertEquals(reister_successmsg,status1);
			button(page.getRegisterPage().getRegister_continuebtn());
			logger.info("Registered successfully");
			captureScreenshot(driver,"Register Success");
		}else {
			logger.error("Register failed " + status1 + " not displayed");
			Assert.assertTrue(false);
		}
	}

	@Given("User click logout link")
	public void user_click_logout_link() {
		button(page.getHomePage().getLogout());
		logger.info("Logout link clicked");
	}

	@When("User enters invalid email {string},{string},{string},{string},{string} for registration details")
	public void user_enters_invalid_email_for_registration_details(String fname, String lname, String email, String pass, String cpass) {
		logger.debug("Entering invalid email and firstname,lastname,password,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@Then("User should verify invalid email error message status {string}")
	public void user_should_verify_invalid_email_error_message_status(String status) {
		if(page.getRegisterPage().getWrong_email().isDisplayed()) {
			String wrong_emailmsg = page.getRegisterPage().getWrong_email().getText();
			Assert.assertEquals(wrong_emailmsg,status);
			logger.info("Register invalid email validated");
			captureScreenshot(driver,"Invalid Email");
		}else {
			logger.error("Register invalid email failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters exists email {string},{string},{string},{string},{string} for registration details")
	public void user_enters_exists_email_for_registration_details(String fname, String lname, String email, String pass, String cpass) {
		logger.debug("Entering exist email and firstname,lastname,password,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@Then("User should verify exists email error message status {string}")
	public void user_should_verify_exists_email_error_message_status(String status) {
		if(page.getRegisterPage().getExists_email().isDisplayed()) {
			String exists_emailmsg = page.getRegisterPage().getExists_email().getText();
			Assert.assertEquals(exists_emailmsg,status);
			logger.info("Register exist email validated");
			captureScreenshot(driver,"Exists Email");
		}else {
			logger.error("Register exist email failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters without email {string},{string},{string},{string} for registration details")
	public void user_enters_without_email_for_registration_details(String fname, String lname, String pass, String cpass) {
		logger.debug("Entering without email and firstname,lastname,password,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@Then("User should verify without email error message status {string}")
	public void user_should_verify_without_email_error_message_status(String status) {
		if(page.getRegisterPage().getWithout_email().isDisplayed()) {
			String without_emailmsg = page.getRegisterPage().getWithout_email().getText();
			Assert.assertEquals(without_emailmsg,status);
			logger.info("Register without email validated");
			captureScreenshot(driver,"Without Email");
		}else {
			logger.error("Register without email failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters without fname data {string},{string},{string},{string} for registration details")
	public void user_enters_without_fname_data_for_registration_details(String lname, String email, String pass, String cpass) {
		logger.debug("Entering without firstname and lastname,email,password,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@Then("User should verify without fname error message status {string}")
	public void user_should_verify_without_fname_error_message_status(String status) {
		if(page.getRegisterPage().getWithout_fname().isDisplayed()) {
			String without_fname = page.getRegisterPage().getWithout_fname().getText();
			Assert.assertEquals(without_fname,status);
			logger.info("Register without firstname validated");
			captureScreenshot(driver,"Without Firstname");
		}else {
			logger.error("Register without firstname failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters without lname data {string},{string},{string},{string} for registration details")
	public void user_enters_without_lname_data_for_registration_details(String fname, String email, String pass, String cpass) {
		logger.debug("Entering without lastname and firstname,email,password,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@Then("User should verify without lname error message status {string}")
	public void user_should_verify_without_lname_error_message_status(String status) {
		if(page.getRegisterPage().getWithout_lname().isDisplayed()) {
			String without_lname = page.getRegisterPage().getWithout_lname().getText();
			Assert.assertEquals(without_lname,status);
			logger.info("Register without lastname validated");
			captureScreenshot(driver,"Without Lastname");
		}else {
			logger.error("Register without lastname failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters without pword and cpword data {string},{string},{string} for registration details")
	public void user_enters_without_pword_and_cpword_data_for_registration_details(String fname, String lname, String email) {
		logger.debug("Entering without password,confirm password and firstname,lastname,email");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
	}

	@Then("User should verify without pword and cpword error message status {string}")
	public void user_should_verify_without_pword_and_cpword_error_message_status(String status) {
		if(page.getRegisterPage().getWithout_pword().isDisplayed()) {
			String without_pword = page.getRegisterPage().getWithout_pword().getText();
			Assert.assertEquals(without_pword,status);
			logger.info("Register without password and confirm password validated");
			captureScreenshot(driver,"Without Password and Confirm Password");
		}else {
			logger.error("Register without password and confirm password failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters without pword data {string},{string},{string},{string} for registration details")
	public void user_enters_without_pword_data_for_registration_details(String fname, String lname, String email, String cpass) {
		logger.debug("Entering without password and firstname,lastname,email,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}
	@Then("User should verify without cpword error message status {string}")
	public void user_should_verify_without_cpword_error_message_status(String status) {
		if(page.getRegisterPage().getNotmatch_pword_cpword().isDisplayed()) {
			String notmatch_pword = page.getRegisterPage().getNotmatch_pword_cpword().getText();
			Assert.assertEquals(notmatch_pword,status);
			logger.info("Register without password validated");
			captureScreenshot(driver,"Without Password");
		}else {
			logger.error("Register without password failed");
			Assert.assertTrue(false);
		}
	}

	@When("User enters with invalid pword length data {string},{string},{string},{string},{string} for registration details")
	public void user_enters_with_invalid_pword_length_data_for_registration_details(String fname, String lname, String email, String pass, String cpass) {
		logger.debug("Entering invalid password length and firstname,lastname,email,confirm password");
		page.getRegisterPage().getMale_gender().click();
		type(page.getRegisterPage().getFirstname(), fname);
		type(page.getRegisterPage().getLastname(),lname);
		type(page.getRegisterPage().getRegister_emilid(),email);
		type(page.getRegisterPage().getRegister_password(),pass);
		type(page.getRegisterPage().getConfirm_password(),cpass);
	}

	@Then("User should verify invalid pword length error message status {string}")
	public void user_should_verify_invalid_pword_length_error_message_status(String status) {
		if(page.getRegisterPage().getWrong_pword_length().isDisplayed()) {
			String invalid_pword_length = page.getRegisterPage().getWrong_pword_length().getText();
			Assert.assertEquals(invalid_pword_length,status);
			logger.info("Register invalid password length validated");
			captureScreenshot(driver,"Invalid Password Length");
		}else {
			logger.error("Register invalid password length failed");
			Assert.assertTrue(false);
		}
	}


}
