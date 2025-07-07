package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage{
	
	public AdminPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//h6[text()= 'Admin']")
	@CacheLookup
	public WebElement adminPageHeader;
	
	@FindBy(xpath= "//div[@role= 'row']")
	@CacheLookup
	public List<WebElement> tableRows;
	
	@FindBy(xpath= "//div[@role= 'row']//div[@role= 'columnheader']")
	@CacheLookup
	public List<WebElement> tableColumns;
	
	public int getTotalRows() {
		return tableRows.size();
	}
	
	public int getTotalColumns() {
		return tableColumns.size();
	}
	
	public void listAllAdmins() {
		System.out.println("The usernames are: ");
		for(int i=2; i<=getTotalRows(); i++) {
			String userName= driver.findElement(By.xpath("(//div[@role= 'row'])["+i+"]//div[2]//div")).getText();
			String status= driver.findElement(By.xpath("(//div[@role= 'row'])["+i+"]//div[5]//div")).getText();
			System.out.println(". "+userName+"->"+status);
		}
	}
	
	public void countEnabledAndDisabledUsers() {
		int enabledCount=0;
		int disabledCount=0;
		
		for(int i=2; i<=getTotalRows(); i++) {
			if(driver.findElement(By.xpath("(//div[@role= 'row'])["+i+"]//div[5]//div")).getText().equals("Enabled")) {
				enabledCount++;
			}
			else {
				disabledCount++;
			}
		}
		
		System.out.println("No. of Enabled users is: "+enabledCount+" and no. of disabled users is: "+disabledCount);
	}

}
