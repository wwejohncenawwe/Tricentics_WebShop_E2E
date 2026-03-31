package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
							glue = {"stepdefinition","hooks"}, dryRun = false, monochrome = true,
				 plugin = {"pretty",
						 	"html:target/cucumber-report.html",
					        "json:target/cucumber.json",
					        "junit:target/cucumber.xml",
						   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},tags= "@DemoWebShop_End_to_End_TestCase")
public class TestRunnerTest {


}










// "src/test/resources/features/HomePage.feature",
//"src/test/resources/features/RegisterPage.feature",
//"src/test/resources/features/LoginPage.feature",
//"src/test/resources/features/ShoppingCart.feature",
//"src/test/resources/features/CheckoutPage.feature"},

// tags = "@DemoWebShop_End_to_End_TestCase"
//		tags= "@homepage or @positive or @valid_login or @adding_cart or @orderby_cash"
// tags = "@homepage or @positive or @negative_invalid_email or @negative_exists_email or @negative_without_email"
//	+ "@negative_without_fname or @negative_without_lname or @negative_without_pword_cpword or @negative_without_pword"
//	+ "@negative_invalid_pword_length or @valid_login or @login_with_pword or @login_with_email or @invalid_pword_login"
//	+ "@invalid_email_login or @invalid_email_format or @adding_cart or @orderby_cash or @orderby_check or @orderby_creditcard or @orderby_purchaseorder"