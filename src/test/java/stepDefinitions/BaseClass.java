package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.RecruitmentPage;

public class BaseClass {
	
	public WebDriver driver;
	
	public LoginPage lp;
	public HomePage hp;
	public RecruitmentPage rp;
	public PIMPage pp;
	public AdminPage ap;
	public LeavePage lep;
	
	public static Logger logger;
	public Properties prop;
	
	
	public static String generateRandomString(int num) {
		String randomString= RandomStringUtils.randomAlphabetic(num);
		return randomString;
	}
	
	public static String generateRandomNumber(int num) {
		String randomNumber= RandomStringUtils.randomNumeric(num);
		return randomNumber;
	} 

} 