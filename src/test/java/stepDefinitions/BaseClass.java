package stepDefinitions;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.RecruitmentPage;



public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public RecruitmentPage rp;
	public PIMPage pp;
	
	public static String generateRandomString(int num) {
		String randomString= RandomStringUtils.randomAlphabetic(num);
		return randomString;
	}

}
