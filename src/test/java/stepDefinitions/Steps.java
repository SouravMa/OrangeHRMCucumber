package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

import org.junit.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PostLogoutPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public PostLogoutPage plp;
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "/Users/sourav.majhi/Documents/chromedriver-mac-x64/chromedriver");
		driver= new ChromeDriver();
	    lp= new LoginPage(driver);
	    hp= new HomePage(driver);
	    plp= new PostLogoutPage(driver);
	}

	@When("Opens url: {string}")
	public void opens_url(String url) {
		driver.get(url);
	}

	@And("User enters email: {string} and password: {string}")
	public void user_enters_email_and_password(String email, String password) {
		lp.enterUsername(email);
		lp.enterPassword(password);
	}

	@And("Click on LOG IN")
	public void click_on_log_in() {
		lp.login();
	}

	@Then("We should be able to see Logout link")
	public void we_should_be_able_to_see_logout_link() {
		hp.logoutLink.isDisplayed();
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
		hp.logout();
	}

	@Then("The page header should be {string}")
	public void the_page_header_should_be(String logoutHeader) {
		Assert.assertEquals(plp.logoutHeader.getText(), logoutHeader);
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
