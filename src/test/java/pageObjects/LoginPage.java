package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//h5[text()= 'Login']")
	@CacheLookup
	public WebElement loginMessage;
	
	@FindBy(xpath= "//input[@name= 'username']")
	@CacheLookup
	public WebElement usernameInput;
	
	@FindBy(xpath= "//input[@name= 'password']")
	@CacheLookup
	public WebElement passwordInput;
	
	@FindBy(xpath= "//button[@type= 'submit']")
	@CacheLookup
	public WebElement loginButton;
	
	public void enterUsername(String userName) {
		usernameInput.clear();
		usernameInput.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void login() {
		loginButton.click();
	}

}
