package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='page login-page']/div/h1")
	private WebElement login_header;

	@FindBy(id="Email")
	private WebElement login_emilid;

	@FindBy(id="Password")
	private WebElement login_password;

	@FindBy(id="RememberMe")
	private WebElement remember_me;

	@FindBy(xpath="//div[@class='form-fields']/form/div[4]/span/a[contains(text(),'Forgot password?')]")
	private WebElement forgot_password;

	@FindBy(xpath="//div[@class='form-fields']/form/div[@class='buttons']/input")
	private WebElement login_btn;

	@FindBy(xpath="//div[@class='header-links']/ul/li/a[@class='account']")
	private WebElement login_account_email;

	@FindBy(xpath="//div[@class='form-fields']/form/div[@class='message-error']/div/span[text()='Login was unsuccessful. Please correct the errors and try again.']")
	private WebElement without_loginemail;

	@FindBy(xpath="//div[@class='form-fields']/form/div[@class='message-error']/div/span[text()='Login was unsuccessful. Please correct the errors and try again.']")
	private WebElement without_loginpword;

	@FindBy(xpath="//div[@class='form-fields']/form/div[@class='message-error']/div/ul/li[text()='No customer account found']")
	private WebElement invalid_emaillogin;

	@FindBy(xpath="//div[@class='form-fields']/form/div[@class='message-error']/div/ul/li[text()='The credentials provided are incorrect']")
	private WebElement invalid_pwordlogin;

	@FindBy(xpath="//div[@class='inputs']/span/span[text()='Please enter a valid email address.']")
	private WebElement invalid_email_length;

	public WebElement getLogin_header() {
		return login_header;
	}

	public WebElement getLogin_emilid() {
		return login_emilid;
	}

	public WebElement getLogin_password() {
		return login_password;
	}

	public WebElement getRemember_me() {
		return remember_me;
	}

	public WebElement getForgot_password() {
		return forgot_password;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

	public WebElement getLogin_account_email() {
		return login_account_email;
	}

	public WebElement getWithout_loginemail() {
		return without_loginemail;
	}

	public WebElement getWithout_loginpword() {
		return without_loginpword;
	}

	public WebElement getInvalid_emaillogin() {
		return invalid_emaillogin;
	}

	public WebElement getInvalid_pwordlogin() {
		return invalid_pwordlogin;
	}

	public WebElement getInvalid_email_length() {
		return invalid_email_length;
	}




}
