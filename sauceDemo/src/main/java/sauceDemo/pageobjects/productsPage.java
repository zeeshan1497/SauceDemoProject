package sauceDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class productsPage{
	
	
	WebDriver driver;
	
	public productsPage(WebDriver driver) {
		
		//Driver initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className ="inventory_list")
	List<WebElement> products;

	By addToCart = By.xpath("//button[starts-with(text(),'Add to cart')]");
	
	@FindBy(className="shopping_cart_link")
	WebElement cartLink;
	
	public List<WebElement> getProductList() {
		return products;
	}
	
	public WebElement getProductByName(String prodName) {
		WebElement desiredProd = null;
		for(WebElement prod : getProductList()) {
			if(prod.findElement(By.className("inventory_item_name")).getText().equals(prodName)) {
				desiredProd=prod;
				break;
			}
		}
		return desiredProd;
	}
	
	public void addProductToCart(String prodName) {
		getProductByName(prodName).findElement(addToCart).click();
		
	}
	
	public void goToCartPage() {
		cartLink.click();
	}

}
