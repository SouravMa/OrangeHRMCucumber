package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage{

	public PIMPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//h6[text()= 'PIM']")
	@CacheLookup
	public WebElement pimPageHeader;
	
	@FindBy(xpath= "//button[normalize-space()='Add']")
	@CacheLookup
	public WebElement addEmployeeButton;
	
	@FindBy(xpath= "//input[@name= 'firstName']")
	@CacheLookup
	public WebElement firstNameInput;
	
	@FindBy(xpath= "//input[@name= 'middleName']")
	@CacheLookup
	public WebElement middleNameInput;
	
	@FindBy(xpath= "//input[@name= 'lastName']")
	@CacheLookup
	public WebElement lastNameInput;

	@FindBy(xpath= "//button[@type= 'submit' and normalize-space()= 'Save']")
	@CacheLookup
	public WebElement addEmployeeSaveButton;
	
	@FindBy(xpath= "//h6[contains(@class, 'strong')]")
	@CacheLookup
	public WebElement emmployeeNameHeader;
	
	@FindBy(xpath= "(//input[@placeholder= 'Type for hints...'])[1]")
	@CacheLookup
	public WebElement employeeNameInput;
	
	@FindBy(xpath= "//button[normalize-space()= 'Search']")
	@CacheLookup
	public WebElement employeeSearchButton;
	
	@FindBy(xpath= "(//div[@role= 'row'])[2]//div[3]")
	@CacheLookup
	public WebElement searchedEmployeeName;
	
	@FindBy(xpath= "(//div[@role= 'row'])[3]//div[3]//div")
	@CacheLookup
	public WebElement secondEmployeeForDeletion;
	
	@FindBy(xpath= "(//div[@role= 'row'])[3]//div[9]//button//i[contains(@class, 'trash')]")
	@CacheLookup
	public WebElement secondEmployeeDeleteOption;
	
	@FindBy(xpath= "//button[normalize-space()= 'Yes, Delete']")
	@CacheLookup
	public WebElement modalDeleteOption;
	
	public void clickOnAddButton() {
		addEmployeeButton.click();
	}
	
	public void enterFirstName(String fName) {
		firstNameInput.clear();
		firstNameInput.sendKeys(fName);;
	}
	
	public void enterMiddleName(String mName) {
		middleNameInput.clear();
		middleNameInput.sendKeys(mName);
	}
	
	public void enterLastName(String lName) {
		lastNameInput.clear();
		lastNameInput.sendKeys(lName);
	}
	
	public void saveEmployeeDetails() {
		addEmployeeSaveButton.click();
	}
	
	public void enterEmployeeName(String employeeName) {
		employeeNameInput.clear();
		employeeNameInput.sendKeys(employeeName);
	}
	
	public void searchEmployee() {
		employeeSearchButton.click();
	}
	
	public void deleteSecondEmployee() {
		secondEmployeeDeleteOption.click();
	}
	
	public void clickOnModalDeleteOption() {
		modalDeleteOption.click();
	}
	
}
