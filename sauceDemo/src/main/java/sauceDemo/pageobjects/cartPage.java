package sauceDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class cartPage{
	
	
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		
		//Driver initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className ="inventory_list")
	List<WebElement> products;
	
	@FindBy(xpath = "//div[@class='cart_item']//div[@class='inventory_item_name']")
	WebElement itemInCart;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	
	public String getItemNameInCart() {
		return itemInCart.getText();
	}
	
	public void goToCheckoutPage(){
		checkoutButton.click();
	}

}
