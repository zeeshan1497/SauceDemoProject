package sauceDemo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sauceDemo.pageobjects.cartPage;
import sauceDemo.pageobjects.checkoutPage;
import sauceDemo.pageobjects.loginPage;
import sauceDemo.pageobjects.productsPage;
import sauceDemo.testcomponents.BaseTest;

public class CreateOrderTest extends BaseTest{
	
	WebDriver driver;
	String name="standard_user";
	String password="secret_sauce";
	String productName = "Sauce Labs Backpack";
	String fName = "Zeeshan";
	String lName = "Ismail";
	String pCode = "12345";
	String orderSuccessMsg = "Thank you for your order!";

	@BeforeTest
	public void launchApplication() {
		driver = initializeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void VerifyLogin() throws InterruptedException {
		loginPage loginPage = new loginPage(driver);
		loginPage.loginApplication(name, password);
		Thread.sleep(3);
		Assert.assertEquals(loginPage.getAppLogoText(),"Swag Labs");
	}
	
	@Test(dependsOnMethods= {"VerifyLogin"})
	public void VerifyAddingItemIntoCart() throws InterruptedException {
		productsPage productPage = new productsPage(driver);
		productPage.addProductToCart(productName);
		productPage.goToCartPage();
	}
	
	@Test(dependsOnMethods= {"VerifyAddingItemIntoCart"})
	public void VerifyCheckoutFromCart() throws InterruptedException {
		cartPage cartPage = new cartPage(driver);
		Thread.sleep(3);
		Assert.assertEquals(cartPage.getItemNameInCart(), productName);
		cartPage.goToCheckoutPage();
	}
	
	@Test(dependsOnMethods= {"VerifyCheckoutFromCart"})
	public void VerifyOrderConfirmation() throws InterruptedException {
		checkoutPage checkoutPage = new checkoutPage(driver);
		checkoutPage.fillFormDetailsOnCheckout(fName, lName, pCode);
		checkoutPage.goToCheckoutOverview();
		checkoutPage.processOrder();
		Thread.sleep(3);
		Assert.assertEquals(checkoutPage.getSuccessMsg(), orderSuccessMsg);
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
	
	
}
