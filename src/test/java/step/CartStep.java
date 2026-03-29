package step;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmanager.PageObjectManager;

public class CartStep extends BaseClass {

	PageObjectManager page = new PageObjectManager();
	
	@Given("Users click on login link")
	public void users_click_on_login_link() {
		button(page.getHomePage().getLogin_link());
		logger.info("Login link clicked");
	}

	@Then("Users navigate to demowebshop login page")
	public void users_navigate_to_demowebshop_login_page() {
		String login_head = page.getLoginPage().getLogin_header().getText();
		Assert.assertEquals("User navigated to login page","Welcome, Please Sign In!",login_head );
		logger.info("Navigated to login page");
	}

	@When("Users enters the valid  {string},{string}")
	public void users_enters_the_valid(String email, String pword) {
		logger.debug("Entering valid email and password");
		type(page.getLoginPage().getLogin_emilid(),email);
		type(page.getLoginPage().getLogin_password(),pword);
	}

	@When("Users click on login button")
	public void users_click_on_login_button() {
		button(page.getLoginPage().getLogin_btn());
		logger.info("Login button clicked");
	}

	@Then("Users should verify login status {string}")
	public void users_should_verify_login_status(String string2) {
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
			captureScreenshot(driver,"AddtoCart Popup");
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
			captureScreenshot(driver,"Product Table");
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
			captureScreenshot(driver,"Product Qty Modified");
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
	

}
