package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class RegisterPage extends BaseClass{

	public RegisterPage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='page registration-page']/div[@class='page-title']/h1")
	private WebElement registerpage_header;

	@FindBy(id="gender-male")
	private WebElement male_gender;

	@FindBy(id="FirstName")
	private WebElement firstname;

	@FindBy(id="LastName")
	private WebElement lastname;

	@FindBy(id="Email")
	private WebElement register_emilid;

	@FindBy(id="Password")
	private WebElement register_password;

	@FindBy(id="ConfirmPassword")
	private WebElement confirm_password;

	@FindBy(id="register-button")
	private WebElement register_btn;

	@FindBy(xpath="//div[@class='page-body']/div[contains(text(),'Your registration completed')]")
	private WebElement register_successmsg;

	@FindBy(xpath="//div[@class='page-body']/div[@class='buttons']/input")
	private WebElement register_continuebtn;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='Email:']/following::span[text()='Wrong email']")
	private WebElement wrong_email;

	@FindBy(xpath="//div[@class='message-error']/div/ul/li[text()='The specified email already exists']")
	private WebElement exists_email;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='Email:']/following::span[text()='Email is required.']")
	private WebElement without_email;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='Password:']/following::span[text()='Password is required.'][1]")
	private WebElement without_pword;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='Password:']/following::span[text()='The password should have at least 6 characters.']")
	private WebElement wrong_pword_length;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='Confirm password:']/following::span[text()='The password and confirmation password do not match.']")
	private WebElement notmatch_pword_cpword;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='First name:']/following::span[text()='First name is required.']")
	private WebElement without_fname;

	@FindBy(xpath="//div[@class='form-fields']/div/label[text()='Last name:']/following::span[text()='Last name is required.']")
	private WebElement without_lname;


	public WebElement getRegisterpage_header() {
		return registerpage_header;
	}

	public WebElement getMale_gender() {
		return male_gender;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getRegister_emilid() {
		return register_emilid;
	}

	public WebElement getRegister_password() {
		return register_password;
	}

	public WebElement getConfirm_password() {
		return confirm_password;
	}

	public WebElement getRegister_btn() {
		return register_btn;
	}

	public WebElement getRegister_successmsg() {
		return register_successmsg;
	}

	public WebElement getRegister_continuebtn() {
		return register_continuebtn;
	}

	public WebElement getWrong_email() {
		return wrong_email;
	}

	public WebElement getExists_email() {
		return exists_email;
	}

	public WebElement getWithout_email() {
		return without_email;
	}

	public WebElement getWithout_pword() {
		return without_pword;
	}

	public WebElement getWrong_pword_length() {
		return wrong_pword_length;
	}

	public WebElement getNotmatch_pword_cpword() {
		return notmatch_pword_cpword;
	}

	public WebElement getWithout_fname() {
		return without_fname;
	}

	public WebElement getWithout_lname() {
		return without_lname;
	}


}
