package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath= "//li//a[text()= 'Vacancies']")
	@CacheLookup
	public WebElement vacanciesSection;
	
	@FindBy(xpath= "//h5[text()= 'Vacancies']")
	@CacheLookup
	public WebElement vacanciesHeader;
	
	@FindBy(xpath= "//div[@role= 'table']")
	@CacheLookup
	public WebElement vacanciesTable;
	
	@FindBy(xpath= "(//div[@role= 'row'])[1]")
	@CacheLookup
	public WebElement vacanciesTableColumnHeaderRow;
	
	@FindBy(xpath= "//div[@role= 'row']")
	@CacheLookup
	public List<WebElement> vacanciesRows;
	
	@FindBy(xpath= "(//div[@role= 'row'])[2]//div[@role= 'cell']")
	@CacheLookup
	public List<WebElement> vacanciesColumns;
	
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
	
	public void clickOnVacancies() {
		waitForElement(vacanciesSection, 30);
		vacanciesSection.click();
	}
	
	public int getTotalRows() {
		return vacanciesRows.size();
	}
	
	public int getTotalColumns() {
		return vacanciesColumns.size();
	}
	
	public void listAllVacancies() {

		System.out.println("The vacancies are:");
		for(int i=2; i<getTotalRows(); i++) {
			
			String vacancy= driver.findElement(By.xpath("(//div[@role= 'row'])["+i+"]//div[2]//div")).getText();
			String jobTitle= driver.findElement(By.xpath("(//div[@role= 'row'])["+i+"]//div[3]//div")).getText();
			String status= driver.findElement(By.xpath("(//div[@role= 'row'])["+i+"]//div[5]//div")).getText();
			
			System.out.println(". "+vacancy+"->"+jobTitle+"->"+status);
		}
	}
	
}
