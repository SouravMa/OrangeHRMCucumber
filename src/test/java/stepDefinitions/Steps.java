package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.time.Duration;

import org.junit.Assert;



public class Steps extends BaseClass{
	
	// login-logout:
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "/Users/sourav.majhi/Documents/chromedriver-mac-x64/chromedriver");
		driver= new ChromeDriver();
		lp= new LoginPage(driver);
		hp= new HomePage(driver);	   
	}
	
	@When("Opens url: {string}")
	public void opens_url(String url) {
		driver.get(url);
	}

	@And("User enters email: {string} and password: {string}")
	public void user_enters_email_and_password(String userName, String password) {
		lp.waitForElement(lp.usernameInput, 20);
		lp.waitForElement(lp.passwordInput, 20);
		lp.enterUsername(userName);
		lp.enterPassword(password);
	}

	@And("Click on LOG IN")
	public void click_on_log_in() {
		lp.login();
	}

	@Then("We should see user dropdown")
	public void we_should_see_user_dropdown() {
		hp.waitForElement(hp.userDropdown, 20);
		hp.userDropdown.isDisplayed();
	}

	@When("we click on user dropdown")
	public void we_click_on_user_dropdown() {
		hp.openUserDropdown();
	}

	@And("click on logout option")
	public void click_on_logout_option() {
		hp.logOut();
	}

	@Then("We should see Login message")
	public void we_should_see_login_message() {
		lp.waitForElement(lp.loginMessage, 20);
		lp.loginMessage.isDisplayed();
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}
	
}
	

