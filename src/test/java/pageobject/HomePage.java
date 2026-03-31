package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='header-logo']/a/img")
	private WebElement homepage_logo;

	@FindBy(xpath="//div[@class='header-links']/ul/li/a[text()='Register']")
	private WebElement register_link;

	@FindBy(xpath="//div[@class='header-links']/ul/li/a[text()='Log in']")
	private WebElement login_link;

	@FindBy(xpath="//div[@class='header-links']/ul/li/a/span[text()='Shopping cart']")
	private WebElement shoppingcart_link;

	@FindBy(xpath="//div[@class='header-links']/ul/li/a/span[text()='Wishlist']")
	private WebElement wishtist_link;

	@FindBy(xpath="//div[@class='header-links']/ul/li[2]/a[text()='Log out']")
	private WebElement logout;
	
	@FindBy(id="small-searchterms")
	private WebElement search_txt;

	@FindBy(xpath="//div[@class='search-box']//following::input[@type='submit']")
	private WebElement search_btn;

	@FindBy(xpath="//div[@class='header-menu']/ul[1]/li/a[contains(text(),'Books')]")
	private WebElement books;

	@FindBy(xpath="//div[@class='header-menu']/ul[1]/li/a[contains(text(),'Computers')]")
	private WebElement computers;

	@FindBy(xpath="//div[@class='header-menu']/ul[@class='top-menu']/li[3]/a[contains(text(),'Electronics')]")
	private WebElement electronics;

	@FindBy(xpath="//div[@class='header-menu']/ul[1]/li/a[contains(text(),'Apparel & Shoes')]")
	private WebElement apparel_shoes;

	@FindBy(xpath="//div[@class='header-menu']/ul[1]/li/a[contains(text(),'Digital downloads')]")
	private WebElement digital_downloads;

	@FindBy(xpath="//div[@class='header-menu']/ul[1]/li/a[contains(text(),'Jewelry')]")
	private WebElement jewelry;

	@FindBy(xpath="//div[@class='header-menu']/ul[1]/li/a[contains(text(),'Gift Cards')]")
	private WebElement gift_cards;

	public WebElement getHomepage_logo() {
		return homepage_logo;
	}

	public WebElement getRegister_link() {
		return register_link;
	}

	public WebElement getLogin_link() {
		return login_link;
	}

	public WebElement getShoppingcart_link() {
		return shoppingcart_link;
	}

	public WebElement getWishtist_link() {
		return wishtist_link;
	}

	public WebElement getSearch_txt() {
		return search_txt;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	public WebElement getBooks() {
		return books;
	}

	public WebElement getComputers() {
		return computers;
	}

	public WebElement getElectronics() {
		return electronics;
	}

	public WebElement getApparel_shoes() {
		return apparel_shoes;
	}

	public WebElement getDigital_downloads() {
		return digital_downloads;
	}

	public WebElement getJewelry() {
		return jewelry;
	}

	public WebElement getGift_cards() {
		return gift_cards;
	}


}
