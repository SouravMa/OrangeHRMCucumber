package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.RecruitmentPage;


import org.junit.Assert;



public class Steps extends BaseClass{
	
	String firstName= generateRandomString(5);
	String middleName= generateRandomString(5);
	String lastName= generateRandomString(5);
	
	// login-logout:
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "/Users/sourav.majhi/Documents/chromedriver-mac-x64/chromedriver");
		driver= new ChromeDriver();
		lp= new LoginPage(driver);
		hp= new HomePage(driver);	
		rp= new RecruitmentPage(driver);
		pp= new PIMPage(driver);
		ap= new AdminPage(driver);
	
	}
	
	@When("Opens url: {string}")
	public void opens_url(String url) {
		driver.get(url);
	}

	@And("User enters email: {string} and password: {string}")
	public void user_enters_email_and_password(String userName, String password) {
		lp.waitForElement(lp.usernameInput, 30);
		lp.waitForElement(lp.passwordInput, 30);
		lp.enterUsername(userName);
		lp.enterPassword(password);
	}

	@And("Click on LOG IN")
	public void click_on_log_in() {
		lp.login();
	}

	@Then("We should see user dropdown")
	public void we_should_see_user_dropdown() {
		hp.waitForElement(hp.userDropdown, 30);
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
		lp.waitForElement(lp.loginMessage, 30);
		lp.loginMessage.isDisplayed();
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}
	
	// searching from menu:
	@When("We click on search bar")
	public void we_click_on_search_bar() {
	    hp.clickOnSearch();
	}

	@When("Enter {string}")
	public void enter(String string) {
		hp.enterSearchInput(string);
	}

	@When("Click on it")
	public void click_on_it() {
		hp.clickOnSearchResult();
	}

	@Then("Recruitment module opens and we should see Recruitment header")
	public void recruitment_module_opens_and_we_should_see_recruitment_header() {
		rp.waitForElement(rp.recuitmentPageHeader, 30);
		rp.recuitmentPageHeader.isDisplayed();
	}
	
	//creating user:
	@When("We click on PIM")
	public void we_click_on_pim() {
		hp.openPIMModule();
	}

	@Then("We should see the PIM header")
	public void we_should_see_the_pim_header() {
		pp.waitForElement(pp.pimPageHeader, 30);
		pp.pimPageHeader.isDisplayed();
	}

	@When("we click on Add button")
	public void we_click_on_add_button() {
		pp.clickOnAddButton();
	}

	@And("Enter the required details")
	public void enter_the_required_details() {
		pp.waitForElement(pp.firstNameInput, 30);
		pp.enterFirstName(firstName);
		pp.enterMiddleName(middleName);
		pp.enterLastName(lastName);
	}
	
	@And("Save it")
	public void save_it() {
		pp.saveEmployeeDetails();
	}

	@Then("Employee gets added and we should see the employee header name")
	public void employee_gets_added_and_we_should_see_the_employee_header_name() {
		pp.waitForElement(pp.emmployeeNameHeader, 30);
		pp.emmployeeNameHeader.isDisplayed();
	}
	
	// search newly created user:
	@When("We click on PIM module again")
	public void we_click_on_pim_module_again() {
		
		//since it gives stale element exception
		WebElement pimModule= driver.findElement(By.xpath("//a[contains(@href, 'Pim')]"));
		pimModule.click();
	}

	@When("We enter employee name")
	public void we_enter_employee_name() {
		pp.waitForElement(pp.employeeNameInput, 30);
		pp.enterEmployeeName(firstName+" "+middleName+" "+lastName);
	}

	@When("We click on Search button")
	public void we_click_on_search_button() {
		pp.searchEmployee();
	}

	@Then("Employee name is fetched and should be equal to the searched employee name")
	public void employee_name_is_fetched_and_should_be_equal_to_the_searched_employee_name() {
		pp.waitForElement(pp.searchedEmployeeName, 30);
		pp.searchedEmployeeName.isDisplayed();
		String searchedName= firstName+" "+middleName;
		Assert.assertEquals(pp.searchedEmployeeName.getText(), searchedName);
	}
	
	//scenario outline for Users feature
	@When("Enter the {string}, {string} and {string}")
	public void enter_the_and(String firstName, String middleName, String lastName) {
		pp.waitForElement(pp.firstNameInput, 30);
		pp.enterFirstName(firstName);
		pp.enterMiddleName(middleName);
		pp.enterLastName(lastName);
	}
	@When("We enter {string}, {string} and {string} in the Employee Name field")
	public void we_enter_and_in_the_employee_name_field(String firstName, String middleName, String lastName) {
		pp.waitForElement(pp.employeeNameInput, 30);
		pp.enterEmployeeName(firstName+" "+middleName+" "+lastName);
	}
	@Then("Employee name is fetched")
	public void employee_name_is_fetched() {
		pp.waitForElement(pp.searchedEmployeeName, 30);
		pp.searchedEmployeeName.isDisplayed();
	}
	
	//listing all admins:
	@When("We click on Admin")
	public void we_click_on_admin() {
		hp.adminModule.click();
	}

	@Then("We should see the Admin header")
	public void we_should_see_the_admin_header() {
		ap.waitForElement(ap.adminPageHeader, 30);
		ap.adminPageHeader.isDisplayed();
	}

	@Then("We should list down all the admins with their statuses")
	public void we_should_list_down_all_the_admins_with_their_statuses() {
		ap.listAllAdmins();
	}
	
	//counting the number of enabled and disabled admins:
	@Then("We count the number of enabled and disabled admins")
	public void we_count_the_number_of_enabled_and_disabled_admins() {
		ap.countEnabledAndDisabledUsers();
	}
	
}
	

