package sauceDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage{
	
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		
		//Driver initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(className="app_logo")
	WebElement appLogo;
	
	public void loginApplication(String userName, String pass) {
		username.sendKeys(userName);
		password.sendKeys(pass);
		loginBtn.click();
		
	}
	
	public String getAppLogoText() {
		return appLogo.getText();
	}

}
