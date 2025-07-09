package pageObjects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public WebDriverWait wait;
	public static Logger logger;
		
	public BasePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		//added logger:
		logger= Logger.getLogger("OrangeHRM");
		PropertyConfigurator.configure("/Users/sourav.majhi/eclipse-workspace/OrangeHRM/log4j.properties");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void waitForElement(WebElement waitElement, long timeInSeconds){
        wait= new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(waitElement));
    }
	
}
