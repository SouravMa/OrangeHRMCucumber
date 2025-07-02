package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver hdriver;
	
	public HomePage(WebDriver driver) {
		hdriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[text()= 'Logout' and @class= 'list-group-item']")
	@CacheLookup
	public WebElement logoutLink;
	
	public void logout() {
		logoutLink.click();
	}

}
