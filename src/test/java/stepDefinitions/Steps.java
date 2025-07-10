package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AdminPage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.RecruitmentPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;



public class Steps extends BaseClass{
	
	String firstName= generateRandomString(5);
	String middleName= generateRandomString(5);
	String lastName= generateRandomString(5);
	String email= generateRandomString(5)+generateRandomNumber(2)+"@gmail.com";
	
	String nameUsedForDeleteScenario= "";
	
	@Before()									// runs before the other methods of steps class and since this is a cucumber annotation, we cannot define
											// it in the baseclass thinking that steps class is anyway extending baseclass so it will be used here
											// automatically
	public void setup() throws IOException {
		
		//added logger:
		logger= Logger.getLogger("OrangeHRM");
		PropertyConfigurator.configure("/Users/sourav.majhi/eclipse-workspace/OrangeHRM/log4j.properties");
		
		//loading config.properties file
		prop= new Properties();
		FileInputStream fis= new FileInputStream("/Users/sourav.majhi/eclipse-workspace/OrangeHRM/config.properties");
		prop.load(fis);
		
		String browser= prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("geckoDriverPath"));
			driver= new FirefoxDriver();
		}
		
	}
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
	
		logger.info("***** Launching browser *****");
		lep= new LeavePage(driver);
		lp= new LoginPage(driver);
		hp= new HomePage(driver);	
		rp= new RecruitmentPage(driver);
		pp= new PIMPage(driver);
		ap= new AdminPage(driver);
	
	}
	
	// login-logout:
	
	@When("Opens url: {string}")
	public void opens_url(String url) {
		logger.info("Launching url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@And("User enters email: {string} and password: {string}")
	public void user_enters_email_and_password(String userName, String password) {
		logger.info("***** Entering email and password *****");
		lp.waitForElement(lp.usernameInput, 30);
		lp.waitForElement(lp.passwordInput, 30);
		lp.enterUsername(userName);
		lp.enterPassword(password);
	}

	@And("Click on LOG IN")
	public void click_on_log_in() {
		logger.info("***** Click on LOG IN *****");
		lp.login();
	}

	@Then("We should see user dropdown")
	public void we_should_see_user_dropdown() {
		logger.info("***** Verifying if the user dropdown exists after logging in *****");
		hp.waitForElement(hp.userDropdown, 30);
		hp.userDropdown.isDisplayed();
	}

	@When("we click on user dropdown")
	public void we_click_on_user_dropdown() {
		logger.info("***** Clicking on user dropdown *****");
		hp.openUserDropdown();
	}

	@And("click on logout option")
	public void click_on_logout_option() {
		logger.info("***** Clicking on logout option *****");
		hp.logOut();
	}

	@Then("We should see Login message")
	public void we_should_see_login_message() {
		logger.info("***** Verifying if the login message exists after logging out *****");
		lp.waitForElement(lp.loginMessage, 30);
		lp.loginMessage.isDisplayed();
	}

	@And("Close the browser")
	public void close_the_browser() {
		logger.info("***** Closing the browser *****");
		driver.quit();
	}
	
	// searching from menu:
	@When("We click on search bar")
	public void we_click_on_search_bar() {
		logger.info("***** CLicking on the search bar *****");
	    hp.clickOnSearch();
	}

	@When("Enter {string}")
	public void enter(String module) {
		logger.info("***** Entering module name *****");
		hp.enterSearchInput(module);
	}

	@When("Click on it")
	public void click_on_it() {
		logger.info("***** Clicking on search result *****");
		hp.clickOnSearchResult();
	}

	@Then("Recruitment module opens and we should see Recruitment header")
	public void recruitment_module_opens_and_we_should_see_recruitment_header() {
		logger.info("***** Verifying the existance of recruitment page header after opening the recruitment module *****");
		rp.waitForElement(rp.recuitmentPageHeader, 30);
		rp.recuitmentPageHeader.isDisplayed();
	}
	
	//creating user:
	@When("We click on PIM")
	public void we_click_on_pim() {
		logger.info("***** Clicking on the PIM module *****");
		hp.openPIMModule();
	}

	@Then("We should see the PIM header")
	public void we_should_see_the_pim_header() {
		logger.info("***** Verifying the existance of PIM page header after opening the PIM module *****");
		pp.waitForElement(pp.pimPageHeader, 30);
		pp.pimPageHeader.isDisplayed();
	}

	@When("We click on Add button")
	public void we_click_on_add_button() {
		logger.info("***** Clicking on Add button *****");
		pp.clickOnAddButton();
	}

	@And("Enter the required details")
	public void enter_the_required_details() {
		logger.info("***** Entering the first name, middle name and last name *****");
		pp.waitForElement(pp.firstNameInput, 30);
		pp.enterFirstName(firstName);
		pp.enterMiddleName(middleName);
		pp.enterLastName(lastName);
	}
	
	@And("Save it")
	public void save_it() {
		logger.info("***** Saving the employee details *****");
		pp.saveEmployeeDetails();
	}

	@Then("Employee gets added and we should see the employee header name")
	public void employee_gets_added_and_we_should_see_the_employee_header_name() {
		logger.info("***** Verifying the existance of employee name page header after adding the employee *****");
		pp.waitForElement(pp.emmployeeNameHeader, 30);
		pp.emmployeeNameHeader.isDisplayed();
	}
	
	// search newly created user:
	@When("We click on PIM module again")
	public void we_click_on_pim_module_again() {
		logger.info("***** Clicking on PIM module again *****");
		//since it gives stale element exception
		WebElement pimModule= driver.findElement(By.xpath("//a[contains(@href, 'Pim')]"));
		pimModule.click();
	}

	@When("We enter employee name")
	public void we_enter_employee_name() {
		logger.info("***** Entering full name in the Employee name field *****");
		pp.waitForElement(pp.employeeNameInput, 30);
		pp.enterEmployeeName(firstName+" "+middleName+" "+lastName);
	}

	@When("We click on Search button")
	public void we_click_on_search_button() {
		logger.info("***** Clicking on search button *****");
		pp.searchEmployee();
	}

	@Then("Employee name is fetched and should be equal to the searched employee name")
	public void employee_name_is_fetched_and_should_be_equal_to_the_searched_employee_name() {
		logger.info("***** Verifying if the correct employee name appears in the search results *****");
		pp.waitForElement(pp.searchedEmployeeName, 30);
		pp.searchedEmployeeName.isDisplayed();
		String searchedName= firstName+" "+middleName;
		Assert.assertEquals(pp.searchedEmployeeName.getText(), searchedName);
	}
	
	//scenario outline for Users feature
	@When("Enter the {string}, {string} and {string}")
	public void enter_the_and(String firstName, String middleName, String lastName) {
		logger.info("***** Entering the first name, middle name and last name *****");
		pp.waitForElement(pp.firstNameInput, 30);
		pp.enterFirstName(firstName);
		pp.enterMiddleName(middleName);
		pp.enterLastName(lastName);
	}
	@When("We enter {string}, {string} and {string} in the Employee Name field")
	public void we_enter_and_in_the_employee_name_field(String firstName, String middleName, String lastName) {
		logger.info("***** Entering full name in the Employee name field *****");
		pp.waitForElement(pp.employeeNameInput, 30);
		pp.enterEmployeeName(firstName+" "+middleName+" "+lastName);
	}
	@Then("Employee name is fetched")
	public void employee_name_is_fetched() {
		logger.info("***** Verifying if the emoployee name is fetched *****");
		pp.waitForElement(pp.searchedEmployeeName, 30);
		pp.searchedEmployeeName.isDisplayed();
	}
	
	//listing all admins:
	@When("We click on Admin")
	public void we_click_on_admin() {
		logger.info("***** Clicking on Admin module *****");
		hp.openAdminModule();
	}

	@Then("We should see the Admin header")
	public void we_should_see_the_admin_header() {
		logger.info("***** Verifying the existance of Admin page header after opening the Admin module *****");
		ap.waitForElement(ap.adminPageHeader, 30);
		ap.adminPageHeader.isDisplayed();
	}

	@Then("We should list down all the admins with their statuses")
	public void we_should_list_down_all_the_admins_with_their_statuses() {
		logger.info("***** Listing down all the admins with their statuses *****");
		ap.listAllAdmins();
	}
	
	//counting the number of enabled and disabled admins:
	@Then("We count the number of enabled and disabled admins")
	public void we_count_the_number_of_enabled_and_disabled_admins() {
		logger.info("***** Counting the number of enabled and disabled admins *****");
		ap.countEnabledAndDisabledUsers();
	}
	
	//deleting user:
	@When("We click on the delete button of the second employee")
	public void we_click_on_the_delete_button_of_the_second_employee() {
		logger.info("***** Clicking on the delete button of the second employee *****");
		pp.waitForElement(pp.secondEmployeeForDeletion, 30);
		nameUsedForDeleteScenario= pp.secondEmployeeForDeletion.getText();
		pp.deleteSecondEmployee();
	}

	@And("Click on the Delete button of the pop-up")
	public void click_on_the_delete_button_of_the_pop_up() throws InterruptedException {
		logger.info("***** Clicking on the modal delete option *****");
		pp.clickOnModalDeleteOption();
	}
	
	@And("We enter deleted employee name")
	public void we_enter_deleted_employee_name() {
		logger.info("***** ENter deleted employee name *****");
		pp.waitForElement(pp.employeeNameInput, 30);
		pp.enterEmployeeName(nameUsedForDeleteScenario);
	}

	@Then("Employee name should not be visible")
	public void employee_name_should_not_be_visible() {
		try {
			pp.secondEmployeeForDeletion.isDisplayed();
            logger.error("***** Employee name still visible on page *****");
            Assert.fail();
		}
		catch(Exception e) {
			logger.error("***** Employee name not visible on page *****");
		}
	}
	
	//apply for leave:
	@When("User clicks on Apply section")
	public void user_clicks_on_apply_section() {
		logger.info("***** Clicking on Apply section *****");
		lep.waitForElement(lep.applySection, 30);
		lep.openApplySection();
	}
	
	@When("We click on Leave")
	public void we_click_on_leave() {
		logger.info("***** Clicking on Leave module *****");
		hp.openLeaveModule();
	}

	@Then("We should see the Leave header")
	public void we_should_see_the_leave_header() {
		logger.info("***** Verifying the existance of Leave page header after opening the Leave module *****");
		lep.waitForElement(lep.leavePageHeader, 30);
		lep.leavePageHeader.isDisplayed();
	}

	@And("User selects leave type")
	public void user_selects_leave_type() {
		logger.info("***** Selecting Leave Type *****");
		lep.selectLeaveType();
	}

	@And("Selects from date")
	public void selects_from_date() {
		logger.info("***** Selecting From Date *****");
		lep.selectFromDate();
	}

	@And("Selects to date")
	public void selects_to_date() {
		logger.info("***** Selecting To Date *****");
		lep.selectToDate();
	}

	@And("Click on Apply")
	public void click_on_apply() {
		logger.info("***** Clicking on Apply *****");
		lep.clickOnApply();
	}

	@Then("User should see the success message")
	public void user_should_see_the_success_message() {
		logger.info("***** Verifying if success message is visible after applying for leave *****");
		lep.waitForElement(lep.successMessage, 30);
		lep.successMessage.isDisplayed();
	}
	
	// candidate application:
	
	@And("We click on Recruitment")
	public void we_click_on_recruitment() {
		logger.info("***** Clicking on Recruitment module *****");
		hp.openRecruitmentModule();
	}

	@Then("We should see the Recruitment header")
	public void we_should_see_the_recruitment_header() {
		logger.info("***** Verifying the existance of Recruitment page header after opening the Recruitment module *****");
		ap.waitForElement(rp.recuitmentPageHeader, 30);
		rp.recuitmentPageHeader.isDisplayed();
	}

	@When("User enters full name")
	public void user_enters_full_name() {
		logger.info("***** Entering full name *****");
		rp.enterFullName(firstName, middleName, lastName);
	}

	@And("User enters email")
	public void user_enters_email() {
		logger.info("***** Entering email *****");
		rp.enterEmail(email);
	}

	@And("User clicks on Save")
	public void user_clicks_on_save() {
		logger.info("***** Clicking on Save *****");
		rp.clickOnSave();
	}
}
	

