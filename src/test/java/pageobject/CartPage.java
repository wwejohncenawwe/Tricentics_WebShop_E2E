package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class CartPage extends BaseClass {

	public CartPage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='header-menu']/ul[@class='top-menu']/li/ul/li/a[contains(text(),'Cell phones')]")
	private WebElement cell_phones;

	@FindBy(xpath="//div[@class='page-title']/h1[text()='Cell phones']")
	private WebElement cell_phones_head;

	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
	private WebElement addcart_btn;

	@FindBy(xpath="//div[@id='bar-notification']/p[text()='The product has been added to your ']")
	private WebElement addedto_cart_popup;

	@FindBy(xpath="//table[@class='cart']")
	private WebElement product_table;
	
	@FindBy(xpath="//div[@class='common-buttons']//input[1]")
	private WebElement update_shopping_cart;
	
	@FindBy(xpath="//div[@class='common-buttons']//input[2]")
	private WebElement continue_shopping_cart;

	@FindBy(xpath="//div[@class='shipping-options']/div[1]/select[@id='CountryId']")
	private WebElement country;

	@FindBy(xpath="//div[@class='shipping-options']/div[2]/select[@id='StateProvinceId']")
	private WebElement state;

	@FindBy(xpath="//div[@class='shipping-options']/div[3]/input[@id='ZipPostalCode']")
	private WebElement zipcode;

	@FindBy(xpath="//div[@class='shipping-options']/div[4]/input[@type='submit']")
	private WebElement estimate_shipping;

	@FindBy(xpath="//table[@class='cart-total']")
	private WebElement product_total;

	@FindBy(xpath="//div[@class='terms-of-service']/input[@id='termsofservice']")
	private WebElement terms;

	@FindBy(xpath="//div[@class='checkout-buttons']/button[@type='submit']")
	private WebElement checkout;

	public WebElement getCell_phones() {
		return cell_phones;
	}

	public WebElement getProduct_table() {
		return product_table;
	}
	
	public WebElement getUpdate_shopping_cart() {
		return update_shopping_cart;
	}

	public WebElement getContinue_shopping_cart() {
		return continue_shopping_cart;
	}

	
	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getEstimate_shipping() {
		return estimate_shipping;
	}

	public WebElement getProduct_total() {
		return product_total;
	}

	public WebElement getTerms() {
		return terms;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getCell_phones_head() {
		return cell_phones_head;
	}

	public WebElement getAddcart_btn() {
		return addcart_btn;
	}

	public WebElement getAddedto_cart_popup() {
		return addedto_cart_popup;
	}



}
