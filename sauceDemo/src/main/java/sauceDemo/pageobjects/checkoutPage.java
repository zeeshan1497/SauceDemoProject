package sauceDemo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class checkoutPage{
	
	
	WebDriver driver;
	
	public checkoutPage(WebDriver driver) {
		
		//Driver initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="first-name")
	WebElement firstName;
	
	@FindBy(id ="last-name")
	WebElement lastName;
	
	@FindBy(id ="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueToProcessOrder;
	
	@FindBy(id="finish")
	WebElement finishOrder;
	
	@FindBy(className = "complete-header")
	WebElement successMsg;
	
	
	public void fillFormDetailsOnCheckout(String fName, String lName, String pCode) throws InterruptedException {
		Thread.sleep(3);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
	}
	
	public void goToCheckoutOverview(){
		continueToProcessOrder.click();	
		}
	
	public void processOrder() {
		finishOrder.click();
	}
	
	public String getSuccessMsg() throws InterruptedException {
		Thread.sleep(2);
		return successMsg.getText();
	}

}
