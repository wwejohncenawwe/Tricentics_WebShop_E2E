package stepdefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;
import utilities.ReadExcel;

public class End_to_End_TC extends BaseClass{

	PageObjectManager page = new PageObjectManager();

	ReadExcel ex = new ReadExcel();
	String path = "C:\\Users\\Mani\\IDE Workspace\\Webshop\\src\\test\\resources\\excel\\data.xls";
	String fname,lname,email,company,country,state,city,address1,address2,zip,phone,fax; 

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
	}

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
		}else {
			logger.error("Login failed " + string2 + " not displayed");
			Assert.assertTrue(false);
		}
	}

	@Given("User click cell phones form electronics link")
	public void user_click_cell_phones_form_electronics_link() {
		logger.info("Selecting cellphones from electronics link");
		mouse_action(page.getHomePage().getElectronics());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(page.getCartPage().getCell_phones()));
		mouse_action(page.getCartPage().getCell_phones());
		button(page.getCartPage().getCell_phones());
	}

	@Then("User navigate to demowebshop cell phones page")
	public void user_navigate_to_demowebshop_cell_phones_page(DataTable datatable) {
		List<String> s = datatable.asList(String.class);
		String status = s.get(0);
		if(page.getCartPage().getCell_phones_head().isDisplayed()) {
			String cell_phones = page.getCartPage().getCell_phones_head().getText();
			Assert.assertEquals(status,cell_phones);
			logger.info("Navigated to cellphone page");
		}else {
			logger.error("Cellphone page failed " + status + " not displayed");
			Assert.assertTrue(false);
		}
	}

	@When("User click add to cart button")
	public void user_click_add_to_cart_button() {
		if(page.getCartPage().getAddcart_btn().isDisplayed()) {
			button(page.getCartPage().getAddcart_btn());
			logger.info("Addtocart button clicked");
		}else {
			logger.error("Addtocart failed not displayed");
			Assert.assertTrue(false);
		}
	}

	@Then("User should verify the popup message added for shopping cart")
	public void user_should_verify_the_popup_message_added_for_shopping_cart(DataTable datatable) {
		List<String> s = datatable.asList(String.class);
		String status = s.get(0);
		if(page.getCartPage().getAddedto_cart_popup().isDisplayed()) {
			String cart_popup = page.getCartPage().getAddedto_cart_popup().getText();
			Assert.assertEquals(status,cart_popup);
			logger.info("Shoppingcart popup message validated");
		}else {
			logger.error("Shoppingcart popup failed " + status + " not displayed");
			Assert.assertTrue(false);
		}
	}

	@When("User click on shopping cart link")
	public void user_click_on_shopping_cart_link() {
		button(page.getHomePage().getShoppingcart_link());
		logger.info("Shoppingcart link clicked");
	}

	@Then("User should verify the product name,quantity and total")
	public void user_should_verify_the_product_name_quantity_and_total() {
		List<Map<String, String>> tableData = new ArrayList<>();
		List<String> headerNames = new ArrayList<>();
		Map<String, String> rowData = new HashMap<>();

		List<WebElement> headers = page.getCartPage().getProduct_table().findElements(By.tagName("th"));
		for(WebElement header : headers) {
			headerNames.add(header.getText().trim());
		}
		List<WebElement> rows = page.getCartPage().getProduct_table().findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			for(int j = 0; j < cells.size(); j++) {
				WebElement cell = cells.get(j);

				String cellValue;

				if (!cell.findElements(By.tagName("input")).isEmpty()) {  //(headValue.equalsIgnoreCase("Qty"))
					cellValue = cell.findElement(By.tagName("input")).getAttribute("value");
				}

				else if (!cell.findElements(By.tagName("a")).isEmpty()) { //(header.contains("Product"))
					cellValue = cell.findElement(By.tagName("a")).getText().trim();
				}
				else {
					cellValue = cell.getText().trim();
				}
				rowData.put(headerNames.get(j), cellValue);
			}
			tableData.add(rowData);
		}
		logger.info("Verified product details " + tableData);
		if(tableData != null) {
			for (Map<String, String> row : tableData) {
				String productName = row.get("Product(s)");
				double price = Double.parseDouble(row.get("Price").replaceAll("[^0-9.]", ""));
				int qty = Integer.parseInt(row.get("Qty."));
				double actualTotal = Double.parseDouble(row.get("Total").replaceAll("[^0-9.]", ""));
				double expectedTotal = price * qty;
				System.out.println("Expected = " + expectedTotal);
				System.out.println("Actual = " + actualTotal);
				Assert.assertEquals(actualTotal, expectedTotal, 0.01);
			}
			logger.info("Product table total actual vs expected matched");
		}
	}

	@Then("User modifying quantity and click update shopping cart")
	public void User_modifying_quantity_and_click_update_shopping_cart() {
		WebElement row = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr"));
		WebElement priceElement = row.findElement(By.xpath("./td[4]"));
		String priceText = priceElement.getText().trim(); //replaceAll("[^0-9.]", "")
		double price = Double.parseDouble(priceText);
		WebElement qty = row.findElement(By.xpath("./td[5]//input"));
		qty.clear();
		type(qty,"2");
		button(page.getCartPage().getUpdate_shopping_cart());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(row));
		WebElement updatedrow = driver.findElement(By.xpath("//table[@class='cart']//tbody/tr"));
		int quantity = Integer.parseInt(updatedrow.findElement(By.xpath("./td[5]//input")).getAttribute("value"));
		WebElement totalElement = updatedrow.findElement(By.xpath("./td[6]"));
		String totalText = totalElement.getText().trim();//replaceAll("[^0-9.]", "");
		double total = Double.parseDouble(totalText);
		double expectedTotal = price * quantity;
		if(expectedTotal == total){
			assertTrue(true);
			logger.info("Expected total " + expectedTotal + " fulfilled");
		}else {
			logger.error("Expected total failed");
			assertTrue(false);
		}
	}

	@Then("User select country,state and zipcode")
	public void user_select_country_state_and_zipcode(DataTable datatable) {
		logger.debug("Selecting country,state,zipcode");
		List <Map<String,String>> s = datatable.asMaps(String.class,String.class);
		String country = s.get(0).get("country");
		String state = s.get(0).get("state");
		String zipcode = s.get(0).get("zipcode");
		Select s1 = new Select(page.getCartPage().getCountry());
		s1.selectByVisibleText(country);
		Select s2 = new Select(page.getCartPage().getState());
		s2.selectByVisibleText(state);
		type(page.getCartPage().getZipcode(),zipcode);
	}

	@Then("User click estimate shipping")
	public void user_click_estimate_shipping() {
		button(page.getCartPage().getEstimate_shipping());
		logger.info("Estimate shipping button clicked");
	}

	@Then("User should verify the product total price")
	public void user_should_verify_the_product_total_price() {
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
		String actualTotal = totalsmap.get("Total");
		String expectedTotal = "200.00"; 
		String actualSubtotal = totalsmap.get("Sub-Total");
		String expectedSubtotal = "200.00";
		String actualShipping = totalsmap.get("Shipping");
		String expectedShipping = "0.00";
		Assert.assertEquals(expectedSubtotal,actualSubtotal);
		Assert.assertEquals(expectedShipping,actualShipping);
		Assert.assertEquals(expectedTotal,actualTotal);
		logger.info("Verified the product total price");
	}

	@Then("User accept terms of service")
	public void user_accept_terms_of_service() {
		button(page.getCartPage().getTerms());
		logger.info("Terms services clicked");
	}

	@Then("User click checkout button")
	public void user_click_checkout_button() {
		button(page.getCartPage().getCheckout());
		logger.info("Checkout button clicked");
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
