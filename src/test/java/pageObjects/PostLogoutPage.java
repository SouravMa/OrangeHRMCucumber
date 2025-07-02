package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostLogoutPage {
	
	public WebDriver driver;
	
	public PostLogoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//h1[text()= 'Account Logout']")
	public WebElement logoutHeader;

}
