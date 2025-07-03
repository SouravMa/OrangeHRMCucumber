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
	
}
