package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "input-email")
	@CacheLookup
	public WebElement emailInput;
	
	@FindBy(id= "input-password")
	@CacheLookup
	public WebElement passwordInput;
	
	@FindBy(xpath= "//input[@value= 'Login']")
	@CacheLookup
	public WebElement loginButton;
	
	public void enterUsername(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void login() {
		loginButton.click();
	}
	
}
