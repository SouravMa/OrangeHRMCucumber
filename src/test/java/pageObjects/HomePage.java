package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//li[contains(@class, 'userdropdown')]")
	@CacheLookup
	public WebElement userDropdown;
	
	@FindBy(xpath= "//a[text()= 'Logout']")
	@CacheLookup
	public WebElement logoutOption;
	
	public void openUserDropdown() {
		userDropdown.click();
	}
	
	public void logOut() {
		logoutOption.click();
	}
}
