package base;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

	ReadConfig r = new ReadConfig();
	public String url = r.getApplicationUrl();
	public String browser = r.getBrowser();
	
	public  static WebDriver driver;
	public static Logger logger = null;

	public void launchBrowser() {
		logger = LogManager.getLogger(BaseClass.class);
		if(driver == null) {
			logger.info("Browser going to start");
			switch(browser) {
			case  "chrome" : WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser started successfully");
			break;
			case "edge" : WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser started successfully");
			break;
			case "internetexplorer" : WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			logger.info("IE browser started successfully");
			break;
			default :WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser started successfully");
			break;
			}
		}
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
		logger.info("Browser maximized");
	}

	public void loadUrl() {
		driver.get(url);
		logger.info("URL hit successfully");
	}

	public void type(WebElement e,String value) {
		e.sendKeys(value);
	}

	public void button(WebElement e) {
		e.click();
	}

	public void quitBrowser() {
		driver.quit();
		logger.info("Browser quit successfully");
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getUrl() {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}

	public void mouse_action(WebElement e) {
		if(driver != null) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		}
	}

	public void captureScreenshot(WebDriver d,String name) {
		TakesScreenshot ts = (TakesScreenshot) d;
		File s = ts.getScreenshotAs(OutputType.FILE);
		File t = new File("./sceenshots/"+name+".png");
		try {
			FileUtils.copyFile(s, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
