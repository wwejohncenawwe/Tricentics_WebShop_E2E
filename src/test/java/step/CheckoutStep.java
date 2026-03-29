package step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;
import utilities.ReadExcel;

public class CheckoutStep extends BaseClass{
	
	PageObjectManager page = new PageObjectManager();
	ReadExcel ex = new ReadExcel();
	String path = "C:\\Users\\Mani\\IDE Workspace\\Webshop\\src\\test\\resources\\excel\\data.xls";
	String fname,lname,email,company,country,state,city,address1,address2,zip,phone,fax; 
	
	@Given("User click login link")
	public void user_click_login_link() {
		button(page.getHomePage().getLogin_link());
		logger.info("Login link clicked");
	}

	@Then("User navigate demowebshop login page")
	public void user_navigate_demowebshop_login_page() {
		String login_head = page.getLoginPage().getLogin_header().getText();
		Assert.assertEquals("User navigated to login page","Welcome, Please Sign In!",login_head );
		logger.info("Navigated to login page");
	}

	@When("User enters valid  {string},{string}")
	public void user_enters_valid(String email, String pword) {
		logger.debug("Entering valid email and password");
		type(page.getLoginPage().getLogin_emilid(),email);
		type(page.getLoginPage().getLogin_password(),pword);
	}

	@When("User click login button")
	public void user_click_login_button() {
		button(page.getLoginPage().getLogin_btn());
		logger.info("Login button clicked");
	}

	@Then("User should verify the login status {string}")
	public void user_should_verify_the_login_status(String string2) {
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
	
	@Then("User navigate to checkout url {string}")
	public void user_navigate_to_checkout_url(String url) {
		driver.get(url);
		logger.info("Hitting checkout URL");
	}
	
	@Given("User navigate to checkout page")
	public void user_navigate_to_checkout_page() {
		if(page.getCheckoutPage().getCheckout_head().getText()!=null) {
			Assert.assertTrue(true);
			logger.info("User navigated to checkout page");
		}else {
			logger.error("User unable to navigate to checkout page");
			Assert.assertTrue(false);
		}
	}

	@When("User enters billing address")
	public void user_enters_billing_address() {
		int rows = ex.getRowcount(path, 0);
		//int cols = ex.getCellcount(path, 0, 1);
		//for(int i=1;i<=rows;i++) {
		int i = 1;
			fname = ex.getCelldata(path, 0, i, 0);
			lname = ex.getCelldata(path, 0, i, 1);
			email = ex.getCelldata(path, 0, i, 2);
			company = ex.getCelldata(path, 0, i, 3);
			country = ex.getCelldata(path, 0, i, 4);
			state = ex.getCelldata(path, 0, i, 5);
			city = ex.getCelldata(path, 0, i, 6);
			address1 = ex.getCelldata(path, 0, i, 7);
			address2 = ex.getCelldata(path, 0, i, 8);
			zip = ex.getCelldata(path, 0, i, 9);
			phone = ex.getCelldata(path, 0, i, 10);
			fax = ex.getCelldata(path, 0, i, 11);

			if(page.getCheckoutPage().getBilling_address_head().isDisplayed()) {
				Assert.assertTrue(true);
				logger.debug("Entering billing address");
				if(page.getCheckoutPage().getFirst_name().getAttribute("value").equalsIgnoreCase(fname)) {
					logger.info("Firstname already fetched");
				}else {
					page.getCheckoutPage().getFirst_name().clear();
					type(page.getCheckoutPage().getFirst_name(), fname.trim());
					logger.info("Firstname entered");
				}
				if(page.getCheckoutPage().getLast_name().getAttribute("value").equalsIgnoreCase(lname)) {
					logger.info("Lastname already fetched");
				}else {
					page.getCheckoutPage().getLast_name().clear();
					type(page.getCheckoutPage().getLast_name(), lname.trim());
					logger.info("Lastname entered");
				}
				if(page.getCheckoutPage().getEmail_id().getAttribute("value").equalsIgnoreCase(email)) {
					logger.info("Email already fetched");
				}else {
					page.getCheckoutPage().getEmail_id().clear();
					type(page.getCheckoutPage().getEmail_id(), email.trim());
					logger.info("Email entered");
				}
				if(page.getCheckoutPage().getCompany_name().isEnabled()) {
					page.getCheckoutPage().getCompany_name().clear();
				}
				type(page.getCheckoutPage().getCompany_name(),company.trim());
				logger.info("Company entered");
				Select s1 = new Select(page.getCheckoutPage().getCountry());
				s1.selectByVisibleText(country.trim());
				logger.info("Country entered");
				Select s2 = new Select(page.getCheckoutPage().getState());
				s2.selectByVisibleText(state.trim());
				logger.info("State entered");
				if(page.getCheckoutPage().getCity().isEnabled()) {
					page.getCheckoutPage().getCity().clear();
				}
				type(page.getCheckoutPage().getCity(),city.trim());
				logger.info("City entered");
				if(page.getCheckoutPage().getAddress_1().isEnabled()) {
					page.getCheckoutPage().getAddress_1().clear();
				}
				type(page.getCheckoutPage().getAddress_1(),address1.trim());
				logger.info("Address1 entered");
				if(page.getCheckoutPage().getAddress_2().isEnabled()) {
					page.getCheckoutPage().getAddress_2().clear();
				}
				type(page.getCheckoutPage().getAddress_2(),address2.trim());
				logger.info("Address2 entered");
				if(page.getCheckoutPage().getZip().isEnabled()) {
					page.getCheckoutPage().getZip().clear();
				}
				type(page.getCheckoutPage().getZip(),zip.trim());
				logger.info("Zipcode entered");
				if(page.getCheckoutPage().getPhone_no().isEnabled()) {
					page.getCheckoutPage().getPhone_no().clear();
				}
				type(page.getCheckoutPage().getPhone_no(),phone.trim());
				logger.info("Phone no entered");
				if(page.getCheckoutPage().getFax_no().isEnabled()) {
					page.getCheckoutPage().getFax_no().clear();
				}
				type(page.getCheckoutPage().getFax_no(),fax.trim());
				logger.info("Fax no entered");
				captureScreenshot(driver,"Billing Address");
			}
			else {
				logger.error("Billing address failed to entered");
				Assert.assertTrue(false);
			}
	}

	@Then("User click on billing address continue button")
	public void user_click_on_billing_address_continue_button() {
		button(page.getCheckoutPage().getBilling_continue());
		logger.info("Billing address completed");
	}

	@Then("User select shipping address")
	public void user_select_shipping_address() {
		if(page.getCheckoutPage().getShipping_address_head().isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Selecting shipping address");
			Select s = new Select(page.getCheckoutPage().getShipping_address());
			s.selectByIndex(0);
			logger.debug("Selected billing address as shipping address");
			captureScreenshot(driver,"Shipping Address");
		}else {
			logger.error("Shipping address failed to entered");
			Assert.assertTrue(false);
		}
	}

	@Then("User click shipping address continue button")
	public void user_click_shipping_address_continue_button() {
		button(page.getCheckoutPage().getShipping_address_continue());
		logger.info("Shipping address completed");
	}

	@Then("User select shipping method")
	public void user_select_shipping_method() {
		if(page.getCheckoutPage().getShipping_method_head().isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Selecting shipping method");
			button(page.getCheckoutPage().getSecondnextday_air());
			logger.debug("Shipping method selected");
			captureScreenshot(driver,"Shipping Method");
		}else {
			logger.error("Shipping method failed");
			Assert.assertTrue(false);
		}   
	}

	@Then("User click  shipping method continue button")
	public void user_click_shipping_method_continue_button() {
		button(page.getCheckoutPage().getShipping_method_continue());
		logger.info("Shipping method completed");
	}

	@Then("User click cash on delivery method")
	public void user_click_cash_on_delivery_method() {
		if(page.getCheckoutPage().getPayment_method_head().isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Selecting payment method");
			button(page.getCheckoutPage().getCashon_delivery());
			logger.debug("Payment method cash on delivery selected");
			captureScreenshot(driver,"Cash on Delivery");
		}else {
			logger.error("cash on delivery method failed");
			Assert.assertTrue(false);
		} 
	}

	@Then("User click payment method continue button")
	public void user_click_payment_method_continue_button() {
		button(page.getCheckoutPage().getPayment_method_continue());
		logger.info("Payment method completed");
	}

	@Then("User verify payment information for cash on delivery")
	public void user_verify_payment_information_for_cash_on_delivery() {
		if(page.getCheckoutPage().getPayment_confirmation_head().isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Getting payment information details");
			List<WebElement> rows = page.getCheckoutPage().getPayment_cash_info().findElements(By.tagName("tr"));
			for (WebElement row : rows) {
				List<WebElement> cols = row.findElements(By.xpath("./td/p"));
				for (WebElement col : cols) {
					System.out.println(col+" ");
					Assert.assertEquals("You will pay by COD",col.getText().trim());
				}
				System.out.println("\n");
				logger.info("Cash payment information successfully");
				captureScreenshot(driver,"Payment Information");
			}
		}else {
			logger.error("Cash payment information failed");
			Assert.assertTrue(false);
		} 
	}

	@Then("User click payment information continue button")
	public void user_click_payment_information_continue_button() {
		button(page.getCheckoutPage().getPayment_information_continue());
		logger.info("Payment information completed");
	}

	@Then("User verify the billing and shipping address from confirm order")
	public void user_verify_the_billing_and_shipping_address_from_confirm_order() {
		if(page.getCheckoutPage().getConfirm_order_head().isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Verfying billing and shipping address");
			List<WebElement> billing = page.getCheckoutPage().getConfirm_billing_address().findElements(By.xpath("//ul[1]//li"));
			for (WebElement web : billing) {
				logger.debug("Billing address " + web.getText().trim());
			}
			System.out.println("\n");
			logger.info("Billing address captured");
			List<WebElement> shipping = page.getCheckoutPage().getConfirm_shipping_address().findElements(By.xpath("//ul[2]//li"));
			for (WebElement shi : shipping) {
				logger.debug("Shipping address " + shi.getText().trim());
			}
			System.out.println("\n");
			logger.info("Shipping address captured");
			captureScreenshot(driver,"Billing and Shipping Address");
		}else {
			logger.error("Shipping address failed");
			Assert.assertTrue(false);
		}
	}

	@Then("User verify product total and total price")
	public void user_verify_product_total_and_total_price() {
		List<WebElement> table_rows = page.getCartPage().getProduct_total().findElements(By.tagName("tr"));
		Map<String,String> totalsmap = new HashMap<>();

		for (WebElement row : table_rows) {
			List<WebElement> left = row.findElements(By.className("cart-total-left"));
			List<WebElement> right = row.findElements(By.className("cart-total-right"));
			if (!left.isEmpty() && !right.isEmpty()) {
				String key = left.get(0).getText().trim().replace(":", "");
				String value = right.get(0).getText().trim();
				totalsmap.put(key, value);
				System.out.println("key = " + key + " : " + "value = " + value);
			}
		}
		String actualSubtotal = totalsmap.get("Sub-Total");
		String expectedSubtotal = "200.00";
		String actualShipping = totalsmap.get("Shipping");
		String expectedShipping = "0.00";
		String actualPayment = totalsmap.get("Payment method additional fee");
		String expectedPayment = "7.00";
		double payment = Double.parseDouble(expectedPayment);
		String actualTax = totalsmap.get("Tax");
		String expectedTax= "0.00"; 
		String actualTotal = totalsmap.get("Total");
		double actto = Double.parseDouble(actualTotal);
		String expectedTot = "200.00"; 
		double total = Double.parseDouble(expectedTot);
		double expectTotal = total + payment;
		String expectedTotal = String.valueOf(expectTotal);
		Assert.assertEquals(expectedSubtotal,actualSubtotal);
//		Assert.assertEquals(expectedShipping,actualShipping);
		Assert.assertEquals(expectedPayment,actualPayment);
		Assert.assertEquals(expectTotal, actto, 0.001);
		logger.info("Verified the product total and total price");
		captureScreenshot(driver,"Product Total Price");
	}

	@Then("User click confirm order continue button")
	public void user_click_confirm_order_continue_button() {
		button(page.getCheckoutPage().getConfirm_order_continue());
		logger.info("Confirm order completed");
	}

	@Then("User should verify the order success message")
	public void user_should_verify_the_order_success_message() {
		if(page.getCheckoutPage().getOrdered_successmsg().isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Ordered success");
			captureScreenshot(driver,"Order Success");
		}else {
			logger.error("Ordered failed");
			Assert.assertTrue(false);
		}
	}

	@Then("User click order success continue button")
	public void user_click_order_success_continue_button() {
		button(page.getCheckoutPage().getOrdered_continue_button());
		logger.info("User clicked continue button after ordered");
	}

}
