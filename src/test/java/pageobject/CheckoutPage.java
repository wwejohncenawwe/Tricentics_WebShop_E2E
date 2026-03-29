package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class CheckoutPage extends BaseClass {
	
	public CheckoutPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='page-title']/h1")
	private WebElement checkout_head; 
	
	@FindBy(xpath="//ol[@id='checkout-steps']/li/div/h2[text()='Billing address']")
	private WebElement billing_address_head;
	
	@FindBy(xpath="//div[@class='edit-address']//div[1]/input")
	private WebElement first_name;
	
	@FindBy(xpath="//div[@class='edit-address']//div[2]/input")
	private WebElement last_name;
	
	@FindBy(xpath="//div[@class='edit-address']//div[3]/input")
	private WebElement email_id;
	
	@FindBy(xpath="//div[@class='edit-address']//div[4]/input")
	private WebElement company_name;
	
	@FindBy(xpath="//div[@class='edit-address']//div[5]/select")
	private WebElement country;
	
	@FindBy(xpath="//div[@class='edit-address']//div[6]/select")
	private WebElement state;
	
	@FindBy(xpath="//div[@class='edit-address']//div[7]/input")
	private WebElement city;
	
	@FindBy(xpath="//div[@class='edit-address']//div[8]/input")
	private WebElement address_1;
	
	@FindBy(xpath="//div[@class='edit-address']//div[9]/input")
	private WebElement address_2;
	
	@FindBy(xpath="//div[@class='edit-address']//div[10]/input")
	private WebElement zip;
	
	@FindBy(xpath="//div[@class='edit-address']//div[11]/input")
	private WebElement phone_no;
	
	@FindBy(xpath="//div[@class='edit-address']//div[12]/input")
	private WebElement fax_no;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']/input")
	private WebElement billing_continue;
	
	@FindBy(xpath="//ol[@id='checkout-steps']/li/div/h2[text()='Shipping address']")
	private WebElement shipping_address_head;
	
	@FindBy(xpath="//div[@id='shipping-addresses-form']/div[1]/div/select")
	private WebElement shipping_address;
	
	@FindBy(xpath="//p[@class='selector']/input[1]")
	private WebElement store_pickup;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']/p[@class='back-link']/a")
	private WebElement shipping_address_back;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']/input")
	private WebElement shipping_address_continue;
	
	@FindBy(xpath="//ol[@id='checkout-steps']/li/div/h2[text()='Shipping method']")
	private WebElement shipping_method_head;
	
	@FindBy(xpath="//div[@class='section shipping-method']//ul[@class='method-list']/li[1]//input")
	private WebElement ground;
	
	@FindBy(xpath="//div[@class='section shipping-method']//ul[@class='method-list']/li[2]//input")
	private WebElement nextday_air;
	
	@FindBy(xpath="//div[@class='section shipping-method']//ul[@class='method-list']/li[3]//input")
	private WebElement secondnextday_air;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/p[@class='back-link']/a")
	private WebElement shipping_method_back;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/input")
	private WebElement shipping_method_continue;
	
	@FindBy(xpath="//ol[@id='checkout-steps']/li/div/h2[text()='Payment method']")
	private WebElement payment_method_head;
	
	@FindBy(xpath="//div[@class='section payment-method']/ul/li/div/div[2]/input[@id='paymentmethod_0']")
	private WebElement cashon_delivery;
	
	@FindBy(xpath="//div[@class='section payment-method']/ul/li/div/div[2]/input[@id='paymentmethod_2']")
	private WebElement check;
	
	@FindBy(xpath="//div[@class='section payment-method']/ul/li/div/div[2]/input[@id='paymentmethod_3']")
	private WebElement credit_card;
	
	@FindBy(xpath="//div[@class='section payment-method']/ul/li/div/div[2]/input[@id='paymentmethod_4']")
	private WebElement purchase_order;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']/p[@class='back-link']/a")
	private WebElement payment_method_back;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']/input")
	private WebElement payment_method_continue;
	
	@FindBy(xpath="//ol[@id='checkout-steps']/li/div/h2[text()='Payment information']")
	private WebElement payment_confirmation_head;

	@FindBy(xpath="//div[@class='section payment-info']//table/tbody")
	private WebElement payment_cash_info;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody")
	private WebElement payement_check_info;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr[1]/td[2]/select")
	private WebElement payment_credit_card;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr[2]/td/input")
	private WebElement payment_credit_name;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr[3]/td/input")
	private WebElement payment_credit_no;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr[4]/td/select[1]")
	private WebElement payment_credit_date;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr[4]/td/select[2]")
	private WebElement payment_credit_year;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr[5]/td/input")
	private WebElement payment_credit_code;
	
	@FindBy(xpath="//div[@class='section payment-info']//table/tbody/tr/td/input")
	private WebElement po_number;
	
	@FindBy(xpath="//div[@id='payment-info-buttons-container']/p[@class='back-link']/a")
	private WebElement payment_information_back;
	
	@FindBy(xpath="//div[@id='payment-info-buttons-container']/input")
	private WebElement payment_information_continue;
	
	
	@FindBy(xpath="//ol[@id='checkout-steps']/li/div/h2[text()='Confirm order']")
	private WebElement confirm_order_head;
	
	@FindBy(xpath="//div[@class='order-review-data']")
	private WebElement confirm_billing_address;
	
	@FindBy(xpath="//div[@class='order-review-data']")
	private WebElement confirm_shipping_address;
	
	@FindBy(xpath="//table[@class='cart']")
	private WebElement finalproduct_table;
	
	@FindBy(xpath="//table[@class='cart-total']")
	private WebElement finalproduct_total;
	
	@FindBy(xpath="//div[@id='confirm-order-buttons-container']/p[@class='back-link']/a")
	private WebElement confirm_order_back;
	
	@FindBy(xpath="//div[@id='confirm-order-buttons-container']/input")
	private WebElement confirm_order_continue;
	
	@FindBy(xpath="//div[@class='page-title']/h1")
	private WebElement ordered_head;  //Thank you
	
	@FindBy(xpath="//div[@class='section order-completed']/div[1]")
	private WebElement ordered_successmsg;   //Your order has been successfully processed!
	
	@FindBy(xpath="//div[@class='section order-completed']/ul/li[1]")
	private WebElement ordered_number;    //Order number: 2255235
    
	@FindBy(xpath="//div[@class='section order-completed']/ul/li[2]")
	private WebElement ordered_link_page;
	
	@FindBy(xpath="//div[@class='section order-completed']/div[2]")
	private WebElement ordered_continue_button;

	public WebElement getCheckout_head() {
		return checkout_head;
	}

	public WebElement getBilling_address_head() {
		return billing_address_head;
	}

	public WebElement getFirst_name() {
		return first_name;
	}

	public WebElement getLast_name() {
		return last_name;
	}

	public WebElement getEmail_id() {
		return email_id;
	}

	public WebElement getCompany_name() {
		return company_name;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress_1() {
		return address_1;
	}

	public WebElement getAddress_2() {
		return address_2;
	}

	public WebElement getZip() {
		return zip;
	}

	public WebElement getPhone_no() {
		return phone_no;
	}

	public WebElement getFax_no() {
		return fax_no;
	}

	public WebElement getBilling_continue() {
		return billing_continue;
	}

	public WebElement getShipping_address_head() {
		return shipping_address_head;
	}

	public WebElement getShipping_address() {
		return shipping_address;
	}

	public WebElement getStore_pickup() {
		return store_pickup;
	}

	public WebElement getShipping_address_back() {
		return shipping_address_back;
	}

	public WebElement getShipping_address_continue() {
		return shipping_address_continue;
	}

	public WebElement getShipping_method_head() {
		return shipping_method_head;
	}

	public WebElement getGround() {
		return ground;
	}

	public WebElement getNextday_air() {
		return nextday_air;
	}

	public WebElement getSecondnextday_air() {
		return secondnextday_air;
	}

	public WebElement getShipping_method_back() {
		return shipping_method_back;
	}

	public WebElement getShipping_method_continue() {
		return shipping_method_continue;
	}

	public WebElement getPayment_method_head() {
		return payment_method_head;
	}

	public WebElement getCashon_delivery() {
		return cashon_delivery;
	}

	public WebElement getCheck() {
		return check;
	}

	public WebElement getCredit_card() {
		return credit_card;
	}

	public WebElement getPurchase_order() {
		return purchase_order;
	}

	public WebElement getPayment_method_back() {
		return payment_method_back;
	}

	public WebElement getPayment_method_continue() {
		return payment_method_continue;
	}

	public WebElement getPayment_confirmation_head() {
		return payment_confirmation_head;
	}

	public WebElement getPayment_cash_info() {
		return payment_cash_info;
	}

	public WebElement getPayement_check_info() {
		return payement_check_info;
	}

	public WebElement getPayment_credit_card() {
		return payment_credit_card;
	}

	public WebElement getPayment_credit_name() {
		return payment_credit_name;
	}

	public WebElement getPayment_credit_no() {
		return payment_credit_no;
	}

	public WebElement getPayment_credit_date() {
		return payment_credit_date;
	}

	public WebElement getPayment_credit_year() {
		return payment_credit_year;
	}

	public WebElement getPayment_credit_code() {
		return payment_credit_code;
	}

	public WebElement getPo_number() {
		return po_number;
	}

	public WebElement getPayment_information_back() {
		return payment_information_back;
	}

	public WebElement getPayment_information_continue() {
		return payment_information_continue;
	}

	public WebElement getConfirm_order_head() {
		return confirm_order_head;
	}

	public WebElement getConfirm_billing_address() {
		return confirm_billing_address;
	}

	public WebElement getConfirm_shipping_address() {
		return confirm_shipping_address;
	}

	public WebElement getFinalproduct_table() {
		return finalproduct_table;
	}

	public WebElement getFinalproduct_total() {
		return finalproduct_total;
	}

	public WebElement getConfirm_order_back() {
		return confirm_order_back;
	}

	public WebElement getConfirm_order_continue() {
		return confirm_order_continue;
	}

	public WebElement getOrdered_head() {
		return ordered_head;
	}

	public WebElement getOrdered_successmsg() {
		return ordered_successmsg;
	}

	public WebElement getOrdered_number() {
		return ordered_number;
	}

	public WebElement getOrdered_link_page() {
		return ordered_link_page;
	}

	public WebElement getOrdered_continue_button() {
		return ordered_continue_button;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
