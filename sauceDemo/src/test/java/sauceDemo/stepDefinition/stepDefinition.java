package sauceDemo.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import sauceDemo.pageobjects.loginPage;
import sauceDemo.pageobjects.productsPage;
import sauceDemo.testcomponents.BaseTest;
import sauceDemo.pageobjects.cartPage;
import sauceDemo.pageobjects.checkoutPage;


public class stepDefinition extends BaseTest {
	WebDriver driver;
	
	loginPage loginPage;
	productsPage productsPage;
	cartPage cartPage;
	checkoutPage checkoutPage;
	
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		driver = initializeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@When("^user enters the valid (.+) and (.+) and clicks login button$")
	public void user_enters_the_valid_username_and_password(String username, String password) {
		loginPage = new loginPage(driver);
		loginPage.loginApplication(username, password);
	}

	@Then("^the user should be logged in successfully on (.+)$")
	public void the_user_should_be_logged_in_successfully_on(String appName) {
		Assert.assertEquals(loginPage.getAppLogoText(), appName);   
	}
	

	@Given("^user adds a (.+) into cart$")
	public void user_adds_a_product_into_cart(String prodName) {
		productsPage = new productsPage(driver);
		productsPage.addProductToCart(prodName);
	    productsPage.goToCartPage();
	}

	@When("user checkouts from cart")
	public void user_checkouts_from_cart() {
	   cartPage = new cartPage(driver);
		cartPage.goToCheckoutPage();
	}

	@And("^user submits the cart by inputting (.+) , (.+) and (.+) in checkout form$")
	public void user_submits_the_cart(String fname, String lname, String pcode) throws InterruptedException {
		checkoutPage = new checkoutPage(driver);
		checkoutPage.fillFormDetailsOnCheckout(fname, lname, pcode);
		checkoutPage.goToCheckoutOverview();
		checkoutPage.processOrder();
	}

	@Then("^(.+) message is displayed on Confirmation page$")
	public void success_msg_message_is_displayed_on_confirmation_page(String successMsg) throws InterruptedException {
		Assert.assertEquals(checkoutPage.getSuccessMsg(), successMsg);
	}
	
	
}
