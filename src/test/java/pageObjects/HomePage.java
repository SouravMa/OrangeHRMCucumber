package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//li[contains(@class, 'userdropdown')]")
	@CacheLookup
	public WebElement userDropdown;
	
	@FindBy(xpath= "//a[text()= 'Logout']")
	@CacheLookup
	public WebElement logoutOption;
	
	@FindBy(xpath= "//input[@placeholder= 'Search']")
	@CacheLookup
	public WebElement searchInput;
	
	@FindBy(xpath= "//a[contains(@href, 'RecruitmentModule')]")
	@CacheLookup
	public WebElement recruitmentModule;
	
	@FindBy(xpath= "//a[contains(@href, 'Pim')]")
	@CacheLookup
	public WebElement pimModule;
	
	@FindBy(xpath= "//a[contains(@href, 'Admin')]")
	@CacheLookup
	public WebElement adminModule;
	
	@FindBy(xpath= "//a[contains(@href, 'Leave')]")
	@CacheLookup
	public WebElement leaveModule;
	
	public void clickOnSearch() {
		searchInput.click();
	}
	
	public void enterSearchInput(String searchEntry) {
		searchInput.clear();
		searchInput.sendKeys(searchEntry);
	}
	
	public void clickOnSearchResult() {
		recruitmentModule.click();
	}
	
	public void openUserDropdown() {
		userDropdown.click();
	}
	
	public void logOut() {
		logoutOption.click();
	}
	
	public void openPIMModule() {
		pimModule.click();
	}
	
	public void openAdminModule() {
		adminModule.click();
	}
	
	public void openLeaveModule() {
		leaveModule.click();
	}
	
	public void openRecruitmentModule() {
		recruitmentModule.click();
	}
	
}
