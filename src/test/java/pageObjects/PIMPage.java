package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import stepDefinitions.Steps;

public class PIMPage extends BasePage{

public WebDriver driver;
	
	public PIMPage(WebDriver driver) {
		super(driver);
	}
	
	Steps steps= new Steps();
	
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
	
}
