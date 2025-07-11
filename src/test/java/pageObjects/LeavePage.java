package pageObjects;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage{

	public LeavePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//h6[text()= 'Leave']")
	@CacheLookup
	public WebElement leavePageHeader;
	
	@FindBy(xpath= "//li//a[text()= 'Apply']")
	@CacheLookup
	public WebElement applySection;
	
	@FindBy(xpath= "//p[text()= 'No Leave Types with Leave Balance']")
	@CacheLookup
	public WebElement noLeaveTypeMessage;
	
	@FindBy(xpath= "//div//div[text()= '-- Select --']")
	@CacheLookup
	public WebElement leaveTypeDropdown;
	
	@FindBy(xpath= "//div[@class= 'oxd-select-option']//span")
	@CacheLookup
	public WebElement secondLeaveTypeOption;
	
	@FindBy(xpath= "(//input[@placeholder= 'yyyy-dd-mm'])[1]")
	@CacheLookup
	public WebElement fromDateField;
	
	@FindBy(xpath= "//div[contains(@class, 'date') and normalize-space()= '2']")
	@CacheLookup
	public WebElement fromDate;
	
	@FindBy(xpath= "(//input[@placeholder= 'yyyy-dd-mm'])[2]")
	@CacheLookup
	public WebElement toDateField;
	
	@FindBy(xpath= "//div[contains(@class, 'date') and normalize-space()= '5']")
	@CacheLookup
	public WebElement toDate;
	
	@FindBy(xpath= "//button[normalize-space()= 'Apply']")
	@CacheLookup
	public WebElement applyButton;
	
	public void openApplySection() {
		applySection.click();
	}
	
	public void selectLeaveType() {

			// since it gives stale element exception sometimes:
			WebElement leaveTypeDrodown1= driver.findElement(By.xpath("//div//div[text()= '-- Select --']"));	
			
			waitForElement(leaveTypeDrodown1, 30);
			leaveTypeDrodown1.click();
			secondLeaveTypeOption.click();
		
		}
	
	public void selectFromDate() {
		fromDateField.click();
		fromDate.click();
	}
	
	public void selectToDate() {
		toDateField.click();
		toDate.click();
	}
	
	public void clickOnApply() {
		applyButton.click();
	}
	
}
