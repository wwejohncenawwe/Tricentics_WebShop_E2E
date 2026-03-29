package pageobjectmanager;

import pageobject.CartPage;
import pageobject.CheckoutPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;

public class PageObjectManager {

	HomePage homepage;
	RegisterPage registerpage;
	LoginPage loginpage;
	CartPage cartpage;
	CheckoutPage checkoutpage;

	public HomePage getHomePage() {
		return (homepage == null) ? homepage = new HomePage() : homepage;
	}

	public RegisterPage getRegisterPage() {
		return (registerpage == null) ? registerpage = new RegisterPage() : registerpage;
	}

	public LoginPage getLoginPage() {
		return (loginpage == null) ? loginpage = new LoginPage() : loginpage;
	}

	public CartPage getCartPage() {
		return (cartpage == null) ? cartpage = new CartPage() : cartpage;
	}
	
	public CheckoutPage getCheckoutPage() {
		return (checkoutpage == null) ? checkoutpage = new CheckoutPage() : checkoutpage;
	}


}
