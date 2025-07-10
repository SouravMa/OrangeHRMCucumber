package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage{

	public RecruitmentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//h6[text()= 'Recruitment']")
	@CacheLookup
	public WebElement recuitmentPageHeader;
	
	@FindBy(xpath= "//input[@name= 'firstName']")
	@CacheLookup
	public WebElement firstNameField;
	
	@FindBy(xpath= "//input[@name= 'middleName']")
	@CacheLookup
	public WebElement middleNameField;
	
	@FindBy(xpath= "//input[@name= 'lastName']")
	@CacheLookup
	public WebElement lastNameField;
	
	@FindBy(xpath= "(//input[@placeholder= 'Type here'])[1]")
	@CacheLookup
	public WebElement emailFiled;
	
	@FindBy(xpath= "//button[@type= 'submit' and normalize-space()= 'Save']")
	@CacheLookup
	public WebElement saveButton;
	
	public void enterFullName(String firstName, String middleName, String lastName) {
		
		waitForElement(firstNameField, 30);
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		
		middleNameField.clear();
		middleNameField.sendKeys(middleName);
		
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

	}
	
	public void clickOnAdd() {
		waitForElement(addButton, 30);
		addButton.click();
	}
	
	public void enterEmail(String email) {
		emailFiled.clear();
		emailFiled.sendKeys(email);
	}
	
	public void clickOnSave() {
		saveButton.click();
	}
	
}
